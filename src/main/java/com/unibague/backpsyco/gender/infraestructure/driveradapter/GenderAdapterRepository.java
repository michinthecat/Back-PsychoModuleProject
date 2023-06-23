package com.unibague.backpsyco.gender.infraestructure.driveradapter;

import com.unibague.backpsyco.gender.domain.model.Gender;
import com.unibague.backpsyco.gender.domain.model.gateway.GenderGateway;
import com.unibague.backpsyco.gender.infraestructure.mapper.GenderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class GenderAdapterRepository implements GenderGateway {

    private final GenderRepository genderRepository;

    @Override
    public List<Gender> getAllGenders() {
        try {
            List<GenderData> genderDataList = genderRepository.findAll();
            return genderDataList.stream()
                    .map(GenderMapper::toDomain)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio Un Error Al Obtener Los Generos");
        }
    }
}
