package com.bookbrew.bff.web.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest.class)
    public ResponseEntity<Object> handleFeignBadRequest(FeignException.BadRequest ex) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(ex.contentUTF8());

            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", node.get("timestamp").asText());
            response.put("message", node.get("message").asText());
            response.put("details", node.get("details").asText());
            response.put("path", node.get("path").asText());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.contentUTF8()));
        }
    }

    @ExceptionHandler(FeignException.InternalServerError.class)
    public ResponseEntity<Object> handleFeignInternalError(FeignException.InternalServerError ex) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(ex.contentUTF8());

            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", node.get("timestamp").asText());
            response.put("message", node.get("message").asText());
            response.put("details", node.get("details").asText());
            response.put("path", node.get("path").asText());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", ex.contentUTF8()));
        }
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Object> handleFeignNotFound(FeignException.NotFound ex) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(ex.contentUTF8());

            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", node.get("timestamp").asText());
            response.put("message", node.get("message").asText());
            response.put("details", node.get("details").asText());
            response.put("path", node.get("path").asText());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", ex.contentUTF8()));
        }
    }
}
