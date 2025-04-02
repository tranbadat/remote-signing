package vn.com.dattb.coreservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.dattb.coreservice.common.FieldType;

/**
 * SignatureConfigRequest
 * <p>
 * Author: Tran Ba Dat - <a href="https://econtract.dattb.com">Live demo</a>
 * Created: 1/17/2025
 * Version: 1.0.0
 * <p>
 * Description: SignatureConfigRequest is the request class for updating the signature configuration
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignatureConfigRequest {
    private FieldType type;
    private String signatureImage;
    private String filedName;
    private String fieldValue;
    private String color;
    private Integer page;
    private float x;
    private float y;
    private float width;
    private float height;
    private String rotation;
    private String opacity;
    private String font;
    private String fontSize;
    private String fontColor;
    private String fontStyle;
    private boolean allowOverwrite;

}
