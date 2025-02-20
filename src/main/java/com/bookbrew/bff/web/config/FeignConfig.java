package com.bookbrew.bff.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }

}
