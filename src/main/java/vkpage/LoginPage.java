package vkpage;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    public LoginPage loginVk(String login) {
        $(byId("index_email")).sendKeys(login);
        $(byXpath("//button[contains(@class,'FlatButton FlatButton--pr')]")).click();
        return this;
    }

    public MailRuPage pass() {
        String n = "//span[contains(text(),'Подтвер')]";
        String mail = "//span[contains(text(),'почта')]";
        $(byXpath(n)).click();
        $(byXpath(mail)).click();
        return page(MailRuPage.class);
    }



}
