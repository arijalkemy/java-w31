package com.example.be_java_hisp_w31_g01.dto;

import com.example.be_java_hisp_w31_g01.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto extends User {
    private long followers_count;

    public SellerDto(int user_id, String user_name, long count) {
        this.setUser_id(user_id);
        this.setUser_name(user_name);
        this.followers_count = count;
    }
}
