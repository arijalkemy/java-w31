package com.mercadolibre.melifrescosg9w31.integration;

import com.mercadolibre.melifrescosg9w31.utils.CustomFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(properties = {
        "spring.security.enabled=false"
})
@Sql(scripts = "/import.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@RequiredArgsConstructor
public class ProductControllerTest {

    private static final long PRODUCT_ID = 1L;
    private static final long NOT_FOUND_ID = 999L;
    private static final int BATCH_NUMBER_ORDER_F = 30;
    private static final String BAD_REQUEST_MSG = "Order not valid.";
    private static final String NOT_FOUND_MSG = "Product with id 999 not found or has no batches.";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /warehouse/list -> OK when product exists")
    void getWarehouseListByProductIdHappyPath() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", PRODUCT_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product_id").value(PRODUCT_ID))
                .andExpect(jsonPath("$.warehouses").isArray());
    }

    @Test
    @DisplayName("GET /warehouse/list -> Not Found when product does not exist")
    void getWarehouseListByProductIdNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", NOT_FOUND_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Product with id 999 not found or has no warehouses."));
    }

    @Test
    @DisplayName("GET /batch/list -> OK when product exists")
    public void getBatchProductList_returnsOk() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list", PRODUCT_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product_id").value(PRODUCT_ID))
                .andExpect(jsonPath("$.batch_stock").isArray())
                .andExpect(jsonPath("$.batch_stock[0].batch_number").exists());
    }

    @Test
    @DisplayName("GET /batch/list -> OK with correct batch number order")
    public void getBatchProductList_returnsOk_withOrder() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list?order=L", PRODUCT_ID))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.batch_stock").isArray())
                .andExpect(jsonPath("$.batch_stock[0].batch_number").value(BATCH_NUMBER_ORDER_F));
    }

    @Test
    @DisplayName("GET /batch/list -> Bad Request for invalid order parameter")
    public void getBatchProductList_returnsBadRequest_forInvalidOrder() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list?order=invalid", PRODUCT_ID))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(BAD_REQUEST_MSG));
    }

    @Test
    @DisplayName("GET /batch/list -> Not Found when product does not exist")
    public void getBatchProductList_returnsNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/batch/list", NOT_FOUND_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(NOT_FOUND_MSG));
    }

    @Test
    @DisplayName("Integration test req-06: Get Product stock by warehouse happy path")
    public void testGetProductStockByWarehouseHappyPath() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idWarehouse}/list", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.warehouse_code").value(1001))
                .andExpect(jsonPath("$.product_info").isArray());
    }

    @Test
    @DisplayName("Integration test req-06: Get Product stock by warehouse not found")
    public void testGetProductStockByWarehouseNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/fresh-products/{idWarehouse}/list", 100)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Warehouse with id 100 not found."));
    }

    @Test
    @DisplayName("Integration test req-06: Add a product succefully")
    public void testAddProductHappyPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/products/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomFactory.createValidAddProduct()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Product added successfully."));
    }

    @Test
    @DisplayName("Integration test req-06: Add a product with an existing name")
    public void testAddProductSadPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/fresh-products/products/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomFactory.createInvalidAddProduct()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("Product with name Refrigerated Product already exists."));
    }

    @Test
    @DisplayName("Integration test req-06: Update a product succefully")
    public void testUpdateProductHappyPath() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/products/{idProduct}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomFactory.createValidUpdateProduct()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Product updated successfully."));
    }
    @Test
    @DisplayName("Integration test req-06: Update a product id not found")
    public void testUpdateProductNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/fresh-products/products/{idProduct}", 999)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomFactory.createValidUpdateProduct()))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("The product with id 999 not found."));
    }
}