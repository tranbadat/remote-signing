package vn.com.dattb.coreservice.utils;

import com.itextpdf.commons.utils.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import static java.util.Objects.nonNull;

public class CertUtils {
    private CertUtils() {
        throw new IllegalStateException("Utility class");
    }

    static Logger logger = org.slf4j.LoggerFactory.getLogger(CertUtils.class);

    public static X509Certificate getX509Cert(String certStr) {
        CertificateFactory cf = null;

        try {
            cf = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            logger.error("Error while getting CertificateFactory instance", e);
        }

        if (StringUtils.isNotBlank(certStr) && nonNull(cf)) {
            try {
                return (X509Certificate) cf.generateCertificate(new ByteArrayInputStream(Base64.decode(certStr)));
            } catch (Exception e) {
                logger.error("Error while getting X509Certificate", e);
            }
        }

        return null;
    }
}
