package com.example.be_java_hisp_w31_g01.service;

import com.example.be_java_hisp_w31_g01.dto.FollowedResponseDto;
import com.example.be_java_hisp_w31_g01.dto.FollowerResponseDTO;

public interface IUserService {
    //US0001
    void followSeller(int customerId, int sellerId);
    //US0002
    long countFollowers(int user_id);
    String user_nameSeller(int user_id);
    //US0003
    FollowerResponseDTO getFollowers(int user_id, String order);
    //US0004
    FollowedResponseDto getFollowed(int user_id, String order);
    //US0007
    void unfollowSeller(int customerId, int sellerId);
}
