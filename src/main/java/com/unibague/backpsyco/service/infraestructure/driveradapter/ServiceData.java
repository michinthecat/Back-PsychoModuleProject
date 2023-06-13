package com.unibague.backpsyco.service.infraestructure.driveradapter;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "services")
@Data
public class ServiceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "description")
    private String description;

    @Column(name = "cost", nullable = false)
    private float cost;

}