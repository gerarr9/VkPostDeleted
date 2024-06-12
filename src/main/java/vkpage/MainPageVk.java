package vkpage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageVk {


    public MainPageVk delete() {
        String xpath = "//span[contains(@class, 'PostHeaderActionsUiActionMenuIcon')]";
        $(byXpath(xpath));
        return this;
    }
}
