package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDocumentStore {
    private List<User> documentStore= new ArrayList<>();

    public void index(User user){
        documentStore.add(user);
    }

    public List<User> findUsersByPais(String pais){
        return documentStore.stream()
                .filter(a-> a.getPais().equalsIgnoreCase(pais))
                .collect(Collectors.toList());
    }
}
