package com.unibague.backpsyco.gender.infraestructure.mapper;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.gender.infraestructure.driveradapter.GenderData;

public class GenderMapper {

    public static GenderData toData(Gender gender) {
        GenderData genderData = new GenderData();
        genderData.setId(gender.getId());
        genderData.setGender(gender.getGender());
        return genderData;
    }

    public static Gender toDomain(GenderData genderData) {
        Gender gender = new Gender();
        gender.setId(genderData.getId());
        gender.setGender(genderData.getGender());
        return gender;
    }

}