package org.abc.app.utils;

import lombok.Data;

/**
 * Data Transfer Object for conversion requests.
 */
@Data
public class RequestConvert {
    private String input;
    private String type;
}
