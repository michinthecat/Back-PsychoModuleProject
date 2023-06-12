package com.unibague.backpsyco.psychologist.infraestructure.driveradapter;

import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.psychologist.domain.model.gateway.PsychologistGateway;
import com.unibague.backpsyco.psychologist.infraestructure.mapper.PsychologistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PsychologistAdapterRepository implements PsychologistGateway {

    private final PsychologistRepository psychologistRepository;

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
    public Psychologist save(Psychologist psychologist) {
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
}
