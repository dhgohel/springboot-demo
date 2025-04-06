package com.example.demo.clients;

import com.example.demo.models.ApiResponseOne;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class ApiCallOneClient {

    private final RestTemplate restTemplate;

    @Value("${ApiCallOneClient.client-url}")
    private String apiOneUrl;


    public ApiCallOneClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ApiResponseOne[] fetchDataForAPIOne(HttpServletResponse response) throws IOException {
        ResponseEntity<ApiResponseOne[]> apiResponse =
                restTemplate.getForEntity(apiOneUrl, ApiResponseOne[].class);

        ApiResponseOne[] users = apiResponse.getBody();

        if (users == null) {
            throw new RuntimeException("No data from API");
        }
        return users;
    }

}
