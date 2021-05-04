package org.automation.task.core.controllers;

import lombok.RequiredArgsConstructor;
import org.automation.task.core.clients.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class MetaWeatherApi {
    protected final HttpClient httpClient;

    @Value("${test.api.url}")
    private String apiUrl;

    public ResponseEntity<String> searchLocation(String query) {
        HttpHeaders httpHeaders = httpClient.getBasicHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl);
        builder.pathSegment("search");
        builder.queryParam("query", query);

        return httpClient.get(builder.toUriString(), new HttpEntity<>(httpHeaders), String.class);
    }
}
