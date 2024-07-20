package org.abc.app.api;

import lombok.RequiredArgsConstructor;
import org.abc.app.utils.RequestConvert;
import org.abc.app.utils.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.abc.app.utils.RestResponse.FAIL;

/**
 * REST controller for handling number conversion requests.
 */
@RequestMapping("/api/number-converter")
@RestController
@RequiredArgsConstructor
public class NumberConverterController {

    // The service that handles the number conversion logic
    private final NumberConverterService numberConverterService;

    /**
     * Endpoint to check the status of the API.
     *
     * @return ResponseEntity containing a status message
     */
    @GetMapping("/status")
    public ResponseEntity<RestResponse> checkStatus() {
        return ResponseEntity.ok(new RestResponse("API is running."));
    }

    /**
     * Endpoint to convert numbers based on the provided request.
     *
     * @param request the request containing the conversion parameters
     * @return ResponseEntity containing the conversion result or an error message
     */
    @PostMapping("/convert")
    public ResponseEntity<RestResponse> convert(@RequestBody RequestConvert request) {
        try {
            String result = numberConverterService.convert(request);
            return ResponseEntity.ok(new RestResponse(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new RestResponse(FAIL, e.getMessage()));
        }
    }
}
