package com.mercadolibre.be_java_hisp_w31_g02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerCountDto {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}