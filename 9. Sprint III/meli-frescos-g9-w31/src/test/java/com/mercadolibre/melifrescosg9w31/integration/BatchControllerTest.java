package com.mercadolibre.melifrescosg9w31.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.melifrescosg9w31.entity.Role;
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

import static com.mercadolibre.melifrescosg9w31.integration.TestingToken.obtenerToken;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource(properties = {
        "spring.security.enabled=false"
})
class BatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Happy Path integration test")
    void getBatchesByDueDateHappyPath() throws Exception {
        String token = obtenerToken(mockMvc, objectMapper, Role.BUYER);

        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 100)
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.batch_stock").isArray());
    }

    @Test
    @DisplayName("Not Found integration test")
    void getBatchesByDueDateNotFound() throws Exception {
        String token = obtenerToken(mockMvc, objectMapper, Role.BUYER);

        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 0)
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Bad Request integration test")
    void getBatchesByDueDateBadRequest() throws Exception {
        String token = obtenerToken(mockMvc, objectMapper, Role.BUYER);
        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 100)
                        .param("order", "date_asc")
                        .header("Authorization", "Bearer " + token))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}