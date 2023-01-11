package com.training.performance.spring;

import org.springframework.web.client.RestTemplate;

public class RestClientExample {

    public void call() {
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.postForObject("http://127.0.0.1:8080/api/v1/xyz",
                                              "test",
                                              String.class);
        System.out.println("next line");
    }
}
