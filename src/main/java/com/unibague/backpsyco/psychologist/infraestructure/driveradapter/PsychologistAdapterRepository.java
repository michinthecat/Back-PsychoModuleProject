package com.unibague.backpsyco.psychologist.infraestructure.driveradapter;

import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.psychologist.domain.model.gateway.PsychologistGateway;
import com.unibague.backpsyco.psychologist.infraestructure.mapper.PsychologistMapper;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceData;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PsychologistAdapterRepository implements PsychologistGateway {

    private final PsychologistRepository psychologistRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public List<Psychologist> getAll() {
        return psychologistRepository.findAll().stream()
                .map(PsychologistMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public Psychologist getById(int id) {
        return psychologistRepository.findById(id)
                .map(PsychologistMapper::fromData)
                .orElse(null);
    }

    @Override
    public Psychologist createPsychologist(Psychologist psychologist) {

        int psychologistId = psychologist.getId();
        if (psychologistRepository.existsById(psychologistId)) {
            throw new IllegalArgumentException("El psicólogo ya existe");
        }
        PsychologistData psychologistData = PsychologistMapper.toData(psychologist);
        PsychologistData savedPsychologistData = psychologistRepository.save(psychologistData);
        return PsychologistMapper.fromData(savedPsychologistData);
    }

    @Override
    public Psychologist updatePsychologist(Psychologist psychologist) {
        PsychologistData psychologistData = PsychologistMapper.toData(psychologist);
        PsychologistData savedPsychologistData = psychologistRepository.save(psychologistData);
        return PsychologistMapper.fromData(savedPsychologistData);
    }

    @Override
    public Boolean delete(int id) {
        try {
            psychologistRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean insertServiceToPsychologist(int psychologistId, int serviceId) {
        try {
            Optional<PsychologistData> psychologistDataOptional = psychologistRepository.findById(psychologistId);
            Optional<ServiceData> serviceDataOptional = serviceRepository.findById(serviceId);

            if (psychologistDataOptional.isPresent() && serviceDataOptional.isPresent()) {
                PsychologistData psychologistData = psychologistDataOptional.get();
                ServiceData serviceData = serviceDataOptional.get();

                psychologistData.getServices().add(serviceData);
                psychologistRepository.save(psychologistData);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }



}
