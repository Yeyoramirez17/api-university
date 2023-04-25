package com.apiuniversity.dto;

import com.apiuniversity.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO implements Serializable {

    private Long idUser;

    @NotNull( message = "The LastName field is required")
    @NotEmpty( message = "The LastName field is required")
    @Size(min = 3)
    private String lastName;

    @NotNull(message = "The FistName field is required")
    @NotEmpty(message = "The FistName field is required")
    @Size(min = 3)
    private String firstName;

    @NotNull
    @NotEmpty
    private TypeIdentificationDTO typeIdentification;

    @NotNull(message = "The Identification field is required")
    @NotEmpty(message = "The Identification field is required")
    @Size(min = 5)
    private String identification;

    @NotNull
    @NotEmpty
    @Size(min = 3)
    private String phone;

    @NotNull( message = "The Email field is required")
    @NotEmpty( message = "The Email field is required")
    @Email(message = "The email must be in the proper format")
    private String email;

    @NotNull( message = "The Username field is required")
    @NotEmpty( message = "The Username field is required")
    private String username;

    @NotNull( message = "The Password field is required")
    @NotEmpty( message = "The Password field is required")
    @Size(min = 8, message = "The password field must have a minimum of 8 characters")
    private String password;

    private List<RoleDTO> roles;
}
