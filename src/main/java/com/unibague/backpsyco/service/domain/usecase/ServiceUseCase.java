package com.unibague.backpsyco.service.domain.usecase;

import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.service.domain.model.gateway.ServiceGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ServiceUseCase {

    private final ServiceGateway serviceGateway;
    public Service save(Service service){
        if (service == null) {
            throw new IllegalArgumentException("El servicio no puede ser nulo");
        }
        return serviceGateway.save(service);
    }
    public Service update(Service service){
        if (service == null) {
            throw new IllegalArgumentException("El servicio no puede ser nulo");
        }
        return serviceGateway.update(service);
    }
    public List<Service> getAllServices(){
        return serviceGateway.getAllServices();
    }
    public Boolean delete(int serviceId){
        return serviceGateway.delete(serviceId);
    }
}
