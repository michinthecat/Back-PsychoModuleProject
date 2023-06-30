package com.unibague.backpsyco.email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailAppointment {

    private String name;
    private String psychologist;
    private String date;
    private String time;
    private String appointmentId;
    private String email;
}
