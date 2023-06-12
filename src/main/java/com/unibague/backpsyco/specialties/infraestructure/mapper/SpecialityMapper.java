package com.unibague.backpsyco.specialties.infraestructure.mapper;

import com.unibague.backpsyco.specialties.domain.model.Specialty;
import com.unibague.backpsyco.specialties.infraestructure.driveradapter.SpecialityData;

public class SpecialityMapper {

    public static Specialty fromData(SpecialityData data) {
        return new Specialty(data.getId(), data.getSpecialty());
    }

    public static SpecialityData toData(Specialty specialty) {
        SpecialityData data = new SpecialityData();
        data.setId(specialty.getId());
        data.setSpecialty(specialty.getSpecialty());
        return data;
    }


}
