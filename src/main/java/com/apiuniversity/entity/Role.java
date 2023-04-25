package com.apiuniversity.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idRole;

    @Column(length = 50, nullable = false)
    private String roleName;

    @Column(length = 250)
    private String description;

    @Column(name = "state")
    private Boolean isActive;


}
