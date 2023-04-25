package com.apiuniversity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeIdentificationDTO implements Serializable {

    private Long idTypeIdentification;

    @NotNull(message = "Type Identification is required" )
    @NotEmpty(message = "Type Identification is required" )
    private String nameIdentification;

    @NotNull(message = "The description is required")
    @NotEmpty(message = "The description is required")
    private String description;

    private Boolean state;
}
