package com.mercadolibre.starwars.controller;


import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CharacterRepository characterRepository;


    @DisplayName("find deberia devolver personajes cuando la data es valida")
    @Test
    public void find_ShouldReturnCharacters_WhenDataIsValid() throws Exception {
        this.mockMvc.perform(get("/Luke Skywalker"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
                .andReturn();
    }

    @DisplayName("find deberia devolver una lista vacia cuando la data no existe")
    @Test
    public void find_ShouldReturnEmptyList_WhenDataDoesNotExists() throws Exception {
        this.mockMvc.perform(get("/fer"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty())
                .andReturn();
    }

    @DisplayName("find debería devolver personajes cuando se busca por parte del nombre")
    @Test
    public void find_ShouldReturnCharacters_WhenPartialNameIsGiven() throws Exception {
        this.mockMvc.perform(get("/Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @DisplayName("find debería ser insensible a mayúsculas y minúsculas")
    @Test
    public void find_ShouldBeCaseInsensitive_WhenSearching() throws Exception {
        this.mockMvc.perform(get("/LUKE"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @DisplayName("find debería devolver varios personajes cuando hay más de una coincidencia")
    @Test
    public void find_ShouldReturnMultipleCharacters_WhenMultipleMatchesExist() throws Exception {
        this.mockMvc.perform(get("/Skywalker"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(3));
    }


}


/*
mockMvc.perform(get("/vehicles"))
    .andExpect(status().isOk())  // Verifica que la respuesta es 200 OK
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))  // Verifica que la respuesta es en JSON
    .andExpect(jsonPath("$").isArray())  // Verifica que el cuerpo de la respuesta es un arreglo
    .andExpect(jsonPath("$[0].id").value(1))  // Verifica que el primer vehículo tiene el id 1
    .andExpect(jsonPath("$[0].make").value("Toyota"))  // Verifica que el primer vehículo tiene la marca Toyota
    .andExpect(jsonPath("$[0].model").value("Corolla"));  // Verifica que el primer vehículo tiene el modelo Corolla
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentDAO dao;

    private static final Path JSON_PATH = Paths.get("./src/test/resources/users.json");
    private static final Path JSON_BACKUP_PATH = Paths.get("./src/test/resources/users_backup.json");
    private static final Path JSON_EMPTY_PATH = Paths.get("./src/test/resources/users_empty.json");

    @BeforeEach
    void backupJson() throws IOException {
        Files.copy(JSON_PATH, JSON_BACKUP_PATH, StandardCopyOption.REPLACE_EXISTING);
    }

    @AfterEach
    void restoreJson() throws IOException {
        Files.copy(JSON_BACKUP_PATH, JSON_PATH, StandardCopyOption.REPLACE_EXISTING);
    }



    // GET get student
    @Test
    void getStudent_shouldReturnStudent_WhenIdIsValid() throws Exception{
        this.mockMvc.perform(get("/student/getStudent/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Juan"))).andReturn();
    }

 */