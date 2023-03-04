package com.twinkles.thumbprintvalidator;
import com.twinkles.thumbprintvalidator.utils.ThumbprintUtils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class ThumbprintTrustManager implements X509TrustManager {

    private final String expectedThumbprint;

    public ThumbprintTrustManager(String expectedThumbprint) {
        this.expectedThumbprint = expectedThumbprint;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        if (chain == null || chain.length == 0) {
            throw new CertificateException("No certificate presented");
        }
        X509Certificate clientCert = chain[0];
        String thumbprint = ThumbprintUtils.calculateThumbprint(clientCert.getPublicKey());
        if (!expectedThumbprint.equals(thumbprint)) {
            throw new CertificateException("Invalid certificate thumbprint");
        }
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        // No server authentication for this project
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

