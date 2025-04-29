package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.*;

public interface IPostService {
    //US0005
    void createPost(PostRequestDto postRequestDTO);
    //US0006
    PostResponseWrapperDto getFollowedSellerPostsInLastTwoWeeks(int user_id, String order);
    //US0010
    void newPostPromo(PostPromoDto postPromoDto);
    //US0011
    PostPromoCountDto getPromoPostCount(int user_id);
    //US0012
    PostPromoWrapperDto getPromoPostList(int user_id);
    //US0013
    void deletePost(int user_id, int post_id);
}
