package com.example.chapapp.user;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserDTO {

    private String username ;
    private String password;
    private UserStatus status ;
    private String avatarUrl ;
}
