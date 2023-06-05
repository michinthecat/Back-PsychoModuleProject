package com.unibague.backpsyco.psychologist.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Psychologist {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int specialtyId;
    private int roleId;
}