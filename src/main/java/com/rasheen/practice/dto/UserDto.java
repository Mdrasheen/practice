package com.rasheen.practice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {

    private Long id;
    @JsonProperty("full_name")
    @NotBlank(message = "Name must not be empty")
    private String name;

    @JsonProperty("email_address")
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email must not be empty")
    private String email;
   @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    


    public String getPassword() {
    return password;
}
   public void setPassword(String password) {
    this.password = password;
   }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
