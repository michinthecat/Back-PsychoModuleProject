package com.unibague.backpsyco.service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
    private int id;
    private String serviceName;
    private String description;
    private double cost;
}