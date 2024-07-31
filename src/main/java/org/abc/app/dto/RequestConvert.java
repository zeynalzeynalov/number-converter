package org.abc.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Data Transfer Object for conversion requests.
 */
@Data
@Builder(toBuilder = true)
public class RequestConvert {

    private String input;
    private String type;
}
