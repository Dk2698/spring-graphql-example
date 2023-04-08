package com.example.model;

import com.example.validate.ImageNameValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {
    private String userId;
    @Size(message = "invalid Name !!", min = 3, max = 20)
    private String name;
//    @Email(message = "in valid user email")
    @Pattern(regexp = "^[a-z0-9][-a-z0-9]", message = "invaild message")
    @NotBlank(message = "Email is required !!")
    private  String email;
    @NotBlank(message = "Password is required !!")

    private  String password;
    @NotBlank(message = "not empty")
    private String about;

    // @pattern
    // customer validator
    @ImageNameValid
    private  String ImageName;
}
