package com.exampleProject.Restaurant.Service;

import com.exampleProject.Restaurant.DTO.UserDTO;
import com.exampleProject.Restaurant.Entity.UserEntity;

public interface IUserService {
    UserEntity getUserByName(String username);
    boolean checkLogin(UserDTO userDTO);
    boolean register(UserDTO user);
}
