package com.bootcamp.be_java_hisp_w31_g09.entity;

//import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Buyer extends User{
    private List<Integer> followed;

    public Buyer(Integer id, String name, List<Integer> followed) {
        super(id, name);
        this.followed = followed;
    }
    public void addFollowed(Integer id) {
        followed.add(id);
    }

    public void removeFollowed(Integer sellerToUnfollow) {
        followed.remove(sellerToUnfollow);
    }

    public boolean follows(Integer sellerToUnfollow) {
        return followed.contains(sellerToUnfollow);
    }
}
