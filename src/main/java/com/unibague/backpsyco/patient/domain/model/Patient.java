package com.unibague.backpsyco.patient.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int age;
    private String phone;
    private int patientTypeId;
    private int genderId;
}