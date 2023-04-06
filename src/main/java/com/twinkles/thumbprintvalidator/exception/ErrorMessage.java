package com.twinkles.thumbprintvalidator.exception;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private String message;
    private LocalDateTime timeStamp;
    private String responseCode;
}
