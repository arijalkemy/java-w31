package com.bootcamp.be_java_hisp_w31_g09.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller extends User {
    private List<Post> posts;

    public Seller(Integer id, String name, List<Post> posts) {
        super(id, name);
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
