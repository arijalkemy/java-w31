package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.*;

import java.util.List;

public interface IPostService {
    void createPost(PostRequestDto postRequestDTO);

    PostResponseWrapperDto getFollowedSellerPostsInLastTwoWeeks(int userId, String order);
  
    void newPostPromo(PostPromoDto postPromoDto);

    PostPromoCountDto getPromoPostCount(int user_id);

    PostPromoWrapperDto getPromoPostList(int user_id);

    void deletePost(int userId, int postId);
}
