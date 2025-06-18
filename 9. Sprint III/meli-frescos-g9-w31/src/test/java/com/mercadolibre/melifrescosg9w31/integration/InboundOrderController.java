package com.mercadolibre.melifrescosg9w31.integration;

import com.mercadolibre.melifrescosg9w31.utils.CustomFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Sql(scripts = "/test-david-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@RequiredArgsConstructor
public class InboundOrderController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithUserDetails("analopez")
    void integrationTest_updateInboundOrder_WhenBodyIsCorrect() throws Exception {
        mockMvc
                .perform(
                        put("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomFactory.createValidInboundOrderRequest()))
                // The .header() for the token is no longer needed
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content()
                                .json(CustomFactory.responseCreateInvalidOrderRequestWithInboundOrBatchNumber()));
    }

    @Test
    @WithUserDetails("analopez")
    void integrationTest_updateInboundOrder_WhenBatchNumberOrInboundOrderAreIncorrect()
            throws Exception {
        mockMvc
                .perform(
                        put("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomFactory.createInvalidOrderRequestWithInboundOrBatchNumber()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(
                        jsonPath("$.message")
                                .value("Batch not found with batch_number: 101 for InboundOrder id: 2."));
    }

    @Test
    @WithUserDetails("analopez")
    void integrationTest_updateInboundOrder_WhenProductTypeIsNotSuitable() throws Exception {
        mockMvc
                .perform(
                        put("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomFactory.createInvalidOrderRequestWithNotSuitableType()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(
                        jsonPath("$.message")
                                .value(
                                        "Sector with code 1001 (designed for type: Fresco) is not suitable for product Yogur natural (type: Refrigerado)."));
    }

    @Test
    @WithUserDetails("analopez")
    void integrationTest_updateInboundOrder_WhenProductsBatchsExceedsCapacity() throws Exception {
        mockMvc
                .perform(
                        put("/api/v1/fresh-products/inboundorder")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomFactory.createInvalidOrderRequestWithExceedsProducts()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(
                        jsonPath("$.message")
                                .value(
                                        "Adding 190 items (total) would exceed sector 1001 max capacity of 100. Current items in sector: 0."));
    }
}