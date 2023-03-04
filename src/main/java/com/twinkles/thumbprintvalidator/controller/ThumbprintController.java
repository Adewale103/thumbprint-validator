package com.twinkles.thumbprintvalidator.controller;

import com.twinkles.thumbprintvalidator.service.ThumbPrintService;
import com.twinkles.thumbprintvalidator.utils.ThumbprintUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateEncodingException;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ThumbprintController {
    private ThumbPrintService thumbPrintService;

    @GetMapping("/thumbprint/{clientId}")
    public String authenticate(@PathVariable String clientId, HttpServletRequest request) throws CertificateEncodingException {
        return thumbPrintService.authenticate(clientId,request);
    }
}