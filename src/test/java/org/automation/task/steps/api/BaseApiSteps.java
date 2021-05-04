package org.automation.task.steps.api;

import io.qameta.allure.Step;
import org.automation.task.core.utils.JsonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public abstract class BaseApiSteps {
    @Step("Verify http status code is correct")
    public void assertResponseStatusCode(ResponseEntity<?> actual, HttpStatus status) {
        assertThat(actual.getStatusCode())
                .as("http status code should be correct.")
                .isEqualTo(status);
    }

    @Step("Verify response collection is not empty")
    public void assertCollectionResponseIsNotEmpty(Collection<?> actual) {
        assertThat(actual)
                .as("Response collection should not be empty.")
                .asList().isNotEmpty();
    }

    @Step("User sees valid '{fieldName}' contains '{expectedValue}' value")
    public <T> void assertDtoContainsValue(T dto, Function<T, String> valueExtractor,
                                           String expectedValue, String fieldName) {
        assertThat(valueExtractor.apply(dto))
                .as(String.format("'%s' field must contain value.", fieldName))
                .containsIgnoringCase(expectedValue);
    }

    public <T> T getResponseDto(ResponseEntity<String> entity, Class<T> clazz) {
        return JsonUtils.readValue(entity.getBody(), clazz);
    }
}
