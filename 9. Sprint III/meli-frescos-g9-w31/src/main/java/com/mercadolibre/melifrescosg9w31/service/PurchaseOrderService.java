package com.mercadolibre.melifrescosg9w31.service;

import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderWithBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductStockError;
import com.mercadolibre.melifrescosg9w31.dtos.PurchaseOrderProductDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.PurchaseOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateOrderProductsRequest;
import com.mercadolibre.melifrescosg9w31.dtos.response.OrderProductsResponse;
import com.mercadolibre.melifrescosg9w31.dtos.response.OrderProductsWithBatchResponse;
import com.mercadolibre.melifrescosg9w31.dtos.response.PurchaseOrderResponse;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.exceptions.StockException;
import com.mercadolibre.melifrescosg9w31.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService implements IPurchaseOrderService{

    private final IProductRepository productRepo;
    private final IBuyerRepository buyerRepo;
    private final IPurchaseOrderRepository orderRepo;
    private final IBatchRepository batchRepo;
    private final IWarehouseRepository warehouseRepository;

    @Override
    @Transactional
    public PurchaseOrderResponse createOrder(PurchaseOrderRequest request) {
        List<ProductStockError> errors = new ArrayList<>();
        double total = 0.0;
        Long warehouseId = null;

        Buyer buyer = buyerRepo.findById(request.getBuyerId())
                .orElseThrow(() -> new NotFoundException("Buyer with ID: " + request.getBuyerId() + " does not exist."));

        PurchaseOrder order = new PurchaseOrder();
        order.setCreationDate(request.getDate());
        order.setBuyer(buyer);
        order.setState(request.getOrderStatus().getStatusCode());


        // Lógica de productos
        List<PurchaseOrderItem> items = new ArrayList<>();
        for (PurchaseOrderProductDTO prodReq : request.getProducts()) {
            Optional<Product> opProduct = productRepo.findById(prodReq.getProductId().longValue());
            if (opProduct.isEmpty()) {
                throw new NotFoundException("Product with ID: " + prodReq.getProductId() + " does not exist.");
            }
            if (prodReq.getAmount() <= 0) {
                throw new BadRequestException("Product amount must be greater than zero for product ID: " + prodReq.getProductId() + ".");
            }
            Product prod = opProduct.get();

            // ¿A qué warehouses tiene stock este producto?
            // Para todos los batches válidos ordenados por expiración, próximos a vencer
            LocalDate hoy = LocalDate.now();
            LocalDate tresSemanas = hoy.plusWeeks(3);

            List<Batch> candidates = batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(
                    prod.getId(), tresSemanas);


            // Filtrar por warehouse: si warehouseId no está aún, elegimos primero; si ya está, filtramos solo ese
            if (warehouseId == null && !candidates.isEmpty()) {
                warehouseId = candidates.get(0).getSector().getWarehouse().getId();
            }

            Long finalWarehouseId = warehouseId;

            List<Batch> candidatesInWarehouse = candidates.stream()
                    .filter(b -> b.getSector().getWarehouse().getId().equals(finalWarehouseId))
                    .toList();

            if (candidatesInWarehouse.isEmpty()) {
                throw new BadRequestException("The product " + prod.getName() + " with ID: " + prod.getId() +
                        " does not have stock in the common warehouse and its expiration date is less than three weeks.");
            }

            // Tomar el batch próximo a vencer
            Batch batch = candidatesInWarehouse.get(0);

            // Verificar stock suficiente en ese batch
            if (batch.getActualQuantity() < prodReq.getAmount()) {
                errors.add(new ProductStockError(prodReq.getProductId(),
                        "Not enough stock in the next-to-expire batch for product ID: " + prodReq.getProductId()));
                continue;
            }


            double subtotal = prod.getPrice().doubleValue() * prodReq.getAmount();
            total += subtotal;

            PurchaseOrderItem item = new PurchaseOrderItem();
            item.setProduct(prod);
            item.setAmount(prodReq.getAmount());
            item.setUnitPriceAtSale(prod.getPrice());
            item.setPurchaseOrder(order);
            items.add(item);
        }

        if (!errors.isEmpty()) {
            throw new StockException(errors);
        }

        // Persistir la orden y los items
        order.setItems(items);
        order.setWarehouse(warehouseRepository.findById(warehouseId).get());
        orderRepo.save(order); // asume cascade con items

        // Retornar response
        PurchaseOrderResponse resp = new PurchaseOrderResponse();
        resp.setTotalPrice(total);
        return resp;
    }

    //ENDPOINT 4
    @Override
    @Transactional(readOnly = true)
    public OrderProductsResponse getOrderProducts(Long orderId) {
        PurchaseOrder order = orderRepo.findById(orderId).orElseThrow(() -> new NotFoundException("Order not exist with ID: " + orderId + "."));

        List<PurchaseOrderItem> items = order.getItems();
        List<ProductInOrderDTO> products = items.stream()
                .map(item -> new ProductInOrderDTO(
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getAmount(),
                        item.getUnitPriceAtSale()
                ))
                .toList();

        OrderProductsResponse response = new OrderProductsResponse();
        response.setOrderId(orderId);
        response.setProducts(products);
        return response;
    }

    //ENDPOINT 5
    @Transactional
    public OrderProductsWithBatchResponse updateOrderProducts(Long orderId, UpdateOrderProductsRequest req) {
        PurchaseOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not exist with ID: " + orderId + "."));

        if (!"CARRITO".equalsIgnoreCase(order.getState())) {
            throw new BadRequestException("Just orders in CARRITO state can be updated.");
        }

        // 1. Chequear warehouse común de los productos.
        Long warehouseId = null;
        //Productos con error de stock
        List<ProductStockError> errors = new ArrayList<>();
        //Nuevos items
        List<PurchaseOrderItem> newItems = new ArrayList<>();

        // Determinar el warehouse para el primer producto
        for (PurchaseOrderProductDTO prodReq : req.getProducts()) {
            Product prod = productRepo.findById(prodReq.getProductId().longValue())
                    .orElseThrow(() -> new NotFoundException("Product with id: " + prodReq.getProductId() + " does not exist."));

            // ¿A qué warehouses tiene stock este producto?
            // Para todos los batches válidos ordenados por expiración, próximos a vencer
            LocalDate hoy = LocalDate.now();
            LocalDate tresSemanas = hoy.plusWeeks(3);
            List<Batch> candidates = batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(
                    prod.getId(), tresSemanas);

            // Filtrar por warehouse: si warehouseId no está aún, elegimos primero; si ya está, filtramos solo ese
            if (warehouseId == null && !candidates.isEmpty()) {
                warehouseId = candidates.get(0).getSector().getWarehouse().getId();
            }
            Long finalWarehouseId = warehouseId;
            List<Batch> candidatesInWarehouse = candidates.stream()
                    .filter(b -> b.getSector().getWarehouse().getId().equals(finalWarehouseId))
                    .toList();

            if (candidatesInWarehouse.isEmpty()) {
                throw new BadRequestException("The product " + prod.getName() + " with ID: " + prod.getId() +
                        " does not have stock in the common warehouse and its expiration date is less than three weeks.");
            }

            // Tomar el batch próximo a vencer
            Batch batch = candidatesInWarehouse.get(0);

            // Verificar stock suficiente en ese batch
            if (batch.getActualQuantity() < prodReq.getAmount()) {
                errors.add(new ProductStockError(prodReq.getProductId(),
                        "Not enough stock in the next-to-expire batch for product ID: " + prodReq.getProductId()));
                continue;
            }

            // CREAR EL ITEM con batch asignado
            PurchaseOrderItem item = new PurchaseOrderItem();
            item.setProduct(prod);
            item.setAmount(prodReq.getAmount());
            item.setUnitPriceAtSale(prod.getPrice());
            item.setPurchaseOrder(order);
            item.setBatch(batch);
            newItems.add(item);
        }

        if (!errors.isEmpty()) throw new StockException(errors);

        // Limpiar y setear nuevos ítems
        order.getItems().clear();
        order.getItems().addAll(newItems);

        // Setear el warehouse ANTES de persistir
        if (warehouseId == null)
            throw new BadRequestException("Not warehouse found for the products in the order.");

        order.setWarehouse(
                warehouseRepository.findById(warehouseId)
                        .orElseThrow(() -> new NotFoundException("Warehouse not found."))
        );

        orderRepo.save(order);

        // Respuesta: Devuelve productos de la orden y el batch asignado a cada uno
        List<ProductInOrderWithBatchDTO> respProds = newItems.stream()
                .map(i -> new ProductInOrderWithBatchDTO(
                        i.getProduct().getId(),
                        i.getProduct().getName(),
                        i.getAmount(),
                        i.getUnitPriceAtSale(),
                        i.getBatch().getId(),
                        i.getBatch().getExpireDate()))
                .toList();

        return new OrderProductsWithBatchResponse(order.getId(), respProds);
    }
}