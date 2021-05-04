package org.automation.task.steps.ui;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.automation.task.core.annotations.Steps;
import org.automation.task.pagefactory.pages.HomePage;

@Steps
@RequiredArgsConstructor
public class HomeUISteps extends BaseUISteps {
    private final HomePage homePage;

    @Step("User clicks 'Checkboxes' link")
    public void clickCheckboxesLnk() {
        homePage.getCheckboxesLnk().click();
    }

    @Step("User clicks 'Frames' link")
    public void clickFramesLnk() {
        homePage.getFramesLnk().click();
    }
}
