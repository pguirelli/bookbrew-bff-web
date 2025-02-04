package com.bookbrew.bff.web.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String responseBody = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8);
            return new ResponseStatusException(
                    HttpStatus.valueOf(response.status()),
                    responseBody);
        } catch (IOException e) {
            return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error processing response");
        }
    }
}
