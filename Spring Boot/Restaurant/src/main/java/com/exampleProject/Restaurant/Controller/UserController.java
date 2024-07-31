package com.exampleProject.Restaurant.Controller;

import com.exampleProject.Restaurant.DTO.UserDTO;
import com.exampleProject.Restaurant.Entity.UserEntity;
import com.exampleProject.Restaurant.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) {
        if (userService.checkLogin(user)) {
            return ResponseEntity.ok("Login successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed");
        }
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO user) {
        boolean success = userService.register(user);
        if (success) {
            return ResponseEntity.ok("User registered successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }
    }
}


