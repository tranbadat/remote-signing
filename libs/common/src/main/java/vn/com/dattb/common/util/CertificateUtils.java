package vn.com.dattb.common.util;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.slf4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.isNull;
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

    /**
     * Get X509Certificate from certificate string
     *
     * @param certStr certificate in base64 format
     * @return X509Certificate
     */
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


    /**
     * Get list of X509Certificate from certificate chain
     *
     * @param base64Certificate certificate chain in base64 format
     * @return list of X509Certificate
     */
    public static List<X509Certificate> getListCertificateChain(String base64Certificate) {
        try {

            if (isNull(base64Certificate) || base64Certificate.isEmpty()) {
                return Collections.emptyList();
            }

            byte[] certificateBytes = java.util.Base64.getDecoder().decode(base64Certificate);
            List<X509Certificate> certificateChain = new ArrayList<>();

            InputStream inStream = new ByteArrayInputStream(certificateBytes);
            ASN1InputStream asn1InputStream = new ASN1InputStream(inStream);
            ASN1Sequence seq = (ASN1Sequence) asn1InputStream.readObject();
            inStream.close();

            for (int i = 0; i < seq.size(); i++) {
                byte[] certBytes = ((ASN1Sequence) seq.getObjectAt(i)).getEncoded();
                CertificateFactory certFactory = CertificateFactory.getInstance("X.509", new BouncyCastleProvider());
                X509Certificate cert = (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(certBytes));
                certificateChain.add(cert);
            }

            return certificateChain;
        } catch (Exception e) {
            logger.error("Error when parse certificate chain", e);
            return Collections.emptyList();
        }
    }
}
