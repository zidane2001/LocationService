package com.Logistic.LocationService.core.feign;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class FeignConfiguration {

    @Bean
    @SuppressWarnings("deprecation")
    public Request.Options options() {
        return new Request.Options(
                5000, // connectTimeout
                10000, // readTimeout
                true // followRedirects
        );
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(
                100, // period
                1000, // maxPeriod
                3 // maxAttempts
        );
    }
}