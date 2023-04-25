package com.apiuniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "subjects")
public class Subject{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idSubject;

    @Column(length = 200, unique = true, nullable = false)
    private String nameSubject;

    @Column
    private Integer credits;

    @Column
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_faculty", nullable = false, foreignKey = @ForeignKey(name = "FK_SUBJECT_FACULTY"))
    private Faculty faculty;
}
