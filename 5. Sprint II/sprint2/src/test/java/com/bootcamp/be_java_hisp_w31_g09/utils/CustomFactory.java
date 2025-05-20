package com.bootcamp.be_java_hisp_w31_g09.utils;

import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseMessageDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseMessageDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.ResponseMessageDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.UserDTO;
import com.bootcamp.be_java_hisp_w31_g09.dto.UserListDTO;
import com.bootcamp.be_java_hisp_w31_g09.entity.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bootcamp.be_java_hisp_w31_g09.entity.Buyer;
import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Product;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class CustomFactory {

    private static JavaTimeModule javaTimeModule = new JavaTimeModule();

    public static ObjectWriter writer(){
        return new ObjectMapper()
                .registerModule(javaTimeModule.addSerializer(
                        LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")))) // Registra el módulo para LocalDate
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    public static UserListDTO twoFollowersAscResponse(Integer sellerId, String sellerName){
        UserDTO follower1 = new UserDTO(11, "Bob");
        UserDTO follower2 = new UserDTO(12, "Charlie");
        List<UserDTO> userDTOList = List.of(follower1, follower2);

        return new UserListDTO(sellerId, sellerName, userDTOList);

    }

    public static UserListDTO twoFollowersDescResponse(Integer sellerId, String sellerName){
        UserDTO follower1 = new UserDTO(11, "Bob");
        UserDTO follower2 = new UserDTO(12, "Charlie");
        List<UserDTO> userDTOList = List.of(follower2, follower1);

        return new UserListDTO(sellerId, sellerName, userDTOList);

    }

    public static List<Buyer> followersList(){
        return List.of(
                new Buyer(11, "Bob", List.of(6)),
                new Buyer(12, "Charlie", List.of(6))
        );
    }


    public static UserListDTO threeFollowedAscResponse(Integer sellerId, String sellerName){
        UserDTO followed1 = new UserDTO(1, "Juan");
        UserDTO followed2 = new UserDTO(2, "Maria");
        UserDTO followed3 = new UserDTO(3, "Carlos");

        List<UserDTO> userDTOList = List.of(followed3, followed1, followed2);

        return new UserListDTO(sellerId, sellerName, userDTOList);

    }

    public static UserListDTO threeFollowedDescResponse(Integer sellerId, String sellerName){
        UserDTO followed1 = new UserDTO(1, "Juan");
        UserDTO followed2 = new UserDTO(2, "Maria");
        UserDTO followed3 = new UserDTO(3, "Carlos");

        List<UserDTO> userDTOList = List.of(followed2, followed1, followed3);

        return new UserListDTO(sellerId, sellerName, userDTOList);

    }

    public static UserListDTO threeFollowedNoOrderResponse(Integer sellerId, String sellerName){
        UserDTO followed1 = new UserDTO(1, "Juan");
        UserDTO followed2 = new UserDTO(2, "Maria");
        UserDTO followed3 = new UserDTO(3, "Carlos");

        List<UserDTO> userDTOList = List.of(followed1, followed2, followed3);

        return new UserListDTO(sellerId, sellerName, userDTOList);

    }

    public static List<Seller> followedList() {
        return new ArrayList<>(Arrays.asList(
                new Seller(1, "Juan",
                        new ArrayList<>(Arrays.asList(
                                new Post(1, IdGenerator.getCurrentUserId(), LocalDate.parse("2025-04-20"),
                                        new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                                        100, 15000.8, Boolean.TRUE, 0.25)))),
                new Seller(2, "Maria",
                        new ArrayList<>(Arrays.asList(
                                new Post(2, IdGenerator.getCurrentUserId(), LocalDate.parse("2025-04-15"),
                                        new Product(2, "Teclado Mecánico", "Gaming", "HyperX", "RGB", "Alloy FPS Pro"),
                                        80, 15000.8, Boolean.TRUE, 0.15)))),
                new Seller(3, "Carlos",
                        new ArrayList<>(Arrays.asList(
                                new Post(3, IdGenerator.getCurrentUserId(), LocalDate.parse("2025-03-10"),
                                        new Product(3, "Mouse Inalámbrico", "Accesorios", "Logitech", "Negro", "MX Master 3"),
                                        60, 15000.8, Boolean.FALSE, 0.10))))));
    }

    public static Buyer generateBuyer() {
        return new Buyer(1, "Alice", new ArrayList<>(Arrays.asList(2, 3)));
    }

    public static Seller generateSeller() {
        return new Seller(2, "Juan",
                new ArrayList<>(Arrays.asList(
                        new Post(1, 2, LocalDate.parse("2025-04-20"),
                                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                                100, 15000.8, Boolean.TRUE, 0.25))));
    }

    public static List<Seller> generateSellersOrderedAsc() {
        return Arrays.asList( new Seller(2, "Juan",
                        new ArrayList<>(Arrays.asList(
                                new Post(1, 2, LocalDate.parse("2025-04-20"),
                                        new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                                        100, 15000.8, Boolean.TRUE, 0.25)))),
                new Seller(3, "Maria",
                        new ArrayList<>(Arrays.asList(
                                new Post(2, 3,LocalDate.parse("2025-04-15"),
                                        new Product(2, "Teclado Mecánico", "Gaming", "HyperX", "RGB", "Alloy FPS Pro"),
                                        80, 15000.8, Boolean.TRUE, 0.15)))));
    }

    public static List<Seller> generateSellersOrderedDesc() {
        return Arrays.asList( new Seller(3, "Maria",
                new ArrayList<>(Arrays.asList(
                        new Post(2, 3,LocalDate.parse("2025-04-15"),
                                new Product(2, "Teclado Mecánico", "Gaming", "HyperX", "RGB", "Alloy FPS Pro"),
                                80, 15000.8, Boolean.TRUE, 0.15)))), new Seller(2, "Juan",
                new ArrayList<>(Arrays.asList(
                        new Post(1, 2, LocalDate.parse("2025-04-20"),
                                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                                100, 15000.8, Boolean.TRUE, 0.25))))
        );
    }

    public static List<Buyer> generateBuyersOrderedAsc() {
        return new ArrayList<>(Arrays.asList(
                new Buyer(IdGenerator.getNextUserId(), "Alice", new ArrayList<>(Arrays.asList(1, 2, 3))),
                new Buyer(IdGenerator.getNextUserId(), "Bob", new ArrayList<>(Arrays.asList(4, 2, 6)))));
    }

    public static List<Buyer> generateBuyersOrderedDesc() {
        return new ArrayList<>(Arrays.asList(
                new Buyer(IdGenerator.getNextUserId(), "Bob", new ArrayList<>(Arrays.asList(4, 2, 6))),
                new Buyer(IdGenerator.getNextUserId(), "Alice", new ArrayList<>(Arrays.asList(1, 2, 3)))
                ));
    }

    public static List<UserDTO> generateUsersDtos(List<? extends User> users) {
        return users.stream()
                .map(u -> new UserDTO(u.getId(), u.getName()))
                .toList();
    }

    public static Seller getNewSeller() {
        return new Seller(IdGenerator.getNextUserId(), "Juan",
                new ArrayList<>(List.of(
                        new Post(1, IdGenerator.getCurrentUserId(), LocalDate.parse("2025-04-20"),
                                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                                100, 15000.8, Boolean.TRUE, 0.25))));
    }

    public static Buyer getNewBuyer() {
        return new Buyer(12, "Alice", new ArrayList<>(Arrays.asList(4, 5, 6)));
    }

    public static ResponseMessageDTO getDiscountChangeMessage() {
        return new ResponseMessageDTO("Descuentos realizados con éxito.");
    }


    public static ResponseMessageDTO getSellerNotExistsMessage(Integer id) {
        return new ResponseMessageDTO("No existe un vendedor con id: " + id);
    }
    public static ResponsePromoPostDTO getPromoPostList() {
        return new ResponsePromoPostDTO(1, "Juan", Arrays.asList(new PromoPostDTO(1, 1, LocalDate.parse("2025-04-20"), new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 15000.8, Boolean.TRUE, 0.25)));
    }

    public static ResponsePromoPostDTO getPromoPostListEmpty() {
        return new ResponsePromoPostDTO(3, "Carlos", new ArrayList<>());
    }

    public static RequestPostDTO getNewRequestPostDTO(Integer user_id) {
        return  new RequestPostDTO(user_id,"19-04-2025",
                new ProductDTO(11,"Cargador Inalambrico","Accesorios","Anker","Negro",
                        "Carga rapida"),
                110,39.99);
    }

    public static List<PromoPostDTO> getNewListPromoPostDTO(Integer user_id) {
        return List.of(
              new PromoPostDTO(user_id,1,LocalDate.parse("2025-05-05"),
                  new ProductDTO(1,"Silla Gamer","Gaming Chair","Racer","Red & Black",
                        "Special Edition"),
                1,15000.8,true,0.25),
              new PromoPostDTO(user_id,1,LocalDate.parse("2025-04-19"),
                  new ProductDTO(11,"Cargador Inalambrico","Accesorios","Anker","Negro",
                          "Carga rapida"),
                  110,39.99,false,0.0));

    }

    public static RequestPromoPostDTO getNewRequestPromoPostDTO(Integer user_id) {
        return new RequestPromoPostDTO(user_id,"29-04-2023",
                new ProductDTO(7,"Camara Digital","Fotografia","Canon","Negra",
                        "EOS Rebel T7"),
                400,699.99,true,0.10);
    }

    public static UserPostsResponseDTO getNewUserPostsResponseDTO(Integer user_id) {
        return new UserPostsResponseDTO(
                user_id,
                getNewListPromoPostDTO(user_id)
        );
    }

    public static RequestPostDTO getNewRequestPostDTOWithOutProduct(Integer user_id) {
        return new RequestPostDTO(user_id,"19-04-2025",new ProductDTO(),110,39.99);
    }
    public static List<Post> createPosts(){
        // Seller con 2 posts con fechas diferentes
        Post p1 = new Post(IdGenerator.getNextPostId(),1, LocalDate.parse("2025-04-30"),
                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                100, 15000.8, Boolean.TRUE, 0.25);
        Post p2 = new Post(IdGenerator.getNextPostId(),1,LocalDate.parse("2025-04-29"),
                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                100, 15000.8, Boolean.TRUE, 0.25);
        return List.of(p1,p2);
    }
    public static List<Post> createPostsDateEqueals(){
        // Seller con 2 posts con fechas iguales
        Post p1 = new Post(IdGenerator.getNextPostId(),1, LocalDate.parse("2025-04-30"),
                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                100, 15000.8, Boolean.TRUE, 0.25);
        Post p2 = new Post(IdGenerator.getNextPostId(),1,LocalDate.parse("2025-04-30"),
                new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                100, 15000.8, Boolean.TRUE, 0.25);
        return List.of(p1,p2);
    }

    public static List<Post> createPostsEmpty(){
        return List.of();
    }


    public static List<Buyer> generateBuyers() {
        return Arrays.asList(
                new Buyer(2, "Alice", List.of(1, 3)),
                new Buyer(3, "Bob", List.of(1)),
                new Buyer(4, "Charlie", List.of(2))
        );
    }

  public static ResponseMessageDTO getFollowResponseMessage(){
        return new ResponseMessageDTO("Vendedor seguido con éxito");
    }

    public static ResponseMessageDTO getAlreadyFollowsMessage(){
        return new ResponseMessageDTO("El usuario ya sigue al vendedor");
    }

    public static ResponseMessageDTO getBuyerNotExistsMessage(Integer id){
        return new ResponseMessageDTO("No existe un usuario con id: " + id);
    }

    public static ResponseMessageDTO FollowersCountSellerNoExist(Integer userId) {
        return new ResponseMessageDTO("No existe un vendedor con id: " + userId);
    }
}
