package com.meli.blog.repository;

import java.util.List;

import com.meli.blog.model.PostModel;

public interface PostRepository {
    public String createPost(PostModel post);

    public PostModel getById(String id);

    public boolean existsById(String id);

    public List<PostModel> getAllPosts();
}
