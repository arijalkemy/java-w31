package com.mercadolibre.melifrescosg9w31.unit.service;

import com.mercadolibre.melifrescosg9w31.dtos.OrderStatusDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderDTO;
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
import com.mercadolibre.melifrescosg9w31.service.PurchaseOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ServicePurchaseOrderTest {
    @Mock
    private IPurchaseOrderRepository orderRepo;
    @Mock
    private IBuyerRepository buyerRepo;
    @Mock
    private IProductRepository productRepo;
    @Mock
    private IBatchRepository batchRepo;
    @Mock
    private IWarehouseRepository warehouseRepository;

    @InjectMocks
    private PurchaseOrderService purchaseOrderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //Req 2 Endpoint 3
    @Test
    void createOrder_success() {
        // Arrange
        Long buyerId = 1L;
        Long productId = 2L;
        Long warehouseId = 3L;
        int amount = 5;

        Buyer buyer = new Buyer();
        buyer.setId(buyerId);

        Product product = new Product();
        product.setId(productId);
        product.setName("Test Product");
        product.setPrice(new BigDecimal("10.00"));

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);

        Sector sector = new Sector();
        sector.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setId(100L);
        batch.setProduct(product);
        batch.setActualQuantity(10);
        batch.setSector(sector);
        batch.setExpireDate(LocalDate.now().plusWeeks(4));

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");

        PurchaseOrderProductDTO prodReq = new PurchaseOrderProductDTO();
        prodReq.setProductId(productId.intValue());
        prodReq.setAmount(amount);

        PurchaseOrderRequest request = new PurchaseOrderRequest();
        request.setBuyerId(buyerId);
        request.setDate(LocalDate.now());
        request.setOrderStatus(status);
        request.setProducts(List.of(prodReq));

        when(buyerRepo.findById(buyerId)).thenReturn(Optional.of(buyer));
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(productId), any()))
                .thenReturn(List.of(batch));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(orderRepo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        PurchaseOrderResponse response = purchaseOrderService.createOrder(request);

        // Assert
        assertNotNull(response);
        assertEquals(amount * product.getPrice().doubleValue(), response.getTotalPrice());
    }

    @Test
    void createOrder_buyerNotFound_throwsNotFoundException() {
        PurchaseOrderRequest request = new PurchaseOrderRequest();
        request.setBuyerId(1L);

        when(buyerRepo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> purchaseOrderService.createOrder(request));
    }

    @Test
    void createOrder_productNotFound_throwsNotFoundException() {
        PurchaseOrderRequest request = new PurchaseOrderRequest();
        request.setBuyerId(1L);
        request.setProducts(List.of(new PurchaseOrderProductDTO(2, 1)));

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        request.setOrderStatus(status);

        Buyer buyer = new Buyer();
        buyer.setId(1L);

        when(buyerRepo.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepo.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> purchaseOrderService.createOrder(request));
    }

    @Test
    void createOrder_noBatchInWarehouse_throwsBadRequestException() {
        PurchaseOrderRequest request = new PurchaseOrderRequest();
        request.setBuyerId(1L);
        request.setProducts(List.of(new PurchaseOrderProductDTO(2, 1)));

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        request.setOrderStatus(status);

        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Product product = new Product();
        product.setId(2L);

        when(buyerRepo.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepo.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(2L), any()))
                .thenReturn(List.of());

        assertThrows(BadRequestException.class, () -> purchaseOrderService.createOrder(request));
    }

    @Test
    void createOrder_noStockInBatch_throwsStockException() {
        PurchaseOrderRequest request = new PurchaseOrderRequest();
        request.setBuyerId(1L);
        request.setProducts(List.of(new PurchaseOrderProductDTO(2, 10)));

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        request.setOrderStatus(status);

        Buyer buyer = new Buyer();
        buyer.setId(1L);

        Product product = new Product();
        product.setId(2L);
        product.setPrice(new BigDecimal("10.00"));

        Sector sector = new Sector();
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        sector.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setId(100L);
        batch.setProduct(product);
        batch.setActualQuantity(5); // Menor que la cantidad pedida
        batch.setSector(sector);
        batch.setExpireDate(LocalDate.now().plusWeeks(4));

        when(buyerRepo.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepo.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(2L), any()))
                .thenReturn(List.of(batch));

        assertThrows(StockException.class, () -> purchaseOrderService.createOrder(request));
    }

    //Req 2 Endpoint 4
    @Test
    void getOrderProducts_returnsOrderProductsResponse() {
        // Arrange
        Long orderId = 1L;
        Product product = new Product();
        product.setId(10L);
        product.setName("Test Product");
        product.setPrice(new BigDecimal("100.00"));

        PurchaseOrderItem item = new PurchaseOrderItem();
        item.setProduct(product);
        item.setAmount(2);
        item.setUnitPriceAtSale(product.getPrice());

        PurchaseOrder order = new PurchaseOrder();
        order.setId(orderId);
        order.setItems(List.of(item));

        when(orderRepo.findById(orderId)).thenReturn(Optional.of(order));

        // Act
        OrderProductsResponse response = purchaseOrderService.getOrderProducts(orderId);

        // Assert
        assertEquals(orderId, response.getOrderId());
        assertEquals(1, response.getProducts().size());

        ProductInOrderDTO dto = response.getProducts().get(0);
        assertEquals(product.getId(), dto.getId());
        assertEquals(product.getName(), dto.getName());
        assertEquals(item.getUnitPriceAtSale(), dto.getPrice());
    }

    @Test
    void getOrderProducts_orderNotFound_throwsException() {
        Long orderId = 99L;
        when(orderRepo.findById(orderId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            purchaseOrderService.getOrderProducts(orderId);
        });
    }

    //Req 2 Endpoint 5
    @Test
    void updateOrderProducts_success() {
        Long orderId = 1L;
        Long productId = 2L;
        Long warehouseId = 3L;
        int amount = 5;

        Product product = new Product();
        product.setId(productId);
        product.setName("Test Product");
        product.setPrice(new BigDecimal("10.00"));

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);

        Sector sector = new Sector();
        sector.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setId(100L);
        batch.setProduct(product);
        batch.setActualQuantity(10);
        batch.setSector(sector);
        batch.setExpireDate(LocalDate.now().plusWeeks(4));

        PurchaseOrder order = new PurchaseOrder();
        order.setId(orderId);
        order.setState("CARRITO");
        order.setItems(new ArrayList<>());

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        req.setProducts(List.of(new PurchaseOrderProductDTO(productId.intValue(), amount)));

        when(orderRepo.findById(orderId)).thenReturn(Optional.of(order));
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(productId), any()))
                .thenReturn(List.of(batch));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Optional.of(warehouse));
        when(orderRepo.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        OrderProductsWithBatchResponse response = purchaseOrderService.updateOrderProducts(orderId, req);

        assertNotNull(response);
        assertEquals(orderId, response.getOrderId());
        assertEquals(1, response.getProducts().size());
        assertEquals(productId, response.getProducts().get(0).getProductId());
    }

    @Test
    void updateOrderProducts_orderNotFound_throwsNotFoundException() {
        when(orderRepo.findById(1L)).thenReturn(Optional.empty());
        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        assertThrows(NotFoundException.class, () -> purchaseOrderService.updateOrderProducts(1L, req));
    }

    @Test
    void updateOrderProducts_stateNotCarrito_throwsBadRequestException() {
        PurchaseOrder order = new PurchaseOrder();
        order.setId(1L);
        order.setState("CERRADO");
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));
        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        assertThrows(BadRequestException.class, () -> purchaseOrderService.updateOrderProducts(1L, req));
    }

    @Test
    void updateOrderProducts_productNotFound_throwsNotFoundException() {
        PurchaseOrder order = new PurchaseOrder();
        order.setId(1L);
        order.setState("CARRITO");
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));
        when(productRepo.findById(2L)).thenReturn(Optional.empty());

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        req.setProducts(List.of(new PurchaseOrderProductDTO(2, 1)));

        assertThrows(NotFoundException.class, () -> purchaseOrderService.updateOrderProducts(1L, req));
    }

    @Test
    void updateOrderProducts_noBatchInWarehouse_throwsBadRequestException() {
        PurchaseOrder order = new PurchaseOrder();
        order.setId(1L);
        order.setState("CARRITO");
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));

        Product product = new Product();
        product.setId(2L);

        when(productRepo.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(2L), any()))
                .thenReturn(List.of());

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        req.setProducts(List.of(new PurchaseOrderProductDTO(2, 1)));

        assertThrows(BadRequestException.class, () -> purchaseOrderService.updateOrderProducts(1L, req));
    }

    @Test
    void updateOrderProducts_noStockInBatch_throwsStockException() {
        PurchaseOrder order = new PurchaseOrder();
        order.setId(1L);
        order.setState("CARRITO");
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));

        Product product = new Product();
        product.setId(2L);
        product.setPrice(new BigDecimal("10.00"));

        Warehouse warehouse = new Warehouse();
        warehouse.setId(3L);

        Sector sector = new Sector();
        sector.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setId(100L);
        batch.setProduct(product);
        batch.setActualQuantity(2); // Menor que la cantidad pedida
        batch.setSector(sector);
        batch.setExpireDate(LocalDate.now().plusWeeks(4));

        when(productRepo.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(2L), any()))
                .thenReturn(List.of(batch));

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        req.setProducts(List.of(new PurchaseOrderProductDTO(2, 5)));

        assertThrows(StockException.class, () -> purchaseOrderService.updateOrderProducts(1L, req));
    }

    @Test
    void updateOrderProducts_warehouseNotFound_throwsNotFoundException() {
        PurchaseOrder order = new PurchaseOrder();
        order.setId(1L);
        order.setItems(new ArrayList<>());
        order.setState("CARRITO");
        when(orderRepo.findById(1L)).thenReturn(Optional.of(order));

        Product product = new Product();
        product.setId(2L);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(3L);

        Sector sector = new Sector();
        sector.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setId(100L);
        batch.setProduct(product);
        batch.setActualQuantity(10);
        batch.setSector(sector);
        batch.setExpireDate(LocalDate.now().plusWeeks(4));

        when(productRepo.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq(2L), any()))
                .thenReturn(List.of(batch));
        when(warehouseRepository.findById(3L)).thenReturn(Optional.empty());

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        req.setProducts(List.of(new PurchaseOrderProductDTO(2, 1)));

        assertThrows(NotFoundException.class, () -> purchaseOrderService.updateOrderProducts(1L, req));
    }

    @Test
    void updateOrderProducts_noCommonWarehouse_throwsBadRequestException() {
        Long orderId = 1L;
        int productId = 2;

        PurchaseOrder order = new PurchaseOrder();
        order.setId(orderId);
        order.setState("CARRITO");

        UpdateOrderProductsRequest req = new UpdateOrderProductsRequest();
        req.setProducts(List.of(new PurchaseOrderProductDTO(productId, 1)));

        Product product = new Product();
        product.setId((long) productId);

        when(orderRepo.findById(orderId)).thenReturn(Optional.of(order));
        when(productRepo.findById((long) productId)).thenReturn(Optional.of(product));
        // Simula que no hay batches válidos para ningún producto
        when(batchRepo.findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(eq((long) productId), any()))
                .thenReturn(List.of());

        assertThrows(BadRequestException.class, () -> purchaseOrderService.updateOrderProducts(orderId, req));
    }
}

