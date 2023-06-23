package com.unibague.backpsyco.patienttype.infraestructure.driveradapter;

import com.unibague.backpsyco.gender.infraestructure.driveradapter.GenderRepository;
import com.unibague.backpsyco.patient.domain.model.Patient;
import com.unibague.backpsyco.patienttype.domain.model.PatientType;
import com.unibague.backpsyco.patienttype.domain.model.gateway.PatientTypeGateway;
import com.unibague.backpsyco.patienttype.infraestructure.mapper.PatientTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class PatientTypeAdapterRepository implements PatientTypeGateway {

    private final PatientTypeRepository patientTypeRepository;
    @Override
    public List<PatientType> getAllPatientsType() {
        List<PatientTypeData> patientTypeDataList = patientTypeRepository.findAll();
        return patientTypeDataList.stream()
                .map(PatientTypeMapper::toDomain)
                .collect(Collectors.toList());
    }
}
