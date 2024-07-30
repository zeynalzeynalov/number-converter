package org.abc.app.api;

import lombok.RequiredArgsConstructor;
import org.abc.app.logger.Log;
import org.abc.app.logger.LogRepository;
import org.abc.app.utils.RequestConvert;
import org.abc.app.utils.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.abc.app.utils.RestResponse.FAIL;

/**
 * REST controller for handling number conversion requests.
 */
@RequestMapping("/api/number-converter")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequiredArgsConstructor
public class NumberConverterController {

    private static final Logger logger = LoggerFactory.getLogger(NumberConverterController.class);

    // The service that handles the number conversion logic
    private final NumberConverterService numberConverterService;

    private final LogRepository logRepository;

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
     * Endpoint to get list of converter types.
     *
     * @return ResponseEntity containing list of converter types
     */
    @GetMapping("/types")
    public ResponseEntity<RestResponse> getTypes() {
        return ResponseEntity.ok(new RestResponse(numberConverterService.getTypes()));
    }

    /**
     * Endpoint to get list of logs.
     *
     * @return ResponseEntity containing list of logs
     */
    @GetMapping("/logs")
    public ResponseEntity<RestResponse> getLogs() {
        return ResponseEntity.ok(new RestResponse(logRepository.findAll()));
    }

    /**
     * Endpoint to convert numbers based on the provided request.
     *
     * @param request the request containing the conversion parameters
     * @return ResponseEntity containing the conversion result or an error message
     */
    @PostMapping("/convert")
    public ResponseEntity<RestResponse> convert(@RequestBody RequestConvert request) {
        logger.info("Call to convert endpoint with: {}", request);

        Log log = Log.builder().converterType(request.getType()).input(request.getInput())
                .description(String.format("Conversion of input: %s with converter type: %s",
                        request.getInput(), request.getType())).build();

        try {
            String result = numberConverterService.convert(request);
            logRepository.save(log.toBuilder().isSuccessful(true).result(result)
                    .description(log.getDescription() + " result: " + result).build());

            return ResponseEntity.ok(new RestResponse(result));
        } catch (Exception e) {
            logRepository.save(log.toBuilder().isSuccessful(false).result("none")
                    .description(log.getDescription() + " result: " + e.getMessage()).build());

            return ResponseEntity.badRequest().body(new RestResponse(FAIL, e.getMessage()));
        }
    }
}
