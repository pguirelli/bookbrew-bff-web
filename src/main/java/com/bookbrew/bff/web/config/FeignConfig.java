package com.bookbrew.bff.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }

    @Bean
    @Primary
    Encoder feignEncoder() {
        return new SpringFormEncoder();
    }
}
