package com.mercadolibre.groupfive.socialmeli.service;

import com.mercadolibre.groupfive.socialmeli.exception.NotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.groupfive.socialmeli.dto.PostDto;
import com.mercadolibre.groupfive.socialmeli.exception.BadRequestException;
import com.mercadolibre.groupfive.socialmeli.model.Post;
import com.mercadolibre.groupfive.socialmeli.model.Product;
import com.mercadolibre.groupfive.socialmeli.model.User;
import com.mercadolibre.groupfive.socialmeli.repository.IPostRepository;
import static com.mercadolibre.groupfive.socialmeli.dto.PostDto.*;

@Service
public class PostServiceImpl implements IPostService {

    private final IProductService productService;
    private final IPostRepository postRepository;
    private final IUserService userService;

    private final ObjectMapper mapper = new ObjectMapper();

    public PostServiceImpl(IUserService userService, IProductService productService, IPostRepository postRepository) {
        this.userService = userService;
        this.productService = productService;
        this.postRepository = postRepository;
    }

    @Override
    public void createPromoPost(PostDto postDto) {
        createAndSavePost(postDto, postDto.getHasPromo(), postDto.getDiscount());
    }

    @Override
    public void createPost(PostDto postDto) {
        createAndSavePost(postDto, false, 0.0);
    }

    @Override
    public List<PostDto> findPostsByBrand(String brand) {
        List<Post> allPostsByBrand = postRepository.findAllByBrand(brand);
        List<PostDto> filteredByBrand = PostDto.fromPostToPostDto(allPostsByBrand);

        if (filteredByBrand.isEmpty()) {
            throw new NotFoundException("No se encontraron posts de la marca");
        }
        return filteredByBrand;
    }

    private void createAndSavePost(PostDto postDto, Boolean hasPromo, Double discount) {
        Product product = mapper.convertValue(postDto.getProductDto(), Product.class);
        productService.save(product);

        Post post = new Post(
                postDto.getUserId(),
                null,
                postDto.getPublishDate(),
                product,
                postDto.getCategory(),
                postDto.getPrice(),
                hasPromo,
                discount);

        postRepository.save(post);
        User user = userService.findById(postDto.getUserId());
        user.addPost(post);
    }

    @Override
    public List<PostDto> findAllByPriceRange(Double min, Double max) {
        if (max < min)
            throw new BadRequestException("El rango de precios es incorrecto");
        List<Post> listOfPosts = this.postRepository.findAllByPriceRange(min, max);
        if (listOfPosts.isEmpty())
            throw new NotFoundException("No hay posts dentro del rango de precio establecido");
        return fromPostToPostDto(listOfPosts);
    }
}
