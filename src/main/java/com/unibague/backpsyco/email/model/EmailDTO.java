package com.unibague.backpsyco.email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String body;


}
