package com.apiuniversity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSubjectDTO implements Serializable {
    @NotNull
    private TeacherDTO teacher;

    @NotNull
    private SubjectDTO subject;

    @NotNull
    @Length(min = 1)
    private Integer hours;
}
