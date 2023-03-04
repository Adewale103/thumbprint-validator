package com.twinkles.thumbprintvalidator.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    public class TrustedClient {

        @Id()
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long clientId;

        private String thumbprint;


}
