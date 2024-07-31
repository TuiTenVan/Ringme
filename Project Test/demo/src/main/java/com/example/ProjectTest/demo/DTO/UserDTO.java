package com.example.ProjectTest.demo.DTO;


import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends AbstractDTO{
    private Long id;
    private String name;
    private String fullName;
    private String email;
    private String password;
    private String gender;
    private Date birthday;
    private String address;
    private String phone;
    private String avatar;
    private Integer status;
    private String retypePassword;
    private String newPassword;
    private String role;
}
