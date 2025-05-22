package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Post;
import com.example.be_java_hisp_w31_g01.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryImplTest {

    @Autowired
    IPostRepository postRepository;

    // T0009
    @Test
    void should_createPostPromo_when_validPostIsGiven() {

        // Arrange
        Product product = new Product(1,
                                    "Galaxy S21",
                                    "Smartphone",
                                    "Samsung",
                                    "Phantom Gray",
                                    "128GB, 8GB RAM");

        Post post = new Post(1,
                            1,
                            LocalDate.parse("2025-04-15"),
                            product,
                            1,
                            799.99,
                            true,
                            10.0);

        // Act
        postRepository.newPostPromo(post);

        // Assert
        assertFalse(postRepository.findAllPosts().isEmpty());
        assertTrue(postRepository.findAllPosts().contains(post));
    }

   @Test
    void savePost() {
        // Arrange
        Post post = new Post(
                1,
                1,
                LocalDate.parse("2025-04-15"),
                new Product(1, "Galaxy S21", "Smartphone", "Samsung", "Phantom Gray", "128GB, 8GB RAM"),
                58,
                799.99,
                false,
                0.0
        );

        // Act
        postRepository.savePost(post);
        List<Post> allPosts = postRepository.findAllPosts();

        // Assert
        assertEquals(12, allPosts.size());
        assertEquals("Galaxy S21", allPosts.get(0).getProduct().getProduct_name());
    }

    @Test
    void deletePost() {
        // Arrange
        Post postDelete = new Post(
                7,
                1,
                LocalDate.parse("2025-04-20"),
                new Product(
                        11,
                        "Samsung Galaxy Watch 5",
                        "Smartwatch",
                        "Samsung",
                        "Graphite",
                        "44mm, Bluetooth"
        ),
                4,
                279.99,
                false,
                0.0
        );
        postRepository.savePost(postDelete);
        assertTrue(postRepository.findAllPosts().contains(postDelete));

        // Act
        postRepository.deletePost(postDelete);

        // Assert
        assertFalse(postRepository.findAllPosts().contains(postDelete));

    }
}