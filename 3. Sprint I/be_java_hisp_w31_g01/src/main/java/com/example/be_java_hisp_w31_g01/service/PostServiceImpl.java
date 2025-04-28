package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.*;
import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.Post;
import com.example.be_java_hisp_w31_g01.entity.Seller;
import com.example.be_java_hisp_w31_g01.exception.BadRequestException;
import com.example.be_java_hisp_w31_g01.exception.NotFoundException;
import com.example.be_java_hisp_w31_g01.repository.IPostRepository;
import com.example.be_java_hisp_w31_g01.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void createPost(PostRequestDto postRequestDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        postRepository.savePost(objectMapper.convertValue(postRequestDto, Post.class));
    }

    // US0006
    // US0009
    @Override
    public PostResponseWrapperDto getFollowedSellerPostsInLastTwoWeeks(int userId, String order) {
        Customer customer = Optional.ofNullable(userRepository.findCustomerById(userId))
                .orElseThrow(() -> new NotFoundException("Comprador con ID " + userId + " no encontrado."));

        List<Seller> followed = Optional.ofNullable(customer.getFollowed()).orElse(Collections.emptyList());

        if (followed.isEmpty()) {
            throw new NotFoundException("Comprador con ID " + userId + " no sigue a ningún vendedor.");
        }

        List<Integer> followedIds = followed.stream()
                .map(Seller::getUserId)
                .toList();

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        Comparator<Post> comparator = null;

        if (order != null && !order.isBlank()) {
            if ("date_asc".equalsIgnoreCase(order)) {
                comparator = Comparator.comparing(Post::getDate);
            } else if ("date_desc".equalsIgnoreCase(order)) {
                comparator = Comparator.comparing(Post::getDate).reversed();
            } else {
                throw new BadRequestException("Parámetro 'order' inválido. Debe ser 'date_asc' o 'date_desc'.");
            }
        }

        Stream<Post> postStream = postRepository.findAllPosts().stream()
                .filter(post -> followedIds.contains(post.getUserId()) &&
                        !post.getDate().isBefore(twoWeeksAgo));

        if (comparator != null) {
            postStream = postStream.sorted(comparator);
        }

        List<PostResponseDto> postDtos = postStream
                .map(post -> objectMapper.convertValue(post, PostResponseDto.class))
                .toList();

        return new PostResponseWrapperDto(userId, postDtos);
    }

    //US0010
    @Override
    public void newPostPromo(PostPromoDto postPromoDto) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        postRepository.newPostPromo(mapper.convertValue(postPromoDto, Post.class));
    }

    @Override
    public PostPromoCountDto getPromoPostCount(int userId) {
        Seller sellerPromo = userRepository.findSellerById(userId);
        if (Objects.isNull(sellerPromo)) {
            throw new NotFoundException("Vendedor con id: " + userId + " no encontrado.");
        }
        int countPostPromo = postRepository.getPromoPost(userId).size();
        return new PostPromoCountDto(userId, sellerPromo.getUserName(), countPostPromo);
    }

    //US0012
    @Override
    public PostPromoWrapperDto getPromoPostList(int user_id) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Seller sellerById = userRepository.findSellerById(user_id);
        if (Objects.isNull(sellerById)) {
            throw new NotFoundException("Usuario con id: " + user_id + " no se encontró.");
        }

        String userName = sellerById.getUserName();

        List<PostPromoDto> promoDtoList = postRepository.getPromoPost(user_id).stream().map(post -> objectMapper.convertValue(post, PostPromoDto.class)).toList();
        if (promoDtoList.isEmpty()) {
            throw new NotFoundException("Vendedor con id: " + user_id + " no tiene productos con promo.");
        }

        return new PostPromoWrapperDto(user_id, userName,promoDtoList);
    }

    //US0013
    @Override
    public void deletePost(int userId, int postId) {
        Post postToDelete = postRepository.findAllPosts().stream()
                .filter(p -> p.getPostId() == postId && p.getUserId() == userId)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(
                        "No se encontró una publicación con ID " + postId + " para el usuario " + userId));

        postRepository.deletePost(postToDelete);
    }
}
