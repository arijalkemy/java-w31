package com.mercadolibre.be_java_hisp_w31_g02.service;

import com.mercadolibre.be_java_hisp_w31_g02.dto.*;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Promotion;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Publication;
import com.mercadolibre.be_java_hisp_w31_g02.entity.User;
import com.mercadolibre.be_java_hisp_w31_g02.enums.DateOrder;
import com.mercadolibre.be_java_hisp_w31_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w31_g02.repository.IPromotionRepository;
import com.mercadolibre.be_java_hisp_w31_g02.repository.IPublicationRepository;
import com.mercadolibre.be_java_hisp_w31_g02.repository.ISubscriptionRepository;
import com.mercadolibre.be_java_hisp_w31_g02.repository.IUserRepository;
import com.mercadolibre.be_java_hisp_w31_g02.utils.FormatUtils;
import com.mercadolibre.be_java_hisp_w31_g02.utils.UserPubs;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PublicationService implements IPublicationService {
    private final IPublicationRepository publicationRepository;
    private final IUserRepository userRepository;
    private final IPromotionRepository promotionRepository;
    private final ISubscriptionRepository subscriptionRepository;

    public PublicationService(IPublicationRepository publicationRepository, IUserRepository userRepository, IPromotionRepository promotionRepository, ISubscriptionRepository subscriptionRepository) {
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
        this.promotionRepository = promotionRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    private List<FollowedPublicationDto> pubsByOrder(Stream<FollowedPublicationDto> followedPublicationDtoStream,
                                                     String order) {
        return switch (DateOrder.fromString(order)){
            case DATE_ASC -> followedPublicationDtoStream
                    .sorted(Comparator.comparing(v -> LocalDate.parse(v.getDate())))
                    .toList();
            case DATE_DESC -> followedPublicationDtoStream
                    .sorted(Comparator.comparing((FollowedPublicationDto v) -> LocalDate.parse(v.getDate()))
                    .reversed())
                    .toList();
            case DATE_NULL ->
                    throw new NotFoundException("It is necessary to assign a filter 'date_asc' or 'date_desc'.");
        };
    }

    public String createPublicationOrThrow(PublicationDto publicationDto) {
        Publication publication = PublicationMapper.toEntity(publicationDto);
        Optional<User> seller = userRepository.findUserById(publicationDto.getUser_id());
        if (seller.isEmpty()) {
            throw new NotFoundException("Invalid seller id.");
        }
        try {
            publicationRepository.save(publication);
            userRepository.addPublicationToUser(seller.get(), publication.getPostId());
            if (publicationDto.getHas_promo() != null && publicationDto.getHas_promo()) {
                createPromotionOrThrow(publication.getPostId(), publicationDto.getDiscount(), publication.getPostId(), publication.getPublishDate(),
                        publicationDto.getPromo_exp_date() != null ? FormatUtils.StringDateToLocalDateOrThrow(publicationDto.getPromo_exp_date()) : null);
            }

            return "Publication created successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException("Error creating publication.");
        }


    }

    @Override
    public List<FollowedPublicationDto> getPublicationsFollowedByAnUser(Integer userId, String order) {

        if (!userRepository.existUser(userId)) {
            throw new NotFoundException("Does not exist a user with that id ");
        }
        List<Integer> followedBy = subscriptionRepository.getFollowedSeller(userId).stream().map(x ->
                x.getIdSeller()).toList();
        List<User> followedUsers = userRepository.findUsers(followedBy);
        List<UserPubs> followedUserPub = new ArrayList<>();

        followedUsers.stream().forEach(u -> {
            u.getPublications().stream().forEach(p -> {
                followedUserPub.add(new UserPubs(u, publicationRepository.findById(p)));
            });
        });


        List<FollowedPublicationDto> followedPublicationsDto = new ArrayList<>();

        followedUserPub.forEach((up) -> {
            followedPublicationsDto.add(FollowedPublicationDto
                    .builder()
                    .user_id(up.getUser().getUserId())
                    .price(up.getPublication().getPrice())
                    .date(up.getPublication().getPublishDate().toString())
                    .category(up.getPublication().getCategory())
                    .user_name(up.getUser().getUserName())
                    .product(ProductMapper.toDto(up.getPublication().getProduct()))
                    .build());
        });

        LocalDate twoWeeks = LocalDate.now().minusWeeks(2);
        return pubsByOrder(followedPublicationsDto.stream().filter(
                f -> LocalDate.parse(f.getDate())
                        .isAfter(twoWeeks)), order);
    }


    public void createPromotionOrThrow(Integer postId, Double discount, Integer publicationId, LocalDate initialDate, LocalDate finalDate) {
        LocalDate expirationDate = finalDate == null ? LocalDate.MAX : finalDate;
        if (initialDate.isAfter(expirationDate)) {
            throw new IllegalArgumentException("Date is after expirationDate.");
        }
        try {
            Promotion promotion = new Promotion(null, discount, initialDate, expirationDate, postId);
            promotionRepository.createPromotion(promotion, publicationId);

        } catch (RuntimeException e) {
            throw new NotFoundException("Cannot create post promotion.");
        }
    }

    public ProductCountDto countProduct(Integer userId) {
        return publicationRepository.countProduct(userId);
    }
}
