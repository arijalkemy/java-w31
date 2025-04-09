package com.meli.blog.service;

import java.util.List;

import com.meli.blog.dto.CreatePostRequestDTO;
import com.meli.blog.dto.GetPostResponseDTO;

public interface PostService {
    public String createPost(CreatePostRequestDTO body);

    public GetPostResponseDTO getById(String id);

    public List<GetPostResponseDTO> getAllPosts();

}
