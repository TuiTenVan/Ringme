package com.example.ProjectTest.demo.Service.Impl;

import com.example.ProjectTest.demo.DTO.UserDTO;
import com.example.ProjectTest.demo.Entity.RoleEntity;
import com.example.ProjectTest.demo.Entity.UserRoleEntity;
import com.example.ProjectTest.demo.Repository.RoleRepository;
import com.example.ProjectTest.demo.Repository.UserRoleRepository;
import com.example.ProjectTest.demo.Service.IUserRoleService;
import com.example.ProjectTest.demo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService implements IUserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    @Override
    public void updateRoleUser(UserDTO userDTO, String role) {
        List<UserRoleEntity> userRoles = userRoleRepository.findByUserId(userDTO.getId());
        for (UserRoleEntity userRole : userRoles) {
            if(userDTO.getRole().equals("ADMIN")){
                RoleEntity roleEntity = roleRepository.findById(1L).orElse(null);
                userRole.setRole(roleEntity);
                userRoleRepository.save(userRole);
            }
            else if(userDTO.getRole().equals("Quản lý")){
                RoleEntity roleEntity = roleRepository.findById(3L).orElse(null);
                userRole.setRole(roleEntity);
                userRoleRepository.save(userRole);
            }
            else {
                RoleEntity roleEntity = roleRepository.findById(2L).orElse(null);
                userRole.setRole(roleEntity);
                userRoleRepository.save(userRole);
            }
        }
    }
}
