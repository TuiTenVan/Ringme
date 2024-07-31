package com.example.ProjectTest.demo.Controller.Staff;

import com.example.ProjectTest.demo.DTO.UserDTO;
import com.example.ProjectTest.demo.Entity.UserEntity;
import com.example.ProjectTest.demo.Exception.DataNotFoundException;
import com.example.ProjectTest.demo.Service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffDetailController {
    private final IUserService userService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getProfile(@PathVariable Long id) throws DataNotFoundException {
        UserDTO user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/profile")
    public ResponseEntity<?> updateUserDetails(@RequestBody UserDTO updatedUserDTO,
                                               @RequestHeader("Authorization") String authorizationHeader
    ) {
        try {
            String extractedToken = authorizationHeader.substring(7);
            UserEntity user = userService.getUserDetailsFromToken(extractedToken);
            if (!Objects.equals(user.getId(), updatedUserDTO.getId())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            UserEntity updatedUser = userService.updateUser(updatedUserDTO);
            return ResponseEntity.ok("Update successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @RequestHeader("Authorization") String authorizationHeader,
            @Valid @RequestBody UserDTO userDTO
    ) {
        try {
            String extractedToken = authorizationHeader.substring(7);
            UserEntity user = userService.getUserDetailsFromToken(extractedToken);
            if (!Objects.equals(user.getId(), userDTO.getId())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
            UserEntity userEntity = userService.changePassword(userDTO);
            return ResponseEntity.ok("Change password successful");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
