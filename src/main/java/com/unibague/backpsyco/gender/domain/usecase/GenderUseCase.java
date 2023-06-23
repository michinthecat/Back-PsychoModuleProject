package com.unibague.backpsyco.gender.domain.usecase;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.gender.domain.model.gateway.GenderGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GenderUseCase {

    private final GenderGateway genderGateway;
    public List<Gender> getAllGenders() {
        return genderGateway.getAllGenders();
    }
}
