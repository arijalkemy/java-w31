package com.bootcamp.be_java_hisp_w31_g09.integration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.bootcamp.be_java_hisp_w31_g09.dto.DiscountDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseMessageDTO;
import com.bootcamp.be_java_hisp_w31_g09.utils.CustomFactory;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.bootcamp.be_java_hisp_w31_g09.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import com.bootcamp.be_java_hisp_w31_g09.dto.UpdatePricesDTO;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.bind.MethodArgumentNotValidException;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final Integer VALID_ID = 11;
    private static final Integer INVALID_ID = 999;
    private static final String ORDER_ASC = "date_asc";
    private static final String ORDER_DESC = "date_desc";
    private static final String ORDER_INVALID = "invalid";


    private DiscountDTO discountDTO;
    private ObjectWriter writer;

    @BeforeEach
    public void setUp(){
        discountDTO = new DiscountDTO(0.5);
        writer = CustomFactory.writer();
    }

    @Test
    @DisplayName("Test of Integration US_0006 Happy Path")
    void testGetFollowedPosts() throws Exception{

         MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list",VALID_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(VALID_ID))
                .andExpect(jsonPath("$.posts").isArray())
                 .andReturn();

        List<LocalDate> dates = new ArrayList<>();
        String json = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(json);
        JsonNode posts = root.get("posts");

        assertNotNull(posts);
        assertTrue(posts.isArray());

        for (JsonNode post : posts) {
            LocalDate postDate = LocalDate.parse(post.get("date").asText());
            LocalDate today = LocalDate.now();
            LocalDate twoWeeksAgo = today.minusWeeks(2);

            //Chequeo que las fechas esten dentro del rango
            assertTrue(
                    (postDate.isEqual(today) || postDate.isBefore(today)) &&
                            (postDate.isEqual(twoWeeksAgo) || postDate.isAfter(twoWeeksAgo)),
                    "La fecha " + postDate + " no está dentro de las últimas dos semanas"
            );

            dates.add(postDate);
        }

        // Chequeo el orden descendente
        for (int i = 0; i < dates.size() - 1; i++) {
            assertTrue(
                    !dates.get(i).isBefore(dates.get(i + 1)), // i debe ser >= i+1
                    "Las fechas no están en orden descendente: " + dates.get(i) + " < " + dates.get(i + 1)
            );
        }
    }

    @Test
    @DisplayName("Test of Integration US_0006 Happy Path lista vacia")
    void testGetFollowedPostsEmpty() throws Exception{

       mockMvc.perform(get("/products/followed/{userId}/list",VALID_ID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(VALID_ID))
                .andExpect(jsonPath("$.posts").isArray());
    }


    @Test
    @DisplayName("Test of Integration US_0006 Sad Path")
    void testGetFollowedPostsInvalidId() throws Exception{
        mockMvc.perform(get("/products/followed/{userId}/list",INVALID_ID))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No existe un usuario con id: 999"));
    }

    @Test
    @DisplayName("Test of Integration US_0009 Happy Path Desc")
    void testGetFollowedPostsByOrderDesc() throws Exception {
        assertOrderedByDate(ORDER_DESC, true);
    }

    @DisplayName("Test of Integration US_0009 Happy Path Asc")
    void testGetFollowedPostsByOrderAsc() throws Exception {
        assertOrderedByDate(ORDER_ASC, false);
    }

    @Test
    @DisplayName("Test of Integration US_0009 Sad Path")
    void testGetFollowedPostsByOrderInvalid() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list", VALID_ID)
                        .param("order", ORDER_INVALID))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Ese orden no es valido."));
    }

    private void assertOrderedByDate(String orderParam, boolean desc) throws Exception {
        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", VALID_ID)
                        .param("order", orderParam))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.posts").isArray())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(json);
        JsonNode posts = root.get("posts");

        assertNotNull(posts);
        assertTrue(posts.isArray());
        assertTrue(posts.size() >= 2, "Debe haber al menos dos posts para comparar el orden");

        LocalDate firstDate = LocalDate.parse(posts.get(0).get("date").asText());
        LocalDate lastDate = LocalDate.parse(posts.get(posts.size() - 1).get("date").asText());

        if (desc) {
            assertTrue(!firstDate.isBefore(lastDate),
                    "El primer post (" + firstDate + ") no es más reciente que el último post (" + lastDate + ")");
        } else {
            assertTrue(!firstDate.isAfter(lastDate),
                    "El primer post (" + firstDate + ") no es más antiguo que el último post (" + lastDate + ")");
        }
    }

    @Test
    @DisplayName("Happy Path US-0015")
    public void testUpdateDiscountsBySeller() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getDiscountChangeMessage();
        DiscountDTO discount = new DiscountDTO(0.20);
        ObjectMapper objectMapper = new ObjectMapper();
        String payloadJson = objectMapper.writeValueAsString(discount);
        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.put("/products/discount/by-seller/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Bad Request US-0015")
    public void testUpdateDiscountsBySellerBadRequest() throws Exception {
        // Arrange
        DiscountDTO discount = new DiscountDTO();
        ObjectMapper objectMapper = new ObjectMapper();
        String payloadJson = objectMapper.writeValueAsString(discount);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.put("/products/discount/by-seller/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.discount").value("El descuento es obligatorio"));
    }

    @Test
    @DisplayName("Not Found US-0015")
    public void testUpdateDiscountsBySellerNotFound() throws Exception {
        // Arrange
        ResponseMessageDTO response = CustomFactory.getSellerNotExistsMessage(99);
        DiscountDTO discount = new DiscountDTO(0.20);
        ObjectMapper objectMapper = new ObjectMapper();
        String payloadJson = objectMapper.writeValueAsString(discount);

        // Act & Assert
        this.mockMvc.perform(MockMvcRequestBuilders.put("/products/discount/by-seller/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Integration test us-0014: Valid discount")
    public void testModifyValidDiscount() throws Exception{
        Integer sellerId = 1;
        Integer postId = 1;
        String paylodDTO = writer.writeValueAsString(discountDTO);
        mockMvc.perform(MockMvcRequestBuilders.put(
                                "/products/discount/by-post/{postId}/by-seller/{sellerId}", postId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paylodDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").
                        value("Se actualizó exitosamente el descuento"));

    }

    @Test
    @DisplayName("Integration test us-0014: Negative discount")
    public void testModifyNegativeDiscount() throws Exception{
        Integer sellerId = 1;
        Integer postId = 1;
        discountDTO = new DiscountDTO(-0.5);
        String paylodDTO = writer.writeValueAsString(discountDTO);
        mockMvc.perform(MockMvcRequestBuilders.put(
                                "/products/discount/by-post/{postId}/by-seller/{sellerId}",
                                postId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paylodDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.discount")
                        .value("El descuento debe ser un número positivo"));
    }

    @Test
    @DisplayName("Integration test us-0014: Discount higher than 100%")
    public void testModifyDiscountHigherThanOneHundred() throws Exception{
        Integer sellerId = 1;
        Integer postId = 1;
        discountDTO = new DiscountDTO(1.5);
        String paylodDTO = writer.writeValueAsString(discountDTO);
        mockMvc.perform(MockMvcRequestBuilders.put(
                                "/products/discount/by-post/{postId}/by-seller/{sellerId}",
                                postId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paylodDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message")
                        .value("El descuento no es válido"));
    }

    @Test
    @DisplayName("Integration test us-0014: Seller not Found")
    public void testSellerNotFound() throws Exception{
        Integer invalidId = 999;
        Integer postId = 1;
        String paylodDTO = writer.writeValueAsString(discountDTO);
        mockMvc.perform(MockMvcRequestBuilders.put(
                                "/products/discount/by-post/{postId}/by-seller/{sellerId}",
                                postId, invalidId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paylodDTO))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("No existe el Post ID: " + postId + " del vendedor con id: " + invalidId));
    }

    @Test
    @DisplayName("Integration test us-0014: Post not found")
    public void testPostNotFound() throws Exception{
        Integer sellerId = 1;
        Integer invalidPostId = 999;
        String paylodDTO = writer.writeValueAsString(discountDTO);
        mockMvc.perform(MockMvcRequestBuilders.put(
                                "/products/discount/by-post/{postId}/by-seller/{sellerId}",
                                invalidPostId, sellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(paylodDTO))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message")
                        .value("No existe el Post ID: " + invalidPostId +
                                " del vendedor con id: " + sellerId));
    }

    @Test
    @DisplayName("Integration test for Post of Posts")
    public void integrationTestPostOfPosts() throws Exception {
        //Arrange
        String requestJson = writer.writeValueAsString(CustomFactory.getNewRequestPostDTO(1));

        //Act & Assert
         mockMvc.perform(
                     post("/products/post")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(requestJson))
                 .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.message").value("Post creado exitosamente"));
    }
    @Test
    @DisplayName("Integration test for Post of Posts, User not found")
    public void integrationTestPostOfPostsUserNotFound() throws Exception {
        //Arrange
        String requestJson = writer.writeValueAsString(CustomFactory.getNewRequestPostDTO(99));

        //Act & Assert
         mockMvc.perform(
                     post("/products/post")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(requestJson))
                 .andDo(print())
                 .andExpect(status().isNotFound())
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()))
                 .andExpect(jsonPath("$.message").value("No existe el vendedor"));
    }
    @Test
    @DisplayName("Integration test for Validation of Posts")
    public void integrationTestPostValidations() throws Exception {
        //Arrange

        //Act & Assert
         mockMvc.perform(
                     post("/products/post")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content("{}"))
                 .andDo(print())
                 .andExpect(status().isBadRequest())
                 .andExpect(result -> assertInstanceOf(MethodArgumentNotValidException.class, result.getResolvedException()))
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.date").value("La fecha no puede estar vacía."))
                 .andExpect(jsonPath("$.product").value("El producto es obligatorio"))
                 .andExpect(jsonPath("$.price").value("El campo no puede estar vacío."))
                 .andExpect(jsonPath("$.category").value("El campo no puede estar vacío."))
                 .andExpect(jsonPath("$.userId").value("El id no puede estar vacío."));
    }
    @Test
    @DisplayName("Integration test for Validation of Product´s Posts")
    public void integrationTestProductPostValidations() throws Exception {
        //Arrange
        String requestJson = writer.writeValueAsString(CustomFactory.getNewRequestPostDTOWithOutProduct(1));

        //Act & Assert
         mockMvc.perform(
                     post("/products/post")
                         .contentType(MediaType.APPLICATION_JSON)
                         .content(requestJson))
                 .andDo(print())
                 .andExpect(status().isBadRequest())
                 .andExpect(result -> assertInstanceOf(MethodArgumentNotValidException.class, result.getResolvedException()))
                 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                 .andExpect(jsonPath("$.['product.notes']").value("La nota es obligatoria"))
                 .andExpect(jsonPath("$.['product.id']").value("La id no puede estar vacía."))
                 .andExpect(jsonPath("$.['product.brand']").value("La marca es obligatoria"))
                 .andExpect(jsonPath("$.['product.color']").value("El color es obligatorio"))
                 .andExpect(jsonPath("$.['product.name']").value("El nombre del producto es obligatorio"))
                 .andExpect(jsonPath("$.['product.type']").value("El campo no puede estar vacío."));
    }
    @Test
    @DisplayName("Integration test for Post of PromoPosts")
    public void integrationTestPostOfPromoPosts() throws Exception {
        //Arrange
        String requestJson = writer.writeValueAsString(CustomFactory.getNewRequestPromoPostDTO(1));

        //Act & Assert
        mockMvc.perform(
                post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Promo post creado exitosamente"));
    }
    @Test
    @DisplayName("Integration test for Post of Promo posts, User not found")
    public void integrationTestPostOfPromoPostsUserNotFound() throws Exception {
        //Arrange
        String requestJson = writer.writeValueAsString(CustomFactory.getNewRequestPromoPostDTO(99));

        //Act & Assert
        mockMvc.perform(
                        post("/products/promo-post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()))
                .andExpect(jsonPath("$.message").value("No existe el vendedor"));
    }
    @Test
    @DisplayName("Integration test for Validation of PromoPosts")
    public void integrationTestPromoPostValidations() throws Exception {
        //Arrange

        //Act & Assert
        mockMvc.perform(
                post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(MethodArgumentNotValidException.class, result.getResolvedException()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.date").value("La fecha no puede estar vacía."))
                .andExpect(jsonPath("$.product").value("El producto es obligatorio"))
                .andExpect(jsonPath("$.hasPromo").value("La promocion es obligatoria"))
                .andExpect(jsonPath("$.price").value("El campo no puede estar vacío."))
                .andExpect(jsonPath("$.discount").value("El descuento es obligatorio"))
                .andExpect(jsonPath("$.category").value("El campo no puede estar vacío."))
                .andExpect(jsonPath("$.userId").value("El id no puede estar vacío."));
    }
    @Test
    @DisplayName("Integration test for All posts from a user")
    public void integrationTestListOfUsersPosts() throws Exception {
        //Arrange
        String responseJson = writer.writeValueAsString(CustomFactory.getNewUserPostsResponseDTO(1));

        //Act & Assert
        mockMvc.perform(
                        get("/products/post/list")
                                .param("user_id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseJson));

    }

    @Test
    @DisplayName("Integration test for All posts from a user, Not found")
    public void integrationTestListOfUsersPostsNotFound() throws Exception {
        //Arrange
        //Act & Assert
        mockMvc.perform(
                        get("/products/post/list")
                                .param("user_id", "999"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()))
                .andExpect(jsonPath("$.message").value("No hay posts del usuario con id: 999"));
    }

    @Test
    @DisplayName("Happy Path posteos con promocion")
    void getPromoProductsCount() throws Exception {
        // Arrange
        Integer userId = 1;

        // Act y Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.user_name").value("Juan"))
                .andExpect(jsonPath("$.promo_products").value(1));
    }

    @Test
    @DisplayName("Not found posteos con promocion")
    void getPromoProductsCount_UserNotFound() throws Exception {
        // Arrange
        Integer userId = 999;
        ResponseMessageDTO response = CustomFactory.getSellerNotExistsMessage(userId);

        // Act y Assert
        mockMvc.perform(get("/products/promo-post/count")
                        .param("user_id", String.valueOf(userId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }

    @Test
    @DisplayName("Happy Path incremento precios")
    public void testIncreasePricesSuccess() throws Exception {
        int existingSellerId = 2;
        UpdatePricesDTO updatePricesDTO = new UpdatePricesDTO();
        updatePricesDTO.setPercentage(0.5);
        updatePricesDTO.setOperation("increase");

        mockMvc.perform(put("/products/seller/{userId}/prices", existingSellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(updatePricesDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Precios actualizados exitosamente."));
    }

    @Test
    @DisplayName("Not Found incremento precios")
    public void testIncreasePricesSellerNotFound() throws Exception {
        int nonExistingSellerId = 999;
        UpdatePricesDTO updatePricesDTO = new UpdatePricesDTO();
        updatePricesDTO.setPercentage(0.5);
        updatePricesDTO.setOperation("increase");

        mockMvc.perform(put("/products/seller/{userId}/prices", nonExistingSellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(updatePricesDTO)))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No existe un vendedor con id: " + nonExistingSellerId));
    }

    @Test

    @DisplayName("Happy Path decremento precios")
    public void testDecreasePricesSuccess() throws Exception {
        int existingSellerId = 2;
        UpdatePricesDTO updatePricesDTO = new UpdatePricesDTO();
        updatePricesDTO.setPercentage(0.3);
        updatePricesDTO.setOperation("decrease");

        mockMvc.perform(put("/products/seller/{userId}/prices", existingSellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(updatePricesDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Precios actualizados exitosamente."));
    }

    @Test

    @DisplayName("Operacion invalida cambio de precios")
    public void testNonValidOperation() throws Exception {
        int existingSellerId = 2;
        UpdatePricesDTO updatePricesDTO = new UpdatePricesDTO();
        updatePricesDTO.setPercentage(0.3);
        updatePricesDTO.setOperation("nonvalid");

        mockMvc.perform(put("/products/seller/{userId}/prices", existingSellerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(updatePricesDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Esa operación no es válida."));
    }

    @Test
    @DisplayName("Happy Path posteos en rango de precios")
    void testGetPostsByPriceRange() throws Exception {
        // Arrange
        Integer userId = 1;
        Double minPrice = 0.0;
        Double maxPrice = 100000.0;

        // Act & Assert
        mockMvc.perform(get("/products/{userId}/posts/price-range", userId)
                        .param("minPrice", String.valueOf(minPrice))
                        .param("maxPrice", String.valueOf(maxPrice))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].user_id").value(userId))
                .andExpect(jsonPath("$[0].product.product_name").value("Silla Gamer"));

    }

    @Test
    @DisplayName("Not Found posteos en rango de precios")
    void testGetPostsByPriceRange_UserIdNotFound() throws Exception {
        // Arrange
        Integer nonExistentUserId = 999;
        Double minPrice = 0.0;
        Double maxPrice = 100000.0;
        ResponseMessageDTO response = CustomFactory.getSellerNotExistsMessage(nonExistentUserId);

        // Act & Assert
        mockMvc.perform(get("/products/{userId}/posts/price-range", nonExistentUserId)
                        .param("minPrice", String.valueOf(minPrice))
                        .param("maxPrice", String.valueOf(maxPrice))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(response.getMessage()));
    }


}
