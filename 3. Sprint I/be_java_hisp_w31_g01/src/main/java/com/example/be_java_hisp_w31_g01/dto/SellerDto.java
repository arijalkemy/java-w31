package com.example.be_java_hisp_w31_g01.dto;

import com.example.be_java_hisp_w31_g01.entity.Customer;
import com.example.be_java_hisp_w31_g01.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto extends User {
    private long followers_count;

    public SellerDto(int userId, String userName, long count) {
        this.setUserId(userId);
        this.setUserName(userName);
        this.followers_count = count;
    }
}
