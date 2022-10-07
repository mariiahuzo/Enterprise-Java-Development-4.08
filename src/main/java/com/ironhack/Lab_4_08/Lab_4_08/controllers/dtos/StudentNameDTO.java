package com.ironhack.Lab_4_08.Lab_4_08.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentNameDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;

}
