package org.abc.app.core;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RestResponse {

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String INVALID_PARAMETERS = "invalid parameters";

    private final String status;
    private final Object data;

    public RestResponse(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public RestResponse(Object data) {
        this.status = SUCCESS;
        this.data = data;
    }

    public RestResponse() {
        this.status = SUCCESS;
        this.data = null;
    }
}