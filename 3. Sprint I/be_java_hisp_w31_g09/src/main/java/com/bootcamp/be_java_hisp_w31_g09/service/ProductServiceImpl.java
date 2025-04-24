package com.bootcamp.be_java_hisp_w31_g09.service;

import com.bootcamp.be_java_hisp_w31_g09.dto.*;
import com.bootcamp.be_java_hisp_w31_g09.entity.Post;
import com.bootcamp.be_java_hisp_w31_g09.entity.Seller;
import com.bootcamp.be_java_hisp_w31_g09.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w31_g09.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w31_g09.mapper.PostMapper;
import com.bootcamp.be_java_hisp_w31_g09.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    UserService userService;

    private List<Post> getRecentFollowedPosts(int userId) {

        UserListDTO response = userService.searchSellersFollowed(userId);
        List<Integer> followedSellersId = response.getUserList().stream()
                .map(UserDTO::getUserId)
                .toList();


        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        return sellerRepository.getAll().stream()
                .filter(seller -> followedSellersId.contains(seller.getId()))
                .flatMap(seller -> seller.getPosts().stream())
                .filter(post -> post.getDate().isAfter(twoWeeksAgo))
                .collect(Collectors.toList());
    }

    public UserPostsResponseDTO getFollowedPostsOrder(int userId, String order) {
        List<Post> posts = getRecentFollowedPosts(userId);

        if (Objects.isNull(order)) {
            // Orden por defecto: más recientes primero (descendente)
            List<PromoPostDTO> recentPosts = posts.stream()
                    .sorted(Comparator.comparing(Post::getDate).reversed())
                    .map(PostMapper::toPromoDto)
                    .collect(Collectors.toList());

            return new UserPostsResponseDTO(userId, recentPosts);
        } else {
            Comparator<Post> comparator = switch (order) {
                case "date_asc" -> Comparator.comparing(Post::getDate);
                case "date_desc" -> Comparator.comparing(Post::getDate).reversed();
                default -> throw new BadRequestException("Ese orden no es valido.");
            };

            List<PromoPostDTO> orderedPosts = posts.stream()
                    .sorted(comparator)
                    .map(PostMapper::toPromoDto)
                    .collect(Collectors.toList());

            return new UserPostsResponseDTO(userId, orderedPosts);
        }
    }

    @Override
    public ResponseMessageDTO savePost(RequestPostDTO requestPostDTO) {
        Post post = PostMapper.mapToPost(requestPostDTO);
        if(!sellerRepository.addPost(post, requestPostDTO.getUserId())) {
            throw new NotFoundException("No existe el vendedor");
        }
        return new ResponseMessageDTO("Post creado exitosamente");
    }

    @Override
    public ResponseMessageDTO savePromoPost(RequestPromoPostDTO requestPromoPostDTO) {
        Post post = PostMapper.mapToPromoPost(requestPromoPostDTO);
        if(!sellerRepository.addPost(post, requestPromoPostDTO.getUserId())) {
            throw new NotFoundException("No existe el vendedor");
        }
        return new ResponseMessageDTO("Promo post creado exitosamente");
    }

    @Override
    public ResponsePromoPostDTO getPromoPostsByUser(Integer userId) {
        Seller seller = sellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        List<Post> postsList = sellerRepository.getPromoPostsByUser(userId);
        List<PromoPostDTO> promoPostDTOList = postsList.stream()
                .map(PostMapper::toPromoDto)
                .toList();

        return new ResponsePromoPostDTO(userId, seller.getName(), promoPostDTOList);
    }

    @Override
    public PromoProductsCountResponseDTO getPromoProductsCount(Integer userId) {
        Seller seller = sellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        long promoProductsCount = seller.getPosts().stream()
                .filter(Post::getHasPromo)
                .count();

        return new PromoProductsCountResponseDTO(seller.getId(), seller.getName(), (int) promoProductsCount);
    }

    @Override
    public ResponseMessageDTO updateDiscountByPostId(Integer postId, Integer sellerId, DiscountDTO discountDTO) {
        if (discountDTO.getDiscount() > 1) {
            throw new BadRequestException("El descuento no es válido");
        }

        Post post = sellerRepository.findPostById(sellerId, postId)
                .orElseThrow(() -> new NotFoundException("No existe el Post ID: " + postId + " del vendedor con id: " + sellerId));

        post.setDiscount(discountDTO.getDiscount());
        post.setHasPromo(true);

        return new ResponseMessageDTO("Se actualizó exitosamente el descuento");
    }

    @Override
    public ResponseMessageDTO updateDiscountsBySeller(Integer userId, Double discount) {
        if (discount > 1) {
            throw new BadRequestException("El descuento no es válido.");
        }

        Seller seller = sellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        List<Post> posts = seller.getPosts();

        if (posts.isEmpty()) {
            throw new BadRequestException("El vendedor no tiene posts");
        }

        posts.forEach(post -> {
            post.setDiscount(discount);
            post.setHasPromo(true);
        });

        return new ResponseMessageDTO("Descuentos realizados con éxito.");
    }

    @Override
    public UserPostsResponseDTO getPostsByUser(Integer user_id) {
        List<Post> posts = sellerRepository.findPostsById(user_id)
                .orElseThrow(() -> new NotFoundException("No hay posts del usuario con id: " + user_id));

        List<PromoPostDTO> postDtos = posts.stream()
                .map(PostMapper::toPromoDto)
                .toList();

        return new UserPostsResponseDTO(user_id, postDtos);
    }

    @Override
    public ResponseMessageDTO updateUserPrices(Integer userId, UpdatePricesDTO updatePricesDTO) {
        Seller seller = sellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        List<Post> posts = seller.getPosts();
        if (posts.isEmpty()) {
            throw new NotFoundException("El vendedor no tiene productos");
        }

        double percentage = updatePricesDTO.getPercentage();
        applyPriceUpdate(posts, updatePricesDTO.getOperation(), percentage);
        return new ResponseMessageDTO("Precios actualizados exitosamente.");
    }

    private void applyPriceUpdate(List<Post> posts, String operation, double percentage) {
        switch (operation) {
            case "increase" -> posts.forEach(post -> post.setPrice(post.getPrice() * (1 + percentage)));
            case "decrease" -> {
                if (percentage >= 1) {
                    throw new BadRequestException("No puede disminuir los precios en un 100% o más.");
                }
                posts.forEach(post -> post.setPrice(post.getPrice() * (1 - percentage)));
            }
            default -> throw new BadRequestException("Esa operación no es válida.");
        }
    }

    @Override
    public List<PromoPostDTO> getPostsByPriceRange(Integer userId, Double minPrice, Double maxPrice) {
        Seller seller = sellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("No existe un vendedor con id: " + userId));

        return seller.getPosts().stream()
                .filter(post -> post.getPrice() >= minPrice && post.getPrice() <= maxPrice)
                .map(PostMapper::toPromoDto)
                .toList();
    }

}
