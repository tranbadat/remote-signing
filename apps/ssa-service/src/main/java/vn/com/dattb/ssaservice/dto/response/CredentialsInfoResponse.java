package vn.com.dattb.ssaservice.dto.response;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * OutputCredentialsInfo
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 12/18/2024
 * Version: 1.0.0
 * <p>
 * Description: DTO for output credentials info
 */
public class CredentialsInfoResponse {

    private String credentialID;

    private String description;

    private String signatureQualifier;

    private Key key;

    private Cert cert;

    private Auth auth;

    private String SCAL;

    private Integer multisign;

    private String lang;

    @Getter
    @Setter
    public class Key {

        private String status;

        @Valid
        private List<String> algo = new ArrayList<>();

        private Integer len;

        private Integer curve;
    }

    @Getter
    @Setter
    public class Cert {

        private String status;

        @Valid
        private List<String> certificates;

        private String issuerDN;

        private String serialNumber;

        private String subjectDN;

        private String validFrom;

        private String validTo;

        public Cert status(String status) {
            this.status = status;
            return this;
        }
    }

    public class Auth {

        private String mode;

        private String expression;

        @Valid
        private List<@Valid AuthObjectType> objects;

        public Auth mode(String mode) {
            this.mode = mode;
            return this;
        }

        @Getter
        @Setter
        public class AuthObjectType {

            private String type;

            private String id;

            private String label;

            private String description;

            private String format;

            private String generator;
        }
    }

}
