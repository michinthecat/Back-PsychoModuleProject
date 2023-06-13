package com.unibague.backpsyco.service.infraestructure.driveradapter;

import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.service.domain.model.gateway.ServiceGateway;
import com.unibague.backpsyco.service.infraestructure.mapper.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ServiceAdapterRepository implements ServiceGateway {

    private final ServiceRepository serviceRepository;

    @Override
    public Service save(Service service) {
        ServiceData serviceData = ServiceMapper.toData(service);
        ServiceData savedServiceData = serviceRepository.save(serviceData);
        return ServiceMapper.fromData(savedServiceData);
    }

    @Override
    public Service update(Service service) {
        ServiceData serviceData = ServiceMapper.toData(service);
        ServiceData updatedServiceData = serviceRepository.save(serviceData);
        return ServiceMapper.fromData(updatedServiceData);
    }

    @Override
    public List<Service> getAllServices() {
        List<ServiceData> serviceDataList = serviceRepository.findAll();
        return serviceDataList.stream()
                .map(ServiceMapper::fromData)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(int serviceId) {
        if (serviceRepository.existsById(serviceId)) {
            serviceRepository.deleteById(serviceId);
            return true;
        }
        return false;
    }
}
