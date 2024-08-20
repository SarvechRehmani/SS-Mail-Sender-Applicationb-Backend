package com.email.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmailResponse {
    private String message;
    private HttpStatus status;
    private boolean success = false;

}
