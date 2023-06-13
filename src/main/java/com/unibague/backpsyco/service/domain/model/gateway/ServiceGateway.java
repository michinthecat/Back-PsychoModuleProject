package com.unibague.backpsyco.service.domain.model.gateway;

import com.unibague.backpsyco.service.domain.model.Service;

import java.util.List;

public interface ServiceGateway {

    Service save(Service service);
    Service update(Service service);
    List<Service> getAllServices();
    Boolean delete(int serviceId);
}
