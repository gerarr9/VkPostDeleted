package vkpage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    public MainPage delete() {
        String xpath = "//span[contains(@class, 'PostHeaderActionsUiActionMenuIcon')]";
        $(byXpath(xpath));
        return this;
    }
}
