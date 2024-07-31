package com.example.ProjectTest.demo.Convert;

import com.example.ProjectTest.demo.DTO.UserDTO;
import com.example.ProjectTest.demo.Entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConvert {
    private final ModelMapper modelMapper;

    public UserEntity toUserEntity(UserDTO userDTO){
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userEntity.setStatus(0);
        return userEntity;
    }

    public UserDTO toUserDTO(UserEntity userEntity) {
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        String role = userEntity.getUserRoleEntityList().get(0).getRole().getDescription();
        userDTO.setRole(role);
        return userDTO;
    }
}
