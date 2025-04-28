package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Post;

import java.util.List;

public interface IPostRepository {
    void savePost(Post post);

    List<Post> findAllPosts();
  
    //US0010
    void newPostPromo(Post post);

    List<Post> getPromoPost(int userId);

    void deletePost(Post post);

}
