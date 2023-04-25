package com.apiuniversity.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO implements Serializable {
    private Long idUser;
    private String lastName;
    private String firstName;
    private String typeIdentification;
    private String identification;
    private String phone;
    private String email;
}
