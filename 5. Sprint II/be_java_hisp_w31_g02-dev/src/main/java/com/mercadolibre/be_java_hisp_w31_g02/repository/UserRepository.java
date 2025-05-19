package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.be_java_hisp_w31_g02.entity.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Repository
public class UserRepository implements IUserRepository{
    List<User> users;

    public UserRepository(List<User> users) throws IOException {
        this.users = users;
        loadData("users.json");
    }

    @Override
    public Optional<User> findUserById(Integer idSeller) {
        return getUsers().stream().filter(u -> u.getUserId() == idSeller).findFirst();
    }


    public Boolean existUser(Integer client){
        return getUsers().stream().map(user -> user.getUserId()).toList().contains(client);
    }

    private void loadData(String jsonPath) throws IOException{
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        file= ResourceUtils.getFile("classpath:"+jsonPath);
        this.users = objectMapper.readValue(file,new TypeReference<List<User>>(){});
    }

    public void addPublicationToUser(User seller, Integer publicationId) {
        seller.getPublications().add(publicationId);
    }

    @Override
    public List<User> findUsers(List<Integer> followedBy) {
        return getUsers().stream().filter(u -> followedBy.contains(u.getUserId())).collect(Collectors.toList());
    }

}

