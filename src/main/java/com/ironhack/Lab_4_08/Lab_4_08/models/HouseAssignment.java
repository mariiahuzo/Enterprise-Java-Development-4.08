package com.ironhack.Lab_4_08.Lab_4_08.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ironhack.Lab_4_08.Lab_4_08.enums.House;
import com.ironhack.Lab_4_08.Lab_4_08.enums.Wing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HouseAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private House house;
    @Enumerated(EnumType.STRING)
    private Wing wing;
    private Integer assignedBed;
    @OneToOne(mappedBy = "houseAssignment")
    @JsonBackReference
    private Student student;


    @Override
    public String toString() {
        return "HouseAssignment{" +
                "id=" + id +
                ", house=" + house +
                ", wing=" + wing +
                ", assignedBed=" + assignedBed +
                ", student=" + student +
                '}';
    }
}
