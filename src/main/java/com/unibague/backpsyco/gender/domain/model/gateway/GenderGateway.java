package com.unibague.backpsyco.gender.domain.model.gateway;

import com.unibague.backpsyco.gender.domain.model.Gender;

import java.util.List;

public interface GenderGateway {
    List<Gender> getAllGenders();
}
