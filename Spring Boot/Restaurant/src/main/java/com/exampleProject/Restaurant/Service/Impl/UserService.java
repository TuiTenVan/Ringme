package com.exampleProject.Restaurant.Service.Impl;

import com.exampleProject.Restaurant.DTO.UserDTO;
import com.exampleProject.Restaurant.Entity.UserEntity;
import com.exampleProject.Restaurant.Repository.UserRepository;
import com.exampleProject.Restaurant.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserEntity getUserByName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public boolean checkLogin(UserDTO userDTO) {
        UserEntity user = userRepository.findByName(userDTO.getName());
        return user.getPassword().equals(userDTO.getPassword());
    }

    @Override
    public boolean register(UserDTO user) {
        if (userRepository.findByPhone(user.getPhone()) != null) {
            return false;
        }
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userEntity.setStatus(0);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userEntity);
        return true;
    }
}
