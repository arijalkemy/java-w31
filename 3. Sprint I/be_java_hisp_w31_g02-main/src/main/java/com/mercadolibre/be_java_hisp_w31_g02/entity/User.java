package com.mercadolibre.be_java_hisp_w31_g02.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements IClient, ISeller{
    private String user_id;
    private String user_name;
    private List<Publication> publications;
}
