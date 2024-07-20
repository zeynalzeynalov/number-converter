package org.abc.app.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object for conversion requests.
 */
@Data
@AllArgsConstructor
public class RequestConvert {
    private String input;
    private String type;
}
