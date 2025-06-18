package com.mercadolibre.melifrescosg9w31.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.melifrescosg9w31.controller.PingController;
import com.mercadolibre.melifrescosg9w31.entity.Role;
import com.mercadolibre.melifrescosg9w31.exceptions.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.mercadolibre.melifrescosg9w31.integration.TestingToken.obtenerToken;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ControllerExceptionHandlerTest {

  @SpyBean
  private PingController pingController;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void notFound() throws Exception {
    String token = obtenerToken(mockMvc, objectMapper, Role.SELLER);

    mockMvc.perform(get("/fake")
                    .header("Authorization", "Bearer " + token))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()));
  }

  @Test
  void testUnhandledException() throws Exception {
    String token = obtenerToken(mockMvc, objectMapper, Role.SELLER);

    // Simula que el método ping() lanza una excepción inesperada
    doThrow(new RuntimeException("Falla inesperada")).when(pingController).ping();

    mockMvc.perform(get("/ping")
                    .header("Authorization", "Bearer " + token))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("$.message").value("Internal server error"))
            .andExpect(jsonPath("$.status").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
  }

  @Test
  void testApiExceptionError() throws Exception {
    String token = obtenerToken(mockMvc, objectMapper, Role.SELLER);

    doThrow(new ApiException("error", "error", HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .when(pingController).ping();

    mockMvc.perform(get("/ping")
                    .header("Authorization", "Bearer " + token))
            .andExpect(status().isInternalServerError())
            .andExpect(jsonPath("$.message").value("error"))
            .andExpect(jsonPath("$.status").value(HttpStatus.INTERNAL_SERVER_ERROR.value()));
  }

  @Test
  void testApiExceptionWarn() throws Exception {
    String token = obtenerToken(mockMvc, objectMapper, Role.SELLER);

    doThrow(new ApiException("warn", "warn", HttpStatus.BAD_REQUEST.value()))
            .when(pingController).ping();

    mockMvc.perform(get("/ping")
                    .header("Authorization", "Bearer " + token))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("warn"))
            .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()));
  }
}