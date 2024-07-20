package org.abc.app.numberconverter;

import lombok.RequiredArgsConstructor;
import org.abc.app.core.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.abc.app.core.RestResponse.FAIL;

@RequestMapping("/api/numberconverter")
@RestController
@RequiredArgsConstructor
public class NumberConverterController {

    private final NumberConverterService numberConverterService;

    @PostMapping("decimaltoroman")
    public ResponseEntity<RestResponse> convertDecimalToRoman(
            @RequestBody RequestDecimalToRomanDTO request) {
        try {

            // TODO: call numberConverterService.convert

            return ResponseEntity.ok(new RestResponse());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new RestResponse(FAIL, e.getMessage()));
        }
    }

}
