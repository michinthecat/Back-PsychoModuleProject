package com.unibague.backpsyco.psychologist.infraestructure.driveradapter;
import com.unibague.backpsyco.role.infraestructure.driveradapter.RoleData;
import com.unibague.backpsyco.service.infraestructure.driveradapter.ServiceData;
import com.unibague.backpsyco.specialties.infraestructure.driveradapter.SpecialityData;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "psychologists")
@Data
public class  PsychologistData {

    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialtyid", nullable = false)
    private SpecialityData specialty;

    @ManyToOne
    @JoinColumn(name = "roleid", nullable = false)
    private RoleData role;

    @ManyToMany
    @JoinTable(
            name = "services_psychologists",
            joinColumns = @JoinColumn(name = "psychologistid"),
            inverseJoinColumns = @JoinColumn(name = "serviceid"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"psychologistid", "serviceid"})
    )
    private List<ServiceData> services;
}