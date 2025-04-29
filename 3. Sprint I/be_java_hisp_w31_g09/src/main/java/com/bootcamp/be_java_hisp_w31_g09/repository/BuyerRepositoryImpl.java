package com.bootcamp.be_java_hisp_w31_g09.repository;

import com.bootcamp.be_java_hisp_w31_g09.entity.Buyer;
import com.bootcamp.be_java_hisp_w31_g09.utils.IdGenerator;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BuyerRepositoryImpl implements BuyerRepository {
    private List<Buyer> buyerList;

    public BuyerRepositoryImpl() {
        buyerList = new ArrayList<>(Arrays.asList(
                new Buyer(IdGenerator.getNextUserId(), "Alice", new ArrayList<>(Arrays.asList(1, 2, 3))),
                new Buyer(IdGenerator.getNextUserId(), "Bob", new ArrayList<>(Arrays.asList(4, 5, 6))),
                new Buyer(IdGenerator.getNextUserId(), "Charlie", new ArrayList<>(Arrays.asList(7, 5, 6))),
                new Buyer(IdGenerator.getNextUserId(), "Peter", new ArrayList<>())
        ));

    }

    @Override
    public List<Buyer> getSellerFollowers(Integer userId) {
        return buyerList.stream().filter(b -> b.getFollowed().contains(userId)).toList();
    }

    public Optional<Buyer> findById(Integer userId) {
        return buyerList.stream()
                .filter(b -> b.getId().equals(userId))
                .findFirst();
    }

    @Override
    public List<Buyer> findAll() {
        return buyerList;
    }
}
