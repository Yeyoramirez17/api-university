package com.apiuniversity.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idTeacher;

    @Column(length = 150)
    private String firstName;

    @Column(length = 150)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "id_type_identification", foreignKey = @ForeignKey(name = "FK_TEACHER_TYPE_IDENTIFICATION"))
    private TypeIdentification typeIdentification;

    @Column(length = 15, unique = true)
    private String identification;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(length = 15)
    private String phone;

    @Column(length = 20, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private Double Salary;

    @Column(nullable = false)
    private LocalDate dateAdmission;
}
