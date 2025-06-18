package com.mercadolibre.melifrescosg9w31.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.melifrescosg9w31.dtos.OrderStatusDTO;
import com.mercadolibre.melifrescosg9w31.dtos.PurchaseOrderProductDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.PurchaseOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.PurchaseOrderRequestWrapper;
import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateOrderProductsRequest;
import com.mercadolibre.melifrescosg9w31.entity.Role;
import com.mercadolibre.melifrescosg9w31.repository.IBuyerRepository;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.repository.IPurchaseOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static com.mercadolibre.melifrescosg9w31.integration.TestingToken.obtenerToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql(scripts = "/mock_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IPurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IBuyerRepository buyerRepository;

    @Test
    void listByCategory_shouldReturnAllProducts_whenCategoryIsNull() throws Exception {
        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        mockMvc.perform(get("/api/v1/fresh-products/list")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }


    // Test para GET /api/v1/fresh-products/list con parámetro category
    @Test
    void listByCategory_shouldReturnProductsByCategory_whenCategoryIsSet() throws Exception {
        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        mockMvc.perform(get("/api/v1/fresh-products/list")
                        .param("category", "FS")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // Test para POST /api/v1/fresh-products/orders
    @Test
    void createOrder_shouldReturnCreated_whenStockIsEnough() throws Exception {
        PurchaseOrderRequestWrapper wrapper = new PurchaseOrderRequestWrapper();
        PurchaseOrderRequest order = new PurchaseOrderRequest();
        order.setDate(LocalDate.parse("2025-06-05"));
        order.setBuyerId(buyerRepository.findAll().get(0).getId());

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        order.setOrderStatus(status);

        PurchaseOrderProductDTO product1 = new PurchaseOrderProductDTO();
        product1.setProductId(Math.toIntExact(productRepository.findAll().get(0).getId()));
        product1.setAmount(5);

        PurchaseOrderProductDTO product2 = new PurchaseOrderProductDTO();
        product2.setProductId(Math.toIntExact(productRepository.findAll().get(1).getId()));
        product2.setAmount(5);

        order.setProducts(List.of(product1, product2));

        wrapper.setPurchaseOrder(order);

        String jsonBody = objectMapper.writeValueAsString(wrapper);

        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isCreated());
    }

    @Test
    void createOrder_shouldReturn422_whenNoStock() throws Exception {
        PurchaseOrderRequestWrapper wrapper = new PurchaseOrderRequestWrapper();
        PurchaseOrderRequest order = new PurchaseOrderRequest();
        order.setDate(LocalDate.parse("2025-06-05"));
        order.setBuyerId(buyerRepository.findAll().get(0).getId());

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        order.setOrderStatus(status);

        // armar products
        PurchaseOrderProductDTO product1 = new PurchaseOrderProductDTO();
        Long id1 = productRepository.findAll().get(0).getId();
        product1.setProductId(Math.toIntExact(id1));
        product1.setAmount(500);

        PurchaseOrderProductDTO product2 = new PurchaseOrderProductDTO();
        Long id2 = productRepository.findAll().get(1).getId();
        product2.setProductId(Math.toIntExact(id2));
        product2.setAmount(500);

        order.setProducts(List.of(product1, product2));

        // Envolverlo
        wrapper.setPurchaseOrder(order);

        String jsonBody = objectMapper.writeValueAsString(wrapper);

        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        // ... armar el requestBody ...
        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isUnprocessableEntity());
    }


    // Test para GET /api/v1/fresh-products/orders/{idOrden}
    @Test
    void getProductInOrder_shouldReturnOrderProducts() throws Exception {
        Long id = purchaseOrderRepository.findAll().get(0).getId();
        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        // ... obtener idOrden ...
        mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrden}", id)
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    // Test para PUT /api/v1/fresh-products/orders/{idOrder} (update productos)
    @Test
    void updateOrderProducts_shouldUpdateAndReturnOk() throws Exception {
        Long orderId = 1L;
        UpdateOrderProductsRequest updateRequest = new UpdateOrderProductsRequest();

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        updateRequest.setOrderStatus(status);

        // armar products
        PurchaseOrderProductDTO product1 = new PurchaseOrderProductDTO();
        product1.setProductId(Math.toIntExact(productRepository.findAll().get(0).getId()));
        product1.setAmount(5);

        PurchaseOrderProductDTO product2 = new PurchaseOrderProductDTO();
        product2.setProductId(Math.toIntExact(productRepository.findAll().get(1).getId()));
        product2.setAmount(5);

        updateRequest.setProducts(List.of(product1, product2));
        String jsonBody = objectMapper.writeValueAsString(updateRequest);

        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        // ... armar el requestBody y obtener idOrder ...
        mockMvc.perform(put("/api/v1/fresh-products/orders/{idOrder}", orderId)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk());
    }

    // Test para PUT /api/v1/fresh-products/orders/{idOrder} cuando hay error de stock
    @Test
    void updateOrderProducts_shouldReturn422_whenNoStock() throws Exception {
        Long id = purchaseOrderRepository.findAll().get(0).getId();
        UpdateOrderProductsRequest updateRequest = new UpdateOrderProductsRequest();

        OrderStatusDTO status = new OrderStatusDTO();
        status.setStatusCode("CARRITO");
        updateRequest.setOrderStatus(status);

        // armar products
        PurchaseOrderProductDTO product1 = new PurchaseOrderProductDTO();
        Long id1 = productRepository.findAll().get(0).getId();
        product1.setProductId(Math.toIntExact(id1));
        product1.setAmount(500);

        PurchaseOrderProductDTO product2 = new PurchaseOrderProductDTO();
        Long id2 = productRepository.findAll().get(1).getId();
        product2.setProductId(Math.toIntExact(id2));
        product2.setAmount(500);

        updateRequest.setProducts(List.of(product1, product2));
        String jsonBody = objectMapper.writeValueAsString(updateRequest);

        String token = obtenerToken(mockMvc, objectMapper ,Role.BUYER);
        // ... armar el requestBody y obtener idOrder ...
        mockMvc.perform(put("/api/v1/fresh-products/orders/{idOrder}", id)
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isUnprocessableEntity());
    }
}
