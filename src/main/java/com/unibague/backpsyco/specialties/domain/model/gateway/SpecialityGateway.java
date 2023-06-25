package com.unibague.backpsyco.specialties.domain.model.gateway;

import com.unibague.backpsyco.specialties.domain.model.Specialty;

import java.util.List;

public interface SpecialityGateway {

    Specialty saveSpecialty(Specialty specialty);
    List<Specialty> getAllSpecialties();
    boolean deleteSpecialty(int specialtyId);
    boolean updateSpecialty(Specialty specialty);
}
