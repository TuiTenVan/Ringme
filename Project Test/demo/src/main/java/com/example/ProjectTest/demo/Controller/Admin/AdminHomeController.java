package com.example.ProjectTest.demo.Controller.Admin;

import com.example.ProjectTest.demo.DTO.UserDTO;
import com.example.ProjectTest.demo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminHomeController {
    private final IUserService userService;

    @GetMapping("/accounts/all")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserDTO> userDTOS = userService.getAllUsers();
            return ResponseEntity.ok(userDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/accounts/search")
    public ResponseEntity<?> getAllByName(@RequestParam String fullName) {
        try {
            List<UserDTO> userDTOS = userService.getAllByFullName(fullName);
            return ResponseEntity.ok(userDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/accounts/pending")
    public ResponseEntity<?> findAllByStatus() {
        try {
            List<UserDTO> userDTOS = userService.getAllUsersByStatus(0);
            return ResponseEntity.ok(userDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/accounts/approve/{id}")
    public ResponseEntity<?> updateAccountStatus(@PathVariable Long id) {
        try {
            userService.updateUserStatus(id, 1);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/accounts")
    public ResponseEntity<?> addAccount(@RequestPart("userDTO") UserDTO userDTO, @RequestPart("file") MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String fileName = storeFile(file);
                userDTO.setAvatar(fileName);
            }
            userService.createUser(userDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private boolean isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");
    }

    private String storeFile(MultipartFile file) throws IOException {
        if (!isImageFile(file) || file.getOriginalFilename() == null) {
            throw new IOException("Invalid image format");
        }
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
        java.nio.file.Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateAccount(@RequestBody UserDTO userDTO) {
        try {
            userService.updateUser(userDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
