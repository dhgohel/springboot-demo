package com.example.demo.clients;

import com.example.demo.models.*;
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

    public ApiResponseOne[] fetchDataForAPIOne() throws IOException {
        ResponseEntity<ApiResponseOne[]> apiResponse =
                restTemplate.getForEntity(apiOneUrl, ApiResponseOne[].class);

        ApiResponseOne[] users = apiResponse.getBody();

        if (users == null) {
            throw new RuntimeException("No data from API");
        }
        return users;
    }

    public ApiResponseTwo[] fetchDataForAPITwo() throws IOException {
        ResponseEntity<ApiResponseTwo[]> apiResponse =
                restTemplate.getForEntity(apiOneUrl, ApiResponseTwo[].class);

        ApiResponseTwo[] users = apiResponse.getBody();

        if (users == null) {
            throw new RuntimeException("No data from API");
        }
        return users;
    }

    public ApiResponseThree[] fetchDataForAPIThree() throws IOException {
        ResponseEntity<ApiResponseThree[]> apiResponse =
                restTemplate.getForEntity(apiOneUrl, ApiResponseThree[].class);

        ApiResponseThree[] users = apiResponse.getBody();

        if (users == null) {
            throw new RuntimeException("No data from API");
        }
        return users;
    }

    public ApiResponseFour[] fetchDataForAPIFour() throws IOException {
        ResponseEntity<ApiResponseFour[]> apiResponse =
                restTemplate.getForEntity(apiOneUrl, ApiResponseFour[].class);

        ApiResponseFour[] users = apiResponse.getBody();

        if (users == null) {
            throw new RuntimeException("No data from API");
        }
        return users;
    }

    public ApiResponseFive[] fetchDataForAPIFive() throws IOException {
        ResponseEntity<ApiResponseFive[]> apiResponse =
                restTemplate.getForEntity(apiOneUrl, ApiResponseFive[].class);

        ApiResponseFive[] users = apiResponse.getBody();

        if (users == null) {
            throw new RuntimeException("No data from API");
        }
        return users;
    }

}
