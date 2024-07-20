package org.abc.app.numberconverter;

import lombok.RequiredArgsConstructor;
import org.abc.app.core.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.abc.app.core.RestResponse.FAIL;

@RequestMapping("/api/numberconverter")
@RestController
@RequiredArgsConstructor
public class NumberConverterController {

    private final NumberConverterService numberConverterService;

    @GetMapping("/status")
    ResponseEntity<RestResponse> checkStatus() {

        return ResponseEntity.ok(new RestResponse("API is running."));
    }

    @PostMapping("decimaltoroman")
    public ResponseEntity<RestResponse> convertDecimalToRoman(
            @RequestBody RequestDecimalToRomanDTO request) {
        try {
            String result = numberConverterService.convertDecimalToRoman(request.input);
            return ResponseEntity.ok(new RestResponse(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new RestResponse(FAIL, e.getMessage()));
        }
    }

    @PostMapping("binarytodecimal")
    public ResponseEntity<RestResponse> convertBinaryToDecimal(
            @RequestBody RequestBinaryToDecimalDTO request) {
        try {
            Integer result = numberConverterService.convertBinaryToDecimal(request.input);
            return ResponseEntity.ok(new RestResponse(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new RestResponse(FAIL, e.getMessage()));
        }
    }

}
