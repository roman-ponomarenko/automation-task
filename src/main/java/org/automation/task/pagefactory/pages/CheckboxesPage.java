package org.automation.task.pagefactory.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.automation.task.core.annotations.Page;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Page
@Getter
public class CheckboxesPage {
    private final SelenideElement pageTitle = $("h3");
    private final SelenideElement checkbox1 = $(By.xpath("//form[@id='checkboxes']/input[1]"));
    private final SelenideElement checkbox2 = $(By.xpath("//form[@id='checkboxes']/input[2]"));
}
