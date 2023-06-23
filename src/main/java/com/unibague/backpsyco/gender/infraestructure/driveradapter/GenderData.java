package com.unibague.backpsyco.gender.infraestructure.driveradapter;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "genders")
@Data
public class GenderData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gender", nullable = false)
    private String gender;
}