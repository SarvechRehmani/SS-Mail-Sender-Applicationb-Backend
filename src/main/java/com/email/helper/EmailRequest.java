package com.email.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmailRequest {

    private String[] to;
    private String[] cc;
    private String subject;
    private String htmlContent;

}
