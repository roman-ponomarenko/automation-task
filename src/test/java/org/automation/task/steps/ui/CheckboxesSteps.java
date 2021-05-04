package org.automation.task.steps.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.automation.task.core.annotations.Steps;
import org.automation.task.core.enums.CheckboxState;
import org.automation.task.pagefactory.pages.CheckboxesPage;

import static com.codeborne.selenide.Condition.*;
import static org.automation.task.core.enums.CheckboxState.CHECKED;
import static org.automation.task.core.enums.CheckboxState.UNCHECKED;

@Steps
@RequiredArgsConstructor
public class CheckboxesSteps {
    private final CheckboxesPage checkboxesPage;

    @Step("User gets first checkbox state")
    public CheckboxState getFirstCheckboxState() {
        SelenideElement checkbox = checkboxesPage.getCheckbox1();
        return checkbox.is(checked) ? CHECKED : UNCHECKED;
    }

    @Step("User gets second checkbox state")
    public CheckboxState getSecondCheckboxState() {
        SelenideElement checkbox = checkboxesPage.getCheckbox2();
        return checkbox.is(checked) ? CHECKED : UNCHECKED;
    }

    @Step("User sets first checkbox to '{state}' state")
    public void toggleFirstCheckbox(CheckboxState state) {
        SelenideElement checkbox = checkboxesPage.getCheckbox1();
        if (checkbox.is(checked) && !state.toValue() || checkbox.is(not(checked)) && state.toValue()) {
            checkbox.shouldBe(visible, enabled).click();
        }
    }

    @Step("User sets second checkbox to '{state}' state")
    public void toggleSecondCheckbox(CheckboxState state) {
        SelenideElement checkbox = checkboxesPage.getCheckbox2();
        if (checkbox.is(checked) && !state.toValue() || checkbox.is(not(checked)) && state.toValue()) {
            checkbox.shouldBe(visible, enabled).click();
        }
    }

    @Step("User sees first checkbox is '{state}'")
    public void verifyFirstCheckboxState(CheckboxState state) {
        Condition isChecked = CHECKED.equals(state) ? checked : not(checked);
        checkboxesPage.getCheckbox1().shouldBe(visible, enabled, isChecked);
    }

    @Step("User sees second checkbox is '{state}'")
    public void verifySecondCheckboxState(CheckboxState state) {
        Condition isChecked = CHECKED.equals(state) ? checked : not(checked);
        checkboxesPage.getCheckbox2().shouldBe(visible, enabled, isChecked);
    }
}
