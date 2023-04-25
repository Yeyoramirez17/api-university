package com.apiuniversity.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private Long idRole;
    private String roleName;
    private String description;
    private Boolean isActive;
}
