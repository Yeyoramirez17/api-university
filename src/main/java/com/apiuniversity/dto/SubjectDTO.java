package com.apiuniversity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {

    private Long idSubject;

    @NotNull
    @NotEmpty
    @Size(min = 200)
    private String nameSubject;

    @NotNull
    @NotEmpty
    private Integer credits;

    private Boolean state;

    @NotNull
    @NotEmpty
    private FacultyDTO faculty;
}
