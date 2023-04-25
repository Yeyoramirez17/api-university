package com.apiuniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "faculties")
public class Faculty{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idFaculty;


    @Column(length = 150, unique = true, nullable = false)
    private String nameFaculty;

    @Column(length = 50)
    private String direction;

    @Column(length = 15)
    private String phone;

    @Column(length = 25)
    private String email;


}
