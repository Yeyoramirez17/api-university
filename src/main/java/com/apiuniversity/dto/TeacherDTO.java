package com.apiuniversity.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO implements Serializable {

    @NotNull
    @NotEmpty
    private Long idTeacher;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 150)
    private String lastName;

    @NotNull
    private TypeIdentificationDTO typeIdentification;

    @NotNull
    @NotEmpty
    private String identification;

    @NotNull
    @NotEmpty
    private LocalDate birthdate;

    @NotNull
    @NotEmpty
    private String phone;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private Double Salary;

    @NotNull
    @NotEmpty
    private LocalDate dateAdmission;
}
