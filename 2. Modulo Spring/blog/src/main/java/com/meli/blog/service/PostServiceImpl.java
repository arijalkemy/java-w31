package com.meli.blog.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.stereotype.Service;

import com.meli.blog.dto.CreatePostRequestDTO;
import com.meli.blog.dto.GetPostResponseDTO;
import com.meli.blog.model.PostModel;
import com.meli.blog.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String createPost(CreatePostRequestDTO body) {
        verifyIdDoesNotExist(body.getId());

        PostModel post = new PostModel(
                body.getId(),
                body.getTitle(),
                body.getAuthorName(),
                LocalDate.now().format(formatter));

        return postRepository.createPost(post);
    }

    @Override
    public GetPostResponseDTO getById(String id) {
        PostModel post = postRepository.getById(id);

        if (post == null) {
            throw new NoSuchElementException("No se encontró un post con ID: " + id);
        }

        return GetPostResponseDTO.mapPostModelToDTO(post);
    }

    @Override
    public List<GetPostResponseDTO> getAllPosts() {
        List<PostModel> posts = postRepository.getAllPosts();

        if (posts.isEmpty()) {
            throw new NoSuchElementException("No se encontraron posts");
        }

        return GetPostResponseDTO.mapPostModelListToDTO(posts);
    }

    private void verifyIdDoesNotExist(String id) {
        if (postRepository.existsById(id)) {
            throw new IllegalArgumentException("Ya existe un post con el ID: " + id);
        }
    }

}
