package com.unibague.backpsyco.email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

    private Long appointmentId;
    private String name;
    private String email;
    private String confirmationLink;


}
