package com.twinkles.thumbprintvalidator.service;


import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateEncodingException;

public interface ThumbPrintService {
    void loadThumbprints();
    boolean isTrusted(int clientId, String thumbprint);
    String authenticate(String clientId, HttpServletRequest request) throws CertificateEncodingException;
}
