package com.unibague.backpsyco.specialties.domain.usecase;

import com.unibague.backpsyco.specialties.domain.model.Specialty;
import com.unibague.backpsyco.specialties.domain.model.gateway.SpecialityGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SpecialityUseCase {

    private final SpecialityGateway specialityGateway;

    public Specialty saveSpecialty(Specialty specialty){
        return specialityGateway.saveSpecialty(specialty);
    }
    public List<Specialty> getAllSpecialties(){
        return specialityGateway.getAllSpecialties();
    }
    public boolean deleteSpecialty(int specialtyId){
        return specialityGateway.deleteSpecialty(specialtyId);
    }


}
