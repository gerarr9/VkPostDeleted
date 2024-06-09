package vkpage;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    public LoginPage autho(String login) {
        $(byId("index_email")).sendKeys(login);
        $(byXpath("//button[contains(@class,'FlatButton FlatButton--pr')]")).click();
        return this;
    }
}
