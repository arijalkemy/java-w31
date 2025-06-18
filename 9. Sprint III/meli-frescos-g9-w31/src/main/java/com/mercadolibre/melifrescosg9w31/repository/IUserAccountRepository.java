package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserName(String userName);

}
