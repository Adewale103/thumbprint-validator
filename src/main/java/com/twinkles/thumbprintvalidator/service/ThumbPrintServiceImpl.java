package com.twinkles.thumbprintvalidator.service;

import com.twinkles.thumbprintvalidator.model.TrustedClient;
import com.twinkles.thumbprintvalidator.repository.TrustedClientRepository;
import com.twinkles.thumbprintvalidator.utils.ThumbprintUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ThumbPrintServiceImpl implements ThumbPrintService {

    private final TrustedClientRepository trustedClientRepository;

    private Map<Integer, String> thumbprints;

    @PostConstruct
    @Transactional
    public void loadThumbprints() {
        thumbprints = new HashMap<>();
        List<TrustedClient> clients = trustedClientRepository.findAll();
        for (TrustedClient client : clients) {
            thumbprints.put((int) client.getClientId(), client.getThumbprint());
        }
    }

    public boolean isTrusted(int clientId, String thumbprint) {
        String storedThumbprint = thumbprints.get(clientId);
        return storedThumbprint != null && storedThumbprint.equalsIgnoreCase(thumbprint);
    }

    public String authenticate(String clientId, HttpServletRequest request) throws CertificateEncodingException {
        X509Certificate clientCert = (X509Certificate) request.getAttribute("javax.servlet.request.X509Certificate");
        if (clientCert != null) {
            String thumbprint = ThumbprintUtils.calculateThumbprint(clientCert.getPublicKey());
            if (isTrusted(Integer.parseInt(clientId), thumbprint)) {
                return "Client authenticated successfully.";
            }
        }
        return "Client authentication failed.";
    }
}

