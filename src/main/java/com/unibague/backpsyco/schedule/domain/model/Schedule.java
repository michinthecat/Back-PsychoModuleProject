package com.unibague.backpsyco.schedule.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {
    private int id;
    private Date date;
    private Time time;
}