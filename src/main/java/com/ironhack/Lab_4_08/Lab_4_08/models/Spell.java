package com.ironhack.Lab_4_08.Lab_4_08.models;

import com.ironhack.Lab_4_08.Lab_4_08.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Spell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String name;
    @Enumerated(EnumType.STRING)
    private Level level;

}
