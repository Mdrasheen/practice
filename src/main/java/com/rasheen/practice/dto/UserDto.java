package com.rasheen.practice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {

    private Long id;
    @NotBlank(message = "Name must not be empty")
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be empty")
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
