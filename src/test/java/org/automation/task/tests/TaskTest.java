package org.automation.task.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.RequiredArgsConstructor;
import org.automation.task.core.dto.SearchResult;
import org.automation.task.core.dto.SearchResult.SearchResults;
import org.automation.task.core.enums.CheckboxState;
import org.automation.task.steps.api.MetaWeatherApiSteps;
import org.automation.task.steps.ui.CheckboxesSteps;
import org.automation.task.steps.ui.FramesSteps;
import org.automation.task.steps.ui.HomeUISteps;
import org.automation.task.steps.ui.IFrameSteps;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag("all")
@Feature("Test task test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class TaskTest extends BaseTest {
    private final HomeUISteps homeSteps;
    private final CheckboxesSteps checkboxesSteps;
    private final FramesSteps framesSteps;
    private final IFrameSteps iFrameSteps;
    private final MetaWeatherApiSteps metaWeatherApiSteps;

    @Value("${test.app.url}")
    private String appUrl;

    @Test
    @Tag("ui")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able to change checkbox state")
    void checkboxesTest() {
        homeSteps.open(appUrl);
        homeSteps.clickCheckboxesLnk();

        CheckboxState firstState = checkboxesSteps.getFirstCheckboxState();
        CheckboxState secondState = checkboxesSteps.getSecondCheckboxState();

        checkboxesSteps.toggleFirstCheckbox(firstState.opposite());
        checkboxesSteps.toggleSecondCheckbox(secondState.opposite());

        checkboxesSteps.verifyFirstCheckboxState(firstState.opposite());
        checkboxesSteps.verifySecondCheckboxState(secondState.opposite());
    }

    @Test
    @Tag("ui")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able to edit text in TinyMCE Editor")
    void iframeTest() {
        String value = "Roman";

        homeSteps.open(appUrl);
        homeSteps.clickFramesLnk();

        framesSteps.clickiFrameLnk();

        iFrameSteps.enterTextInEditor(value);
        iFrameSteps.verifyTextInEditor(value);
    }

    @Test
    @Tag("api")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User should be able to search for a location")
    void searchValidLocationTest() {
        String searchQuery = "san";

        ResponseEntity<String> responseEntity = metaWeatherApiSteps.searchLocation(searchQuery);

        metaWeatherApiSteps.assertResponseStatusCode(responseEntity, HttpStatus.OK);
        List<SearchResult> results = metaWeatherApiSteps.getResponseDto(responseEntity, SearchResults.class);

        metaWeatherApiSteps.assertCollectionResponseIsNotEmpty(results);
        metaWeatherApiSteps.verifyResultsAreCorrect(results, searchQuery);
    }
}
