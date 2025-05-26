package com.example.demo.service;

import com.example.demo.dto.UserCreationDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final UserMapper mapper;

    public UserService(IUserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserDTO save(UserCreationDTO userDTO) {
        User user = mapper.creationDtoToEntity(userDTO);
        User savedUser = userRepository.save(user);

        return mapper.entityToDto(savedUser);
    }

    @Override
    public UserDTO findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(mapper::entityToDto)
                .orElseThrow();
    }
}
