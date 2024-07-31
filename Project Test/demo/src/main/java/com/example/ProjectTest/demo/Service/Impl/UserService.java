package com.example.ProjectTest.demo.Service.Impl;

import com.example.ProjectTest.demo.Components.JwtTokenUtil;
import com.example.ProjectTest.demo.Convert.UserConvert;
import com.example.ProjectTest.demo.DTO.UserDTO;
import com.example.ProjectTest.demo.Entity.RoleEntity;
import com.example.ProjectTest.demo.Entity.UserEntity;
import com.example.ProjectTest.demo.Entity.UserRoleEntity;
import com.example.ProjectTest.demo.Exception.DataNotFoundException;
import com.example.ProjectTest.demo.Repository.UserRepository;
import com.example.ProjectTest.demo.Repository.UserRoleRepository;
import com.example.ProjectTest.demo.Service.IRoleService;
import com.example.ProjectTest.demo.Service.IUserRoleService;
import com.example.ProjectTest.demo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserConvert userConvert;
    private final IUserRoleService userRoleService;
    private final IRoleService roleService;

    @Override
    @Transactional
    public void createUser(UserDTO userDTO) throws Exception {
        String phoneNumber = userDTO.getPhone();
        if(userRepository.existsByPhone(phoneNumber)){
            throw new DataIntegrityViolationException("Phone number already exists");
        }
        UserEntity userEntity = userConvert.toUserEntity(userDTO);
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        userEntity.setPassword(encodedPassword);
        List<UserRoleEntity> userRoles = new ArrayList<>();
        RoleEntity roleEntity = roleService.findById(2L);
        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setUser(userEntity);
        userRole.setRole(roleEntity);
        userRoles.add(userRole);
        userRoleRepository.saveAll(userRoles);
        userEntity.setUserRoleEntityList(userRoles);
        userRepository.save(userEntity);
    }

    @Override
    public Map<String, Object> login(String phone, String password) throws Exception {
        Optional<UserEntity> optionalUser = userRepository.findByPhone(phone);
        if(optionalUser.isEmpty()){
            throw new DataNotFoundException("Invalid phone or password");
        }
        UserEntity existingUser = optionalUser.get();
        if(!passwordEncoder.matches(password, existingUser.getPassword())){
            throw new BadCredentialsException("Wrong phone or password");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                phone, password, existingUser.getAuthorities()
        );
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = jwtTokenUtil.generateToken(existingUser);
        return roleService.getStringObjectMap(existingUser, token);
    }


    @Override
    public UserDTO findById(Long id) throws DataNotFoundException {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        return userConvert.toUserDTO(existingUser);
    }

    @Transactional
    @Override
    public UserEntity updateUser(UserDTO updatedUserDTO) throws Exception {
        UserEntity existingUser = userRepository.findById(updatedUserDTO.getId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));

        String newPhoneNumber = updatedUserDTO.getPhone();
        if (existingUser.getPhone().equals(newPhoneNumber) &&
                userRepository.existsByPhone(newPhoneNumber)) {
            throw new DataIntegrityViolationException("Phone number already exists");
        }
        existingUser.setFullName(updatedUserDTO.getFullName());
        existingUser.setAddress(updatedUserDTO.getAddress());
        existingUser.setBirthday(updatedUserDTO.getBirthday());
        existingUser.setEmail(updatedUserDTO.getEmail());
        existingUser.setGender(updatedUserDTO.getGender());
        if(updatedUserDTO.getRole() != null){
            userRoleService.updateRoleUser(updatedUserDTO, updatedUserDTO.getRole());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public UserEntity changePassword(UserDTO updatedUserDTO) throws Exception {
        UserEntity existingUser = userRepository.findById(updatedUserDTO.getId())
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        if(!updatedUserDTO.getPassword().equals(updatedUserDTO.getRetypePassword())) {
            throw new DataNotFoundException("Password and retype password not the same");
        }
        String newPassword = updatedUserDTO.getPassword();
        String encodedPassword = passwordEncoder.encode(newPassword);
        existingUser.setPassword(encodedPassword);
        return userRepository.save(existingUser);
    }

    @Override
    public List<UserDTO> getAllUsersByStatus(Integer status) throws Exception {
        List<UserEntity> users = userRepository.findByStatus(status);
        List<UserDTO> userDTOs = new ArrayList<>();
        for(UserEntity user : users){
            userDTOs.add(userConvert.toUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public void updateUserStatus(Long id, Integer status) throws Exception {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        existingUser.setStatus(status);
        userRepository.save(existingUser);
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        List<UserEntity> users = userRepository.findAll(0);
        List<UserDTO> userDTOs = new ArrayList<>();
        for(UserEntity user : users){
            userDTOs.add(userConvert.toUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User not found"));
        existingUser.setStatus(-1);
        userRepository.save(existingUser);
    }

    @Override
    public List<UserDTO> getAllByFullName(String fullName) throws Exception {
        List<UserEntity> userEntityList = userRepository.findAllByFullName(fullName);
        List<UserDTO> userDTOs = new ArrayList<>();
        for(UserEntity user : userEntityList){
            userDTOs.add(userConvert.toUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public UserEntity getUserDetailsFromToken(String token) throws Exception {
        if(jwtTokenUtil.isTokenExpired(token)) {
            throw new Exception("Token is expired");
        }
        String phoneNumber = jwtTokenUtil.extractPhone(token);
        Optional<UserEntity> user = userRepository.findByPhone(phoneNumber);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("User not found");
        }
    }
}

