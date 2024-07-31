package com.example.ProjectTest.demo.Service.Impl;

import com.example.ProjectTest.demo.Entity.RoleEntity;
import com.example.ProjectTest.demo.Entity.UserEntity;
import com.example.ProjectTest.demo.Repository.RoleRepository;
import com.example.ProjectTest.demo.Service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    @Override
    public Map<String, Object> getStringObjectMap(UserEntity existingUser, String token) {
        Collection<? extends GrantedAuthority> roles = existingUser.getAuthorities();
        Map<String, Object> response = new HashMap<>();
        String role = "";
        for(GrantedAuthority grantedAuthority : roles){
            if(grantedAuthority.getAuthority().equals("ROLE_ADMIN") || grantedAuthority.getAuthority().equals("ROLE_MANAGER")){
                role = grantedAuthority.getAuthority();
                break;
            }
        }
        response.put("token", token);
        response.put("role", role);
        return response;
    }

    @Override
    public RoleEntity findById(Long id) {
        return roleRepository.findById(id).get();
    }
}
