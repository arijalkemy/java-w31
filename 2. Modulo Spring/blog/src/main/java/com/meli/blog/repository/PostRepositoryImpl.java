package com.meli.blog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.meli.blog.model.PostModel;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final Map<String, PostModel> posts = new HashMap<String, PostModel>();

    @Override
    public String createPost(PostModel post) {
        posts.put(post.getId(), post);
        return "Post creado con id: " + post.getId();
    }

    @Override
    public PostModel getById(String id) {
        return posts.get(id);
    }

    @Override
    public boolean existsById(String id) {
        return posts.containsKey(id);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return List.copyOf(posts.values());
    }
}
