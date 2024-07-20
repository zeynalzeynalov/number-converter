package org.abc.app.utils;

import lombok.Builder;
import lombok.Data;

/**
 * A class representing the standard structure of a REST response.
 * It contains the status of the response and any associated data.
 */
@Builder
@Data
public class RestResponse {

    // Constants representing common response statuses
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String INVALID_PARAMETERS = "invalid parameters";

    // Response status
    private final String status;
    // Response data
    private final Object data;

    /**
     * Constructor for creating a RestResponse with a specified status and data.
     *
     * @param status the status of the response
     * @param data   the data associated with the response
     */
    public RestResponse(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    /**
     * Constructor for creating a RestResponse with a default success status and specified data.
     *
     * @param data the data associated with the response
     */
    public RestResponse(Object data) {
        this.status = SUCCESS;
        this.data = data;
    }

    /**
     * Default constructor for creating a RestResponse with a default success status and no data.
     */
    public RestResponse() {
        this.status = SUCCESS;
        this.data = null;
    }
}
