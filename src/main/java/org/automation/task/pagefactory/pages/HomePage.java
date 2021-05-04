package org.automation.task.pagefactory.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.automation.task.core.annotations.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Page
@Getter
public class HomePage {
    private final SelenideElement checkboxesLnk = $(By.linkText("Checkboxes"));
    private final SelenideElement framesLnk = $(By.linkText("Frames"));
}
