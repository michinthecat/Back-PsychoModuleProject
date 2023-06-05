package com.unibague.backpsyco.patienttype.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientType {
    private int id;
    private String patientType;
}
