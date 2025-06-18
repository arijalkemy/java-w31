package com.mercadolibre.melifrescosg9w31.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequestWrapperDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.SectorRequestDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureWebMvc
@ActiveProfiles("test")
@Transactional
@Sql(scripts = "/test-data-inbound.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class InboundControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private IInboundOrderRepository inboundOrderRepository;

    @Autowired
    private IBatchRepository batchRepository;

    @Autowired
    private ISectorRepository sectorRepository;

    @Autowired
    private IWarehouseRepRepository warehouseRepRepository;

    @Autowired
    private IWarehouseRepository warehouseRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    @DisplayName("Should successfully create inbound order with single batch")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_SingleBatch_Success() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.batch_stock", hasSize(1)))
                .andExpect(jsonPath("$.batch_stock[0].batch_number", is(12345)))
                .andExpect(jsonPath("$.batch_stock[0].product_id", is(1)))
                .andExpect(jsonPath("$.batch_stock[0].current_temperature", is(5.0)))
                .andExpect(jsonPath("$.batch_stock[0].initial_quantity", is(100)))
                .andExpect(jsonPath("$.batch_stock[0].current_quantity", is(100)));

        List<InboundOrder> inboundOrders = inboundOrderRepository.findAll();
        assertEquals(1, inboundOrders.size());
        assertEquals(123456, inboundOrders.get(0).getOrderNumber());
        assertEquals(1L, inboundOrders.get(0).getRep().getId());

        List<Batch> batches = batchRepository.findAll();
        assertEquals(1, batches.size());
        assertEquals(12345, batches.get(0).getBatchNumber());
        assertEquals(100, batches.get(0).getInitialQuantity());
        assertEquals(1L, batches.get(0).getProduct().getId());

        Sector updatedSector = sectorRepository.findById(1L).orElseThrow();
        assertEquals(100, updatedSector.getCurrentCapacity());
    }

    @Test
    @DisplayName("Should successfully create inbound order with multiple batches")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_MultipleBatches_Success() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper =
                createValidInboundOrderRequestWithMultipleBatches();
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.batch_stock", hasSize(2)))
                .andExpect(jsonPath("$.batch_stock[0].batch_number", is(12345)))
                .andExpect(jsonPath("$.batch_stock[1].batch_number", is(12346)));

        List<InboundOrder> inboundOrders = inboundOrderRepository.findAll();
        assertEquals(1, inboundOrders.size());

        List<Batch> batches = batchRepository.findAll();
        assertEquals(2, batches.size());

        Sector updatedSector = sectorRepository.findById(1L).orElseThrow();
        assertEquals(150, updatedSector.getCurrentCapacity());
    }

    @Test
    @DisplayName("Should return 400 when request body is invalid JSON")
    @WithUserDetails("rep_user")
        // <-- ADD THIS ANNOTATION
    void testNewInboundOrder_InvalidJson() throws Exception {
        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"invalid\"}")) // Malformed JSON
                .andDo(print())
                .andExpect(status().isBadRequest()); // Now it should correctly return 400
    }


    @Test
    @DisplayName("Should return 400 when required fields are missing")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_MissingRequiredFields() throws Exception {
        String requestJson =
                """
                        {
                            "inbound_order": {
                                "order_date": "10-06-2025"
                            }
                        }
                        """;

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should return 400 when batchStock is empty")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_EmptyBatchStock() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        requestWrapper.getInboundOrder().setBatchStock(List.of());
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should return 409 when order number already exists")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_DuplicateOrderNumber() throws Exception {
        InboundOrder existingOrder = new InboundOrder();
        existingOrder.setOrderNumber(123456);
        existingOrder.setOrderDate(LocalDate.now());
        existingOrder.setRep(warehouseRepRepository.findById(1L).orElseThrow());
        existingOrder.setWarehouse(warehouseRepository.findById(1L).orElseThrow());
        inboundOrderRepository.save(existingOrder);

        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(
                        jsonPath(
                                "$.message",
                                containsString("already exists")));
    }

    @Test
    @DisplayName("Should return 404 when warehouse not found")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_WarehouseNotFound() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        requestWrapper.getInboundOrder().getSection().setWarehouseCode(9999);
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("Warehouse with code 9999 not found")));
    }

    @Test
    @DisplayName("Should return 404 when sector not found")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_SectorNotFound() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        requestWrapper.getInboundOrder().getSection().setSectorCode(9999);
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("Sector with code 9999")));
    }

    @Test
    @DisplayName("Should return 404 when product not found")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_ProductNotFound() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        requestWrapper.getInboundOrder().getBatchStock().get(0).setProductId(9999L);
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", containsString("Product with ID 9999 not found")));
    }

    @Test
    @DisplayName("Should return 401 when representative doesn't belong to warehouse")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_RepresentativeUnauthorized() throws Exception {
        WarehouseRep rep = warehouseRepRepository.findById(1L).orElseThrow();
        Warehouse otherWarehouse = warehouseRepository.findById(2L).orElseThrow();
        rep.setWarehouse(otherWarehouse);
        warehouseRepRepository.save(rep);

        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message", containsString("does not belong to warehouse")));
    }

    @Test
    @DisplayName("Should return 400 when sector capacity would be exceeded")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_SectorCapacityExceeded() throws Exception {
        Sector sector = sectorRepository.findById(1L).orElseThrow();
        sector.setCurrentCapacity(950);
        sectorRepository.save(sector);

        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        requestWrapper
                .getInboundOrder()
                .getBatchStock()
                .get(0)
                .setInitialQuantity(100); // 950 + 100 > 1000
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("would exceed sector")));
    }

    @Test
    @DisplayName("Should return 400 when product type doesn't match sector")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_ProductTypeMismatch() throws Exception {
        InboundOrderRequestWrapperDTO requestWrapper = createValidInboundOrderRequest();
        requestWrapper
                .getInboundOrder()
                .getBatchStock()
                .get(0)
                .setProductId(3L); // Refrigerated product
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("is not suitable for product")));
    }

    @Test
    @DisplayName("Should verify transaction rollback on partial failure")
    @WithUserDetails("rep_user")
    void testNewInboundOrder_TransactionRollback() throws Exception {
        Sector sector = sectorRepository.findById(1L).orElseThrow();
        sector.setMaxCapacity(120); // Not enough for both batches (100 + 50)
        sectorRepository.save(sector);

        InboundOrderRequestWrapperDTO requestWrapper =
                createValidInboundOrderRequestWithMultipleBatches();
        String requestJson = objectMapper.writeValueAsString(requestWrapper);

        mockMvc
                .perform(
                        post("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", containsString("would exceed sector")));

        assertEquals(0, inboundOrderRepository.findAll().size());
        assertEquals(0, batchRepository.findAll().size());
    }

    // Helper methods
    private InboundOrderRequestWrapperDTO createValidInboundOrderRequest() {
        SectorRequestDTO sectionDTO =
                SectorRequestDTO.builder()
                        .sectorCode(101)
                        .warehouseCode(1001)
                        .build();

        BatchStockDTO batchStockDTO =
                BatchStockDTO.builder()
                        .batchNumber(12345)
                        .productId(1L)
                        .currentTemperature(5.0)
                        .minimumTemperature(2.0)
                        .initialQuantity(100)
                        .currentQuantity(100)
                        .manufacturingDate(LocalDate.now().minusDays(2))
                        .manufacturingTime(LocalDateTime.now().minusDays(2))
                        .dueDate(LocalDate.now().plusDays(30))
                        .build();

        InboundOrderRequest inboundOrderRequest =
                InboundOrderRequest.builder()
                        .orderNumber(123456)
                        .orderDate(LocalDate.now())
                        .section(sectionDTO)
                        .batchStock(List.of(batchStockDTO))
                        .build();

        return new InboundOrderRequestWrapperDTO(inboundOrderRequest);
    }

    private InboundOrderRequestWrapperDTO createValidInboundOrderRequestWithMultipleBatches() {
        SectorRequestDTO sectionDTO =
                SectorRequestDTO.builder()
                        .sectorCode(101)
                        .warehouseCode(1001)
                        .build();

        BatchStockDTO batchStock1 =
                BatchStockDTO.builder()
                        .batchNumber(12345)
                        .productId(1L)
                        .currentTemperature(5.0)
                        .minimumTemperature(2.0)
                        .initialQuantity(100)
                        .currentQuantity(100)
                        .manufacturingDate(LocalDate.now().minusDays(2))
                        .manufacturingTime(LocalDateTime.now().minusDays(2))
                        .dueDate(LocalDate.now().plusDays(30))
                        .build();

        BatchStockDTO batchStock2 =
                BatchStockDTO.builder()
                        .batchNumber(12346)
                        .productId(2L)
                        .currentTemperature(4.0)
                        .minimumTemperature(1.0)
                        .initialQuantity(50)
                        .currentQuantity(50)
                        .manufacturingDate(LocalDate.now().minusDays(2))
                        .manufacturingTime(LocalDateTime.now().minusDays(1))
                        .dueDate(LocalDate.now().plusDays(25))
                        .build();

        InboundOrderRequest inboundOrderRequest =
                InboundOrderRequest.builder()
                        .orderNumber(123457)
                        .orderDate(LocalDate.now())
                        .section(sectionDTO)
                        .batchStock(List.of(batchStock1, batchStock2))
                        .build();

        return new InboundOrderRequestWrapperDTO(inboundOrderRequest);
    }
}