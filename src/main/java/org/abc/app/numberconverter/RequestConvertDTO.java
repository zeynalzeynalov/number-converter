package org.abc.app.numberconverter;

import lombok.Data;

/**
 * Data Transfer Object for conversion requests.
 */
@Data
public class RequestConvertDTO {
    private String input;
    private String type;
}
