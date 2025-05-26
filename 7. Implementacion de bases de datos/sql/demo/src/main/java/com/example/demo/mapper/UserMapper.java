package com.example.demo.mapper;

import com.example.demo.dto.UserCreationDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDTO entityToDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getActive(),
                user.getCreationDate()
        );
    }

    public User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setActive(userDTO.getActive());
        user.setCreationDate(userDTO.getCreationDate());
        return user;
    }

    public User creationDtoToEntity(UserCreationDTO userCreationDTO) {
        User user = new User();
        user.setName(userCreationDTO.getName());
        user.setLastName(userCreationDTO.getLastName());
        user.setEmail(userCreationDTO.getEmail());
        user.setPassword(userCreationDTO.getPassword());
        user.setActive(true);

        return user;
    }

    public List<UserDTO> entityListToDtoList(List<User> usuarios) {
        return usuarios.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
