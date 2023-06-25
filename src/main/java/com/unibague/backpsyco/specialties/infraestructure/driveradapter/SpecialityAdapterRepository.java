package com.unibague.backpsyco.specialties.infraestructure.driveradapter;

import com.unibague.backpsyco.specialties.domain.model.Specialty;
import com.unibague.backpsyco.specialties.domain.model.gateway.SpecialityGateway;
import com.unibague.backpsyco.specialties.infraestructure.mapper.SpecialityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class SpecialityAdapterRepository implements SpecialityGateway {

    private final SpecialityRepository specialityRepository;

    @Override
    public Specialty saveSpecialty(Specialty specialty) {
        SpecialityData specialityData = SpecialityMapper.toData(specialty);
        SpecialityData savedSpecialityData = specialityRepository.save(specialityData);
        return SpecialityMapper.fromData(savedSpecialityData);
    }

    @Override
    public List<Specialty> getAllSpecialties() {
        List<SpecialityData> specialityDataList = specialityRepository.findAll();
        return specialityDataList.stream()
                .map(SpecialityMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteSpecialty(int specialtyId) {
        if (specialityRepository.existsById(specialtyId)) {
            specialityRepository.deleteById(specialtyId);
            return true;
        }
        throw new IllegalArgumentException("Especialidad no encontrada");

    }

    @Override
    public boolean updateSpecialty(Specialty specialty) {
        if (specialityRepository.existsById(specialty.getId())) {
            SpecialityData specialityData = SpecialityMapper.toData(specialty);
            specialityRepository.save(specialityData);
            return true;
        }
        return false;
    }
}
