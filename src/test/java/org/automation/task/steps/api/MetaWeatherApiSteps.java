package org.automation.task.steps.api;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.automation.task.core.annotations.Steps;
import org.automation.task.core.controllers.MetaWeatherApi;
import org.automation.task.core.dto.SearchResult;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Steps
@RequiredArgsConstructor
public class MetaWeatherApiSteps extends BaseApiSteps {
    private final MetaWeatherApi metaWeatherApi;

    @Step("Search location for '{query}' query")
    public ResponseEntity<String> searchLocation(String query) {
        return metaWeatherApi.searchLocation(query);
    }

    @Step("Verify search results are correct")
    public void verifyResultsAreCorrect(List<SearchResult> results, String searchQuery) {
        results.forEach(r -> assertDtoContainsValue(r, SearchResult::getTitle, searchQuery, "title"));
    }
}
