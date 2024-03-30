package io.github.singhalmradul.postservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class OpenFeignConfiguration {

    @Bean
    JacksonDecoder decoder(ObjectMapper objectMapper) {
        return new JacksonDecoder(objectMapper);
    }

    @Bean
    JacksonEncoder encoder(ObjectMapper objectMapper) {
        return new JacksonEncoder(objectMapper);
    }
}
