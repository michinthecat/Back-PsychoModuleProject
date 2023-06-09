package com.unibague.backpsyco.programpatient.infraestructure.driveradapter;

import com.unibague.backpsyco.programpatient.domain.model.ProgramPatient;
import com.unibague.backpsyco.programpatient.domain.model.gateway.ProgramPatientGateway;
import com.unibague.backpsyco.programpatient.infraestructure.mapper.ProgramPatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ProgramPatientAdapterRepository implements ProgramPatientGateway {

    private final ProgramPatientRepository programPatientRepository;


    @Override
    public List<ProgramPatient> findByPatientId(int patientId) {
        List<ProgramPatientData> data = programPatientRepository.findByPatient_Id(patientId);
        return data.stream().map(this::toDomain).collect(Collectors.toList());
    }

    private ProgramPatient toDomain(ProgramPatientData data) {
        return ProgramPatientMapper.fromData(data);
    }


}
