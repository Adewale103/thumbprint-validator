package com.twinkles.thumbprintvalidator.controller;

import com.twinkles.thumbprintvalidator.utils.ThumbprintUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

@RestController
public class ThumbprintController {

    @GetMapping("/thumbprint")
    public String authenticate(HttpServletRequest request) throws CertificateEncodingException {
        X509Certificate clientCert = (X509Certificate) request.getAttribute("javax.servlet.request.X509Certificate");
        if (clientCert != null) {
            String thumbprint = ThumbprintUtils.calculateThumbprint(clientCert.getPublicKey());
            if (thumbprint.equals("your_pre_defined_thumbprint")) {
                return "Client authenticated successfully.";
            }
        }
        return "Client authentication failed.";
    }
}