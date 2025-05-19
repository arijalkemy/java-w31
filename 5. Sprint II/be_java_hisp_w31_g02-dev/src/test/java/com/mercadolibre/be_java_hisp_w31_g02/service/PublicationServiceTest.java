package com.mercadolibre.be_java_hisp_w31_g02.service;
import com.mercadolibre.be_java_hisp_w31_g02.dto.FollowedPublicationDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.ProductMapper;
import com.mercadolibre.be_java_hisp_w31_g02.entity.*;
import com.mercadolibre.be_java_hisp_w31_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w31_g02.repository.*;
import com.mercadolibre.be_java_hisp_w31_g02.utils.UserPubs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Tag("UnitTest")
@ExtendWith(MockitoExtension.class)
public class PublicationServiceTest {
    @Mock
    private IUserRepository userRepository;
    @Mock
    private IPublicationRepository publicationRepository;
    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    private PublicationService publicationService;

    @DisplayName("T-0008 \n" +
            "Returns posts that have a publication date within the last two weeks of today's date. - date_asc")
    @Test
    void getPublicationsFollowedByAnUser_shouldReturnRecentPublicationsSortedCorrectly() {
        // Arrange
        Integer userId = 1;
        Integer sellerId = 2;
        Integer publicationId = 101;
        LocalDate postDateFirst = LocalDate.now().minusDays(3);

        when(userRepository.existUser(userId)).thenReturn(true);

        Subscription sub = new Subscription(userId, sellerId);
        when(subscriptionRepository.getFollowedSeller(userId)).thenReturn(List.of(sub));

        Product productA = new Product(publicationId,"Producto A","Electrodomestico","Brand","Azul","");
        Publication postA = new Publication(publicationId, postDateFirst, 10, 1000D, productA);

        Product productB = new Product((publicationId+1),"Producto A","Mueble","Brand","Rojo","");
        Publication postB = new Publication((publicationId+1), postDateFirst.minusDays(17), 5, 8000D, productB);

        User seller = new User();
        seller.setUserId(sellerId);
        seller.setUserName("Gregorio");
        seller.setPublications(List.of(publicationId,(publicationId+1)));

        when(userRepository.findUsers(List.of(userId))).thenReturn(List.of(seller));
        when(publicationRepository.findById(publicationId)).thenReturn(postA);
        when(publicationRepository.findById(publicationId+1)).thenReturn(postB);


        // Act
        List<FollowedPublicationDto> result = publicationService.getPublicationsFollowedByAnUser(userId, "date_asc");

        // Assert
        assertEquals(1, result.size());
        FollowedPublicationDto dto = result.get(0);
        assertEquals(sellerId, dto.getUser_id());
        assertEquals("Gregorio", dto.getUser_name());
        assertEquals(productA.getProductName(), dto.getProduct().getProduct_name());
        assertEquals(10, dto.getCategory());
        assertEquals(1000D, dto.getPrice());
        assertEquals(postDateFirst.toString(), dto.getDate());

    }

    @DisplayName("T-0005 - Validate order parameters")
    @ParameterizedTest
    @CsvSource({
            "date_asc,false",
            "date_desc,false",
            "null,true"
    })
    void getPublicationsFollowedByAnUser_orderException(String order, boolean shouldThrow) {
        //ARRANGE
        Integer userId = 1;
        when(userRepository.existUser(userId)).thenReturn(true);
        //ACT & ASSERT
        if (shouldThrow) {
            assertThrows(NotFoundException.class, () ->
                    publicationService.getPublicationsFollowedByAnUser(userId, order)
            );
        } else {
            assertDoesNotThrow(() ->
                    publicationService.getPublicationsFollowedByAnUser(userId, order)
            );
        }
    }

    @DisplayName("T-0006 Returns the list sorted according to the requested criteria. - Asc")
    @Test
    public void getPublicationsFollowedByAnUser_validateOrderAsc() {
        //ARRANGE
        Integer userId = 1;
        when(userRepository.existUser(userId)).thenReturn(true);

        List<Subscription> listSubscription = List.of(new Subscription(2, 1), new Subscription(3, 1));
        when(subscriptionRepository.getFollowedSeller(userId)).thenReturn(listSubscription);

        List<Integer> followedBy = List.of(2, 3);
        List<User> followedUsers = List.of(
                new User(2, "Pedro Test", List.of(1)),
                new User(3, "Mateo Test", List.of(2)));
        when(userRepository.findUsers(followedBy)).thenReturn(followedUsers);

        Publication publi1 = new Publication(
                1,
                LocalDate.of(2025, 05, 06),
                1,
                25.4,
                new Product(1, "Zapatos", "Calzado", "Adidas", "Rojo", "Nuevo")
        );

        Publication publi2 = new Publication(
                2,
                LocalDate.of(2025, 05, 06),
                1,
                25.4,
                new Product(2, "Medias", "Calzado", "Nike", "Verde", "Nuevo")
        );

        when(publicationRepository.findById(1)).thenReturn(publi1);
        when(publicationRepository.findById(2)).thenReturn(publi2);

        List<UserPubs> followedUserPubs = List.of(
                new UserPubs(followedUsers.get(0), publi1),
                new UserPubs(followedUsers.get(1), publi2)
        );

        List<FollowedPublicationDto> followedPublicationDtos = List.of(
                new FollowedPublicationDto(
                        followedUserPubs.get(0).getUser().getUserId(),
                        followedUserPubs.get(0).getUser().getUserName(),
                        ProductMapper.toDto(followedUserPubs.get(0).getPublication().getProduct()),
                        followedUserPubs.get(0).getPublication().getCategory(),
                        followedUserPubs.get(0).getPublication().getPrice(),
                        followedUserPubs.get(0).getPublication().getPublishDate().toString()
                ),
                new FollowedPublicationDto(
                        followedUserPubs.get(1).getUser().getUserId(),
                        followedUserPubs.get(1).getUser().getUserName(),
                        ProductMapper.toDto(followedUserPubs.get(1).getPublication().getProduct()),
                        followedUserPubs.get(1).getPublication().getCategory(),
                        followedUserPubs.get(1).getPublication().getPrice(),
                        followedUserPubs.get(1).getPublication().getPublishDate().toString()
                )
        );
        //ACT
        List<FollowedPublicationDto> result = publicationService.getPublicationsFollowedByAnUser(userId, "date_asc");
        //ASSERT
        assertEquals(followedPublicationDtos.size(), result.size());
        assertTrue(result.containsAll(followedPublicationDtos));
        assertTrue(LocalDate.parse(result.get(0).getDate()).isBefore(LocalDate.parse(result.get(1).getDate()))
                || LocalDate.parse(result.get(0).getDate()).isEqual(LocalDate.parse(result.get(1).getDate())));
    }


    @DisplayName("T-0006 Returns the list sorted according to the requested criteria. - Desc")
    @Test
    void getPublicationsFollowedByAnUser_validateOrderDesc() {
        //ARRANGE
        Integer userId = 1;
        when(userRepository.existUser(userId)).thenReturn(true);

        List<Subscription> listSubscription = List.of(new Subscription(2, 1), new Subscription(3, 1));
        when(subscriptionRepository.getFollowedSeller(userId)).thenReturn(listSubscription);

        List<Integer> followedBy = List.of(2, 3);
        List<User> followedUsers = List.of(
                new User(2, "Pedro Test", List.of(1)),
                new User(3, "Mateo Test", List.of(2)));
        when(userRepository.findUsers(followedBy)).thenReturn(followedUsers);

        Publication publi1 = new Publication(
                1,
                LocalDate.of(2025, 05, 06),
                1,
                25.4,
                new Product(1, "Zapatos", "Calzado", "Adidas", "Rojo", "Nuevo")
        );

        Publication publi2 = new Publication(
                2,
                LocalDate.of(2025, 05, 06),
                1,
                25.4,
                new Product(2, "Medias", "Calzado", "Nike", "Verde", "Nuevo")
        );

        when(publicationRepository.findById(1)).thenReturn(publi1);
        when(publicationRepository.findById(2)).thenReturn(publi2);

        List<UserPubs> followedUserPubs = List.of(
                new UserPubs(followedUsers.get(0), publi1),
                new UserPubs(followedUsers.get(1), publi2)
        );

        List<FollowedPublicationDto> followedPublicationDtos = List.of(
                new FollowedPublicationDto(
                        followedUserPubs.get(0).getUser().getUserId(),
                        followedUserPubs.get(0).getUser().getUserName(),
                        ProductMapper.toDto(followedUserPubs.get(0).getPublication().getProduct()),
                        followedUserPubs.get(0).getPublication().getCategory(),
                        followedUserPubs.get(0).getPublication().getPrice(),
                        followedUserPubs.get(0).getPublication().getPublishDate().toString()
                ),
                new FollowedPublicationDto(
                        followedUserPubs.get(1).getUser().getUserId(),
                        followedUserPubs.get(1).getUser().getUserName(),
                        ProductMapper.toDto(followedUserPubs.get(1).getPublication().getProduct()),
                        followedUserPubs.get(1).getPublication().getCategory(),
                        followedUserPubs.get(1).getPublication().getPrice(),
                        followedUserPubs.get(1).getPublication().getPublishDate().toString()
                )
        );
        //ACT
        List<FollowedPublicationDto> result = publicationService.getPublicationsFollowedByAnUser(userId, "date_desc");
        //ASSERT
        assertEquals(followedPublicationDtos.size(), result.size());
        assertTrue(result.containsAll(followedPublicationDtos));
        assertTrue(LocalDate.parse(result.get(1).getDate()).isBefore(LocalDate.parse(result.get(0).getDate()))
                || LocalDate.parse(result.get(1).getDate()).isEqual(LocalDate.parse(result.get(0).getDate())));
    }

    @DisplayName("T-0006 Error does not user exist")
    @Test
    void getPublicationsFollowedByAnUser_throwsUserNotExist() {
    //ARRANGE
    Integer idUser = 1;
    Boolean userExist = false;
    String order = "";
    // ACT
        Mockito.when(userRepository.existUser(idUser)).thenReturn(userExist);
    //ASSERT
        Assertions.assertThrows(NotFoundException.class, () -> publicationService.getPublicationsFollowedByAnUser(idUser,order));
    }
}
