package com.mercadolibre.groupfive.socialmeli.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
    private List<Integer> followers;
    private List<Integer> followeds;
    private List<Post> posts;

    public void addPost(Post post) {
        posts.add(post);
    }

    public Integer getAmountPromos() {
        return Long.valueOf(posts.stream().filter(post -> post.getHasPromo().equals(Boolean.TRUE)).count()).intValue();
    }

    public void addFollower(Integer idToBeAddAtFollowersList){
        followers.add(idToBeAddAtFollowersList);
    }
    public void addFollowed(Integer idToBeAddAtFollowedList){
        followeds.add(idToBeAddAtFollowedList);
    }

    public void removeFollowers(Integer idToBeRemovedFromFollowersList){
        followers.removeIf(u -> u.equals(idToBeRemovedFromFollowersList));
    }

    public void removeFollowed(Integer idToBeRemovedFromFollowedList){
        followeds.removeIf(u -> u.equals(idToBeRemovedFromFollowedList));
    }
}
