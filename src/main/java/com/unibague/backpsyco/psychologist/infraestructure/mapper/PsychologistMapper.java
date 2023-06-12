package com.unibague.backpsyco.psychologist.infraestructure.mapper;

import com.unibague.backpsyco.psychologist.domain.model.Psychologist;
import com.unibague.backpsyco.psychologist.infraestructure.driveradapter.PsychologistData;
import com.unibague.backpsyco.role.domain.model.Role;
import com.unibague.backpsyco.role.infraestructure.driveradapter.RoleData;
import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceData;
import com.unibague.backpsyco.specialties.domain.model.Specialty;
import com.unibague.backpsyco.specialties.infraestructure.driveradapter.SpecialityData;
import java.util.List;
import java.util.stream.Collectors;

public class PsychologistMapper {

    public static Psychologist fromData(PsychologistData data) {
        Role role = new Role(data.getRole().getId(), data.getRole().getRole());
        Specialty specialty = new Specialty(data.getSpecialty().getId(), data.getSpecialty().getSpecialty());
        List<Service> services = data.getServices().stream().map(serviceData -> new Service(serviceData.getId(), serviceData.getServiceName(), serviceData.getDescription(), serviceData.getCost())).collect(Collectors.toList());

        return new Psychologist(data.getId(), data.getName(), data.getLastName(), data.getEmail(), specialty, role, services);
    }

    public static PsychologistData toData(Psychologist psychologist) {
        RoleData roleData = new RoleData();
        roleData.setId(psychologist.getRole().getId());
        roleData.setRole(psychologist.getRole().getRole());

        SpecialityData specialtyData = new SpecialityData();
        specialtyData.setId(psychologist.getSpecialty().getId());
        specialtyData.setSpecialty(psychologist.getSpecialty().getSpecialty());

        List<ServiceData> serviceDataList = psychologist.getServices().stream().map(service -> {
            ServiceData serviceData = new ServiceData();
            serviceData.setId(service.getId());
            serviceData.setServiceName(service.getServiceName());
            serviceData.setDescription(service.getDescription());
            serviceData.setCost((float) service.getCost());
            return serviceData;
        }).collect(Collectors.toList());

        PsychologistData psychologistData = new PsychologistData();
        psychologistData.setId(psychologist.getId());
        psychologistData.setName(psychologist.getName());
        psychologistData.setLastName(psychologist.getLastName());
        psychologistData.setEmail(psychologist.getEmail());
        psychologistData.setSpecialty(specialtyData);
        psychologistData.setRole(roleData);
        psychologistData.setServices(serviceDataList);

        return psychologistData;
    }
}
