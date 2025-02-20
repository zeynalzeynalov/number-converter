package org.abc.app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NumberConverterControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void checkStatus_shouldReturnApiRunning() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/number-converter/status"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"status\":\"success\",\"data\":\"API is running.\"}"));
    }

    @Test
    void getTypes_shouldReturnServiceTypes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/number-converter/types"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"status\":\"success\",\"data\":[\"DECIMAL_TO_ROMAN\",\"BINARY_TO_DECIMAL\",\"BINARY_TO_ROMAN\"]}"));
    }

    @Test
    void getLogs_shouldReturnLogs() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/number-converter/logs"))
                .andExpect(status().isOk());
    }

    @Test
    void convert_shouldReturnConversionResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/number-converter/convert")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\":\"DECIMAL_TO_ROMAN\",\"input\":\"123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"status\":\"success\",\"data\":\"CXXIII\"}"));
    }
}