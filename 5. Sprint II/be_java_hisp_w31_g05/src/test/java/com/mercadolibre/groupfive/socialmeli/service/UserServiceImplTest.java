package com.mercadolibre.groupfive.socialmeli.service;

import static com.mercadolibre.groupfive.socialmeli.util.TestDataFactory.validUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Month;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;

import com.mercadolibre.groupfive.socialmeli.dto.PostDto;
import com.mercadolibre.groupfive.socialmeli.dto.UserDto;
import com.mercadolibre.groupfive.socialmeli.exception.BadRequestException;
import com.mercadolibre.groupfive.socialmeli.model.User;
import com.mercadolibre.groupfive.socialmeli.repository.IUserRepository;
import com.mercadolibre.groupfive.socialmeli.util.TestDataFactory;
import com.mercadolibre.groupfive.socialmeli.exception.NotFoundException;
import com.mercadolibre.groupfive.socialmeli.model.Post;
import com.mercadolibre.groupfive.socialmeli.model.Product;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private String ORDER = "date_desc";

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private static List<Integer> followedUsers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();

    /**
     * Recent Posts -> 14 days or less
     * Old Posts -> 15 days or more
     * Mix Posts -> 14 days or less and 15 days or more
     */

    @BeforeAll
    static void setUp() {
        products.add(new Product(1, "Silla gamer", "Razr", "Gamer", "Rojo", ""));
        products.add(new Product(2, "Teclado mecánico", "Logitech", "Gamer", "Negro", ""));
        products.add(new Product(3, "Mouse inalámbrico", "Razer", "Gamer", "Verde", ""));
        products.add(new Product(4, "Monitor 4K", "Samsung", "Electrónica", "Negro", ""));

        followedUsers.add(99);
    }

    @Test
    void testFindPostByFollowedUserWithRecentPosts() {
        // Arrange
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(99, 99, LocalDate.now(), products.get(0), 120, 100.0);
        Post post2 = new Post(99, 99, LocalDate.now().minusDays(1), products.get(1), 50, 200.0);
        Post post3 = new Post(99, 99, LocalDate.now().minusDays(2), products.get(2), 30, 150.0);
        Post post4 = new Post(99, 99, LocalDate.now().minusDays(3), products.get(3), 70, 80.0);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        Integer expectedSize = posts.size();

        User user = new User(99, "User", followedUsers, followedUsers, posts);

        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        // Act
        UserDto userDto = userService.findPostByFollowedUser(user.getId(), ORDER);

        // Assert
        assertNotNull(userDto);
        assertNotNull(userDto.getPosts());
        assertEquals(expectedSize, userDto.getPosts().size());
    }

    @Test
    void testFindPostByFollowedUserWithOldPosts() {
        // Arrange
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(99, 99, LocalDate.now().minusDays(15), products.get(0), 120, 100.0);
        Post post2 = new Post(99, 99, LocalDate.now().minusDays(15), products.get(1), 50, 200.0);
        Post post3 = new Post(99, 99, LocalDate.now().minusDays(15), products.get(2), 30, 150.0);
        Post post4 = new Post(99, 99, LocalDate.now().minusDays(15), products.get(3), 70, 80.0);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        User user = new User(99, "User", followedUsers, followedUsers, posts);

        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.findPostByFollowedUser(user.getId(), ORDER);
        });
    }

    @Test
    void testFindPostByFollowedUserWithMixPosts() {
        // Arrange
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(99, 99, LocalDate.now().minusDays(14), products.get(0), 120, 100.0);
        Post post2 = new Post(99, 99, LocalDate.now().minusDays(2), products.get(1), 50, 200.0);
        Post post3 = new Post(99, 99, LocalDate.now().minusDays(15), products.get(2), 30, 150.0);
        Post post4 = new Post(99, 99, LocalDate.now().minusDays(15), products.get(3), 70, 80.0);
        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

        Integer expectedSize = 2;

        User user = new User(99, "User", followedUsers, followedUsers, posts);

        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        // Act
        UserDto userDto = userService.findPostByFollowedUser(user.getId(), ORDER);

        // Assert
        assertNotNull(userDto);
        assertEquals(expectedSize, userDto.getPosts().size());
    }

    @Test
    void testFindPostByFollowedUserNotFoundException() {
        // Arrange
        List<Post> posts = new ArrayList<>();

        User user = new User(99, "User", followedUsers, followedUsers, posts);

        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            userService.findPostByFollowedUser(user.getId(), ORDER);
        });
    }

    @Test
    void testFindPostByFollowedUserBadRequestException() {
        // Arrange
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post(99, 99, LocalDate.now().minusDays(14), products.get(0), 120, 100.0);
        posts.add(post1);

        User user = new User(99, "User", followedUsers, followedUsers, posts);

        when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            userService.findPostByFollowedUser(user.getId(), "lol");
        });
    }

    @Test
    void shouldUnfollowUserSuccessfully() {
        // Arrange
        User user = validUser(1, "Test User", List.of(2, 3), List.of(2, 3));
        User userToUnfollow = validUser(2, "Test UserToUnFollow", List.of(1), List.of(1));
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.findById(userToUnfollow.getId())).thenReturn(Optional.of(userToUnfollow));

        doAnswer(invocationOnMock -> {
            Integer followerId = invocationOnMock.getArgument(0);
            Integer followedId = invocationOnMock.getArgument(1);
            if (user.getId().equals(followerId)) {
                user.getFolloweds().remove(followedId);
            }
            if (userToUnfollow.getId().equals(followedId)) {
                userToUnfollow.getFollowers().remove(followerId);
            }
            return null;
        }).when(userRepository).unfollow(anyInt(), anyInt());

        // Act
        userService.unfollow(user.getId(), userToUnfollow.getId());

        // Assert
        verify(userRepository).unfollow(user.getId(), userToUnfollow.getId());
        assertFalse(user.getFolloweds().contains(userToUnfollow.getId()));
        assertFalse(userToUnfollow.getFollowers().contains(user.getId()));
    }

    @Test
    void shouldThrowExceptionWhenUserDoesNotFollowUserToUnfollow() {
        // Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 2;
        User user = TestDataFactory.validUser(userId, "Test User", List.of(3, 4), List.of(3, 4));
        User userToFollow = TestDataFactory.validUser(userIdToUnfollow, "Test UserToUnFollow", List.of(1), List.of(1));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(userRepository.findById(userIdToUnfollow)).thenReturn(Optional.of(userToFollow));

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            userService.unfollow(userId, userIdToUnfollow);
        });
        assertEquals(
                "El usuario ya ha dejado de seguir al usuario o no ha sido seguido",
                exception.getMessage());
        verify(userRepository, never()).unfollow(anyInt(), anyInt());
    }

    @Test
    void countFollowersShouldReturnCorrectFollowersCount() {
        // Arrange
        int userId = 1;
        User user = TestDataFactory.validUser(userId, "Test User", List.of(1, 2, 3, 4, 5), List.of(2, 3));
        doReturn(Optional.of(user)).when(userRepository).findById(userId);

        // Act
        UserDto result = userService.countFollowers(userId);

        // Assert
        assertEquals(userId, result.getId());
        assertEquals("Test User", result.getName());
        assertEquals(user.getFollowers().size(), result.getFollowersCount());
    }

    @Test
    @DisplayName("should return a list of sellers that user followed Asc")
    void shouldReturnAListOfSellersThatUserFollowsAsc() {
        // Arrange
        String order = "name_asc";
        User user = arrangeTestForFollowersAndFolloweds(order);

        // Act
        List<Integer> expectedFollowedIds = runTestForFolloweds(user, order);

        // Assert
        assertThat(expectedFollowedIds).containsExactly(2, 4);
    }

    @Test
    @DisplayName("should return a list of sellers that user followed Desc")
    void shouldReturnAListOfSellersThatUserFollowsDesc() {
        // Arrange
        String order = "name_desc";
        User user = arrangeTestForFollowersAndFolloweds(order);

        // Act
        List<Integer> expectedFollowedIds = runTestForFolloweds(user, order);

        // Assert
        assertThat(expectedFollowedIds).containsExactly(4, 2);
    }

    @Test
    @DisplayName("should return a list of users who follow a seller Asc")
    void shouldReturnListOfUsersWhoFollowSellerAsc() {
        // Arrange
        String order = "name_asc";
        User user = arrangeTestForFollowersAndFolloweds(order);

        // Act
        List<Integer> expectedFollowedIds = runTestForFollowers(user, order);

        // Assert
        assertThat(expectedFollowedIds).containsExactly(2, 4);
    }

    @Test
    @DisplayName("should return a list of users who follow a seller Desc")
    void shouldReturnListOfUsersWhoFollowSellerDesc() {
        // Arrange
        String order = "name_desc";
        User user = arrangeTestForFollowersAndFolloweds(order);

        // Act
        List<Integer> expectedFollowedIds = runTestForFollowers(user, order);

        // Assert
        assertThat(expectedFollowedIds).containsExactly(4, 2);
    }

    private List<Integer> runTestForFolloweds(User user, String order) {
        UserDto userFound = userService.getFollowed(user.getId(), order);
        return userFound
                .getFollowedList()
                .stream()
                .map(UserDto::getId)
                .collect(Collectors.toList());
    }

    private List<Integer> runTestForFollowers(User user, String order) {
        UserDto userFound = userService.getFollowers(user.getId(), order);
        return userFound
                .getFollowersList()
                .stream()
                .map(UserDto::getId)
                .collect(Collectors.toList());
    }

    private User arrangeTestForFollowersAndFolloweds(String order) {
        // Arrange
        User jhon = validUser(4, "Jhon", List.of(), List.of());
        User alice = validUser(2, "Alice", List.of(), List.of());
        List<Integer> expectedFollowedIds = order.equals("name_asc") ?
                List.of(alice.getId(), jhon.getId()) :
                List.of(jhon.getId(), alice.getId());

        User user = validUser(1, "Michell", expectedFollowedIds, expectedFollowedIds);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.findById(jhon.getId())).thenReturn(Optional.of(jhon));
        when(userRepository.findById(alice.getId())).thenReturn(Optional.of(alice));

        return user;
    }

    @Nested
    @DisplayName("When ordering posts of users followed") //Decided to group these test to the SUT keep them atomic & independent
    class ListOfFollowedOrderedNested {

        User userStub;
        User userStubFollowed;
        Post postOne;
        Post postTwo;
        Post postThree;

        @BeforeEach
        void innerSetUp() {

            //ArrayList at the end 'cause of we purposefully need it to be mutable so service method will populate it
            userStub = new User(1, "Jhon", List.of(), List.of(22), new ArrayList<>());

            Product genericProduct = new Product(1, "Silla gamer",
                    "Razr", "Gamer", "Rojo", "");

            postOne = new Post(22, 23, LocalDate.of(2025, Month.MAY, 19), genericProduct, 120, 2800.69);
            postTwo = new Post(22, 23, LocalDate.of(2025, Month.MAY, 21), genericProduct, 120, 2800.69);
            postThree = new Post(22, 23, LocalDate.of(2025, Month.MAY, 20), genericProduct, 120, 2800.69);

            userStubFollowed = new User(22, "Ricky", List.of(1), List.of(), List.of(postOne, postTwo, postThree));
        }

        @Test
        @DisplayName("should return posts in descending date order when DESC keyword is used")
        void returnsPostsInDescendingOrder() {
            // Arrange
            Optional<User> user = Optional.of(userStub);
            Optional<User> userFollowed = Optional.of(userStubFollowed);
            given(userRepository.findById(1)).willReturn(user);
            given(userRepository.findById(22)).willReturn(userFollowed);

            // Act
            UserDto result = userService.findPostByFollowedUser(user.get().getId(), "DATE_DESC");
            List<LocalDate> actualDates = result.getPosts().stream()
                    .map(PostDto::getPublishDate)
                    .toList();

            // Assert
            List<LocalDate> expectedDates = new ArrayList<>(actualDates);
            expectedDates.sort(Comparator.reverseOrder());
            assertEquals(expectedDates, actualDates, "Posts should be ordered descending by publishDate");
            verify(userRepository, times(user.get().getFolloweds().size())).findById(22);
            verify(userRepository, atLeastOnce()).findById(user.get().getId());
        }

        @Test
        @DisplayName("should return posts in ascending date order when ASC keyword is used")
        void returnsPostsInAscendingOrder() {
            // Arrange
            Optional<User> user = Optional.of(userStub);
            Optional<User> userFollowed = Optional.of(userStubFollowed);
            given(userRepository.findById(1)).willReturn(user);
            given(userRepository.findById(22)).willReturn(userFollowed);

            // Act
            UserDto result = userService.findPostByFollowedUser(user.get().getId(), "DATE_ASC");
            List<LocalDate> actualDates = result.getPosts().stream()
                    .map(PostDto::getPublishDate)
                    .toList();

            // Assert
            List<LocalDate> expectedDates = new ArrayList<>(actualDates);
            expectedDates.sort(Comparator.naturalOrder());
            assertEquals(expectedDates, actualDates, "Posts should be ordered ascending by publishDate");
            verify(userRepository, times(user.get().getFolloweds().size())).findById(22);
            verify(userRepository, atLeastOnce()).findById(user.get().getId());
        }

        @Test
        @DisplayName("should throw NotFoundException when followed has no posts")
        void throwsWhenNoPostsFound() {
            // Arrange
            User followedNoPosts = new User(22, "Ricky", List.of(1), List.of(), List.of());
            Optional<User> userFollowed = Optional.of(followedNoPosts);
            given(userRepository.findById(22)).willReturn(userFollowed);

            // Act & Assert
            assertThrowsExactly(NotFoundException.class, () ->
                    userService.findPostByFollowedUser(followedNoPosts.getId(), "DATE_ASC")
            );
            verify(userRepository, atLeastOnce()).findById(22);
        }

        @Test
        @DisplayName("should throw BadRequestException for invalid order keyword")
        void throwsForInvalidOrder() {
            // Arrange
            Optional<User> user = Optional.of(userStub);
            Optional<User> userFollowed = Optional.of(userStubFollowed);
            given(userRepository.findById(1)).willReturn(user);
            given(userRepository.findById(22)).willReturn(userFollowed);

            // Act & Assert
            assertThrowsExactly(BadRequestException.class, () ->
                    userService.findPostByFollowedUser(user.get().getId(), "non")
            );
            verify(userRepository, times(user.get().getFolloweds().size())).findById(22);
            verify(userRepository, atLeastOnce()).findById(user.get().getId());
        }

        @Test
        @DisplayName("should only include posts from followeds published two weeks ago or later")
        void includesOnlyPostsPublishedTwoWeeksAgoOrLater() {
            // Arrange
            Optional<User> user = Optional.of(userStub);
            Optional<User> userFollowed = Optional.of(userStubFollowed);
            given(userRepository.findById(1)).willReturn(user);
            given(userRepository.findById(22)).willReturn(userFollowed);
            LocalDate twoWeeksAgo = LocalDate.now().minusDays(14);

            // Act
            UserDto result = userService.findPostByFollowedUser(user.get().getId(), "DATE_ASC");

            // Assert
            assertTrue(
                    result.getPosts().stream()
                            .allMatch(post -> !post.getPublishDate().isBefore(twoWeeksAgo)),
                    "All posts should be from two weeks ago or later"
            );
            verify(userRepository, times(user.get().getFolloweds().size())).findById(22);
            verify(userRepository, atLeastOnce()).findById(user.get().getId());
        }
    }

    @Nested
    @DisplayName("Tests para el método follow")
    class FollowTests {

        @Test
        @DisplayName("Debe seguir a un usuario correctamente")
        void shouldFollowUserSuccessfully() {
            // Arrange
            User user = TestDataFactory.validUser(1, "Test User", List.of(), List.of(2, 3));
            User userToFollow = TestDataFactory.validUser(4, "User To Follow", List.of(), List.of());

            when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
            when(userRepository.findById(userToFollow.getId())).thenReturn(Optional.of(userToFollow));
            doAnswer(invocation -> {
                user.getFolloweds().add(userToFollow.getId());
                userToFollow.getFollowers().add(user.getId());
                return null;
            }).when(userRepository).follow(user.getId(), userToFollow.getId());

            // Act
            userService.follow(user.getId(), userToFollow.getId());

            // Assert
            verify(userRepository, atLeastOnce()).findById(user.getId());
            verify(userRepository, atLeastOnce()).findById(userToFollow.getId());
            verify(userRepository, atLeastOnce()).follow(user.getId(), userToFollow.getId());

            assertTrue(user.getFolloweds().contains(userToFollow.getId()),
                    "El usuario debería tener al usuario a seguir en su lista de seguidos");
            assertTrue(userToFollow.getFollowers().contains(user.getId()),
                    "El usuario a seguir debería tener al usuario en su lista de seguidores");
        }

        @Test
        @DisplayName("Debe lanzar excepción al intentar seguir a alguien que ya sigue")
        void shouldThrowExceptionWhenUserAlreadyFollows() {
            // Arrange
            User user = TestDataFactory.validUser(1, "Test User", List.of(), List.of(2, 3));
            int userIdToFollow = 2;
            User userToFollow = TestDataFactory.validUser(userIdToFollow, "User To Follow", List.of(), List.of());
            String warning = "El usuario ya sigue al usuario a seguir";

            when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
            when(userRepository.findById(userIdToFollow)).thenReturn(Optional.of(userToFollow));

            // Act & Assert
            Exception exception = assertThrows(BadRequestException.class, () -> {
                userService.follow(user.getId(), userIdToFollow);
            });

            assertEquals(warning, exception.getMessage());
        }

        @Test
        @DisplayName("Debe lanzar excepción al intentar seguirse a sí mismo")
        void shouldThrowExceptionWhenUserFollowsThemselves() {
            User user = TestDataFactory.validUser(1, "Test User", List.of(), List.of(2, 3));

            // Arrange
            String warning = "No se puede seguir asimismo";

            // Act & Assert
            Exception exception = assertThrows(BadRequestException.class, () -> {
                userService.follow(user.getId(), user.getId());
            });

            assertEquals(warning, exception.getMessage());
        }

    }
}