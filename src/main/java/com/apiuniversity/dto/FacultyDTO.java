package com.apiuniversity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO implements Serializable {


    private Long idFaculty;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 150)
    private String nameFaculty;

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 250)
    private String direction;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 15)
    private String phone;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 25)
    private String email;

}
