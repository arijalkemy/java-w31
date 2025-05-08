package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest(name = "Test: {index} => Min: {0} - Max. {1}")
    @CsvSource({
            "90, 93"
    })
    @DisplayName("Integration Test: Get vehicles list by range of weight")
    void integrationTestGetVehiclesByRangeOfWeight_shouldReturnVehiclesList_whenWeightMatches(double min, double max) throws Exception{

        String expected = "[{\"id\":61,\"brand\":\"GMC\",\"model\":\"2500\",\"registration\":\"23\",\"color\":\"Purple\",\"year\":1997,\"max_speed\":\"150\",\"passengers\":6,\"fuel_type\":\"gas\",\"transmission\":\"manual\",\"height\":30.93,\"width\":279,\"weight\":90.27},{\"id\":229,\"brand\":\"GMC\",\"model\":\"Savana 2500\",\"registration\":\"18735\",\"color\":\"Mauv\",\"year\":2012,\"max_speed\":\"89\",\"passengers\":4,\"fuel_type\":\"gas\",\"transmission\":\"manual\",\"height\":242.14,\"width\":245.07,\"weight\":90.52},{\"id\":290,\"brand\":\"Pontiac\",\"model\":\"G5\",\"registration\":\"8320\",\"color\":\"Maroon\",\"year\":2008,\"max_speed\":\"196\",\"passengers\":5,\"fuel_type\":\"diesel\",\"transmission\":\"manual\",\"height\":55.17,\"width\":224.2,\"weight\":92.7},{\"id\":369,\"brand\":\"Buick\",\"model\":\"Century\",\"registration\":\"393\",\"color\":\"Violet\",\"year\":2005,\"max_speed\":\"183\",\"passengers\":5,\"fuel_type\":\"gas\",\"transmission\":\"manual\",\"height\":187.07,\"width\":130.77,\"weight\":90.38}]";
        List<VehicleDto> response = new ObjectMapper().readValue(expected, new TypeReference<>() {
        });

        double weight = response.get(0).getWeight();
        //double weight2 = response.get(2).getWeight();

        this.mockMvc.perform(get("/vehicles/weight")
                .param("min", String.valueOf(min)).param("max", String.valueOf(max)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].weight").value(weight))
                .andReturn();
    }
}
