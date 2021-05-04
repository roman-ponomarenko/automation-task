package org.automation.task.tests;

import io.qameta.allure.Step;
import org.automation.task.core.config.FrameworkContextConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {FrameworkContextConfig.class})
public class BaseTest {
    @AfterEach
    @Step("User closes browser")
    public void tearDown() {
        closeWebDriver();
    }
}
