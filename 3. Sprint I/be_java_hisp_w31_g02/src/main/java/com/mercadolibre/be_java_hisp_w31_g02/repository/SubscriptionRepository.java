package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Subscription;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Repository
public class SubscriptionRepository implements ISubscriptionRepository{
    
    private List<Subscription> listSubscription;
    private final ObjectMapper objectMapper;
    
    public SubscriptionRepository(List<Subscription> listSubscription, ObjectMapper objectMapper) throws IOException {
        this.objectMapper = objectMapper;
        this.listSubscription = listSubscription;
        loadData("Subscription.json");
    }

    @Override
    public List<Subscription> getAllUsersFollowedByAnUser(Integer userId) {
        return listSubscription.stream().filter(seller -> seller.getIdClient().equals(userId)).collect(Collectors.toList());
    }

    public void addUserFollowedByAnUser(Subscription Subscription){
        listSubscription.add(Subscription);
    }

    public Boolean existRelationBetweenUsers(Integer userId, Integer userIdToFollow){
        List<Integer> listFollowers = this.listSubscription.stream()
        .filter(Subscription -> Subscription.getIdSeller().equals(userIdToFollow))
        .map(Subscription -> Subscription.getIdClient())
        .toList();
        return listFollowers.contains(userId);
    }

    private void loadData(String jsonPath) throws IOException {
        File file;
        file= ResourceUtils.getFile("classpath:"+jsonPath);
        this.listSubscription = objectMapper.readValue(file,new TypeReference<>(){});
    }

    @Override
    public List<Subscription> listFollowerById(Integer sellerId) {
        return listSubscription.stream().filter(x -> x.getIdSeller().equals(sellerId)).collect(Collectors.toList());
    }

    @Override
    public Optional<Subscription> findFollowerById(Integer userId, Integer unfollowerSellerId) {
        return listSubscription.stream()
                .filter(x -> (x.getIdClient().equals(userId) && x.getIdSeller().equals(unfollowerSellerId)))
                .findAny();
    }

    @Override
    public void deleteFollower(Subscription Subscription) {
        listSubscription.remove(Subscription);
    }

    @Override
    public List<Subscription> getAllFollowersOfASeller(Integer userId){
        return listSubscription.stream().filter(seller -> seller.getIdSeller().equals(userId)).toList();
    }

    @Override
    public List<Subscription> getFollowedSeller(Integer userId) {
        return listSubscription.stream().filter(seller -> seller.getIdClient().equals(userId)).toList();
    }
}
