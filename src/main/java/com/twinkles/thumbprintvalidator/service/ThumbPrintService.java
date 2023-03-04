package com.twinkles.thumbprintvalidator.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateEncodingException;

@Service
public interface ThumbPrintService { String authenticate(HttpServletRequest request) throws CertificateEncodingException;
}
