package com.unibague.backpsyco.service.infraestructure.mapper;

import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceData;

public class ServiceMapper {
    public static Service fromData(ServiceData data) {
        return new Service(
                data.getId(),
                data.getServiceName(),
                data.getDescription(),
                data.getCost()
        );
    }

    public static ServiceData toData(Service service) {
        ServiceData data = new ServiceData();
        data.setId(service.getId());
        data.setServiceName(service.getServiceName());
        data.setDescription(service.getDescription());
        data.setCost((float) service.getCost());
        return data;
    }
}
