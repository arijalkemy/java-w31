package com.mercadolibre.be_java_hisp_w31_g02.dto;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    private Integer idUser;
    private Integer idFollowedSeller;

    public static SubscriptionDto getSubscriptionDto(Subscription Subscription){
        return new SubscriptionDto( Subscription.getIdClient(), Subscription.getIdSeller());
    }
}
