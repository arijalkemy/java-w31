package com.example.demo.service;

import com.example.demo.dto.UserCreationDTO;
import com.example.demo.dto.UserDTO;

import java.util.Optional;

public interface IUserService {

    UserDTO save(UserCreationDTO userDTO);
    UserDTO findByEmail(String email);
}
