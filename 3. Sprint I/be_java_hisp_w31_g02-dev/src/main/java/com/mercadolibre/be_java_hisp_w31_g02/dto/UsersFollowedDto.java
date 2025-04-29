package com.mercadolibre.be_java_hisp_w31_g02.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersFollowedDto {
    private Integer userId;
    private String userName;
    private List<UserDto> followed;
}