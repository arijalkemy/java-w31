package com.mercadolibre.be_java_hisp_w31_g02.utils;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Publication;
import com.mercadolibre.be_java_hisp_w31_g02.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPubs {
    User user;
    Publication publication;
}
