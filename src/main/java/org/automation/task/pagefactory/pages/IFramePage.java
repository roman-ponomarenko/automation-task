package org.automation.task.pagefactory.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.automation.task.core.annotations.Page;

import static com.codeborne.selenide.Selenide.$;

@Page
@Getter
public class IFramePage {
    private final SelenideElement editor = $("#tinymce");
}
