package com.example.be_java_hisp_w31_g01.repository;

import com.example.be_java_hisp_w31_g01.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    private List<Post> listOfPosts = new ArrayList<>();

    public PostRepositoryImpl() throws IOException {
        loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<Post> posts;

        file = ResourceUtils.getFile("classpath:posts.json");
        posts = objectMapper.readValue(file, new TypeReference<List<Post>>() {});

        listOfPosts = posts;
    }

    @Override
    public List<Post> findAllPosts() {
        return listOfPosts;
    }

    @Override
    public void savePost(Post post) {
        listOfPosts.add(post);
    }

    @Override
    public void newPostPromo(Post post) {
        listOfPosts.add(post);
    }

    //US0011
    @Override
    public List<Post> getPromoPost(int user_id) {
        List<Post> listPostBySeller = findAllPosts().stream().filter(p -> p.getUser_id() == user_id).toList();
        return listPostBySeller.stream().filter(Post::isHasPromo).collect(Collectors.toList());
    }

    @Override
    public void deletePost(Post post) {
        listOfPosts.remove(post);
    }
}
