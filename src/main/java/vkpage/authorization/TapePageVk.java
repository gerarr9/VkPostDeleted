package vkpage.authorization;

import vkpage.postDeleted.MainPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TapePageVk {


    public MainPage openMainPage() {
        $(byXpath("//a[@class='LeftMenuItem-module__item--XMcN9']")).click();
        return page(MainPage.class);
    }
}
