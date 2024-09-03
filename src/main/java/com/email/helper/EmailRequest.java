package com.email.helper;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmailRequest {

    private String[] to;
    private String[] cc;
    private String subject;
    private String htmlContent;

}
