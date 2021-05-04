package org.automation.task.steps.ui;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.automation.task.core.annotations.Steps;
import org.automation.task.pagefactory.pages.FramesPage;

@Steps
@RequiredArgsConstructor
public class FramesSteps {
    private final FramesPage framesPage;

    @Step("User clicks 'iFrames' link")
    public void clickiFrameLnk() {
        framesPage.getIFrameLnk().click();
    }
}
