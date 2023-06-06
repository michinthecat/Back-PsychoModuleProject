package com.unibague.backpsyco.semester.infraestructure.driveradapter;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "semesters")
@Data
public class SemesterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "semester", nullable = false)
    private String semester;

}