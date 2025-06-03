package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Post;

import java.util.List;

public interface IPostRepository {
    void savePost(Post post);
    List<Post> findAllPosts();
    void newPostPromo(Post post);
    List<Post> getPromoPost(int user_id);
    void deletePost(Post post);

}
