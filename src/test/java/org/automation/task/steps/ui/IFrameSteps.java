package org.automation.task.steps.ui;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.automation.task.core.annotations.InIFrame;
import org.automation.task.core.annotations.Steps;
import org.automation.task.pagefactory.pages.IFramePage;

import static com.codeborne.selenide.Condition.*;
import static org.openqa.selenium.support.How.ID;

@Steps
@RequiredArgsConstructor
public class IFrameSteps {
    private final IFramePage iFramePage;

    @InIFrame(how = ID, locator = "mce_0_ifr")
    @Step("User enters '{value}' in editor")
    public void enterTextInEditor(String value) {
        iFramePage.getEditor().shouldBe(visible, enabled).setValue(value);
    }

    @InIFrame(how = ID, locator = "mce_0_ifr")
    @Step("User sees '{value}' in editor")
    public void verifyTextInEditor(String value) {
        iFramePage.getEditor().shouldBe(visible, enabled, text(value));
    }
}
