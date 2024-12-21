package vn.com.dattb.common.util;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import static java.util.Objects.nonNull;

/**
 * CertificateUtils
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/21/2024
 * Version: 1.0.0
 * <p>
 * Description: Utility class for handling certificate
 */
public class CertificateUtils {
    private CertificateUtils() {
        throw new IllegalStateException("Utility class");
    }

    static Logger logger = org.slf4j.LoggerFactory.getLogger(CertificateUtils.class);

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
