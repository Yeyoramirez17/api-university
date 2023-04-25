package com.apiuniversity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "types_identification")
public class TypeIdentification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idTypeIdentification;

    @Column(length = 150, unique = true, nullable = false)
    private String nameIdentification;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean state;

}
