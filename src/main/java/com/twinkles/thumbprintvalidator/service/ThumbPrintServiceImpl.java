package com.twinkles.thumbprintvalidator.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateEncodingException;

@Service
public class ThumbPrintServiceImpl implements ThumbPrintService{
    @Override
    public String authenticate(HttpServletRequest request) throws CertificateEncodingException {
        return null;
    }
}
