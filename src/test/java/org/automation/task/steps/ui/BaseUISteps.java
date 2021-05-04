package org.automation.task.steps.ui;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public abstract class BaseUISteps {
    @Step("User opens '{url}' url")
    public void open(String url) {
        Selenide.open(url);
    }
}
