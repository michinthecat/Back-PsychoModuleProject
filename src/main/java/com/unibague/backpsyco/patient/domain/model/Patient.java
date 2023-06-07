package com.unibague.backpsyco.patient.domain.model;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.sql.Clob;

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
    private PatientType patientType;
    private Gender gender;
    private String notes;
}