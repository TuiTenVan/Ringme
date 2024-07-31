package com.example.ProjectTest.demo.Service;

import com.example.ProjectTest.demo.DTO.UserDTO;
import com.example.ProjectTest.demo.Entity.UserEntity;
import com.example.ProjectTest.demo.Exception.DataNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserService {
    void createUser(UserDTO userDTO) throws Exception;
    Map<String, Object> login(String phone, String password) throws Exception;
    UserDTO findById(Long id) throws DataNotFoundException;
    UserEntity updateUser(UserDTO updatedUserDTO) throws Exception;
    UserEntity getUserDetailsFromToken(String token) throws Exception;
    UserEntity changePassword(UserDTO userDTO) throws Exception;
    List<UserDTO> getAllUsersByStatus(Integer status) throws Exception;
    void updateUserStatus(Long id, Integer status) throws Exception;
    List<UserDTO> getAllUsers() throws Exception;
    void deleteUser(Long id) throws Exception;
    List<UserDTO> getAllByFullName(String fullName) throws Exception;
}
