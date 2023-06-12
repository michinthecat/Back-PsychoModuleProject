package com.unibague.backpsyco.psychologist.domain.model;

import com.unibague.backpsyco.role.domain.model.Role;
import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.specialties.domain.model.Specialty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Psychologist {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private Specialty specialty;
    private Role role;
    private List<Service> services;
}