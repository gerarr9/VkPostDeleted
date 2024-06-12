import vkpage.LoginPage;
import vkpage.MailRuPage;
import vkpage.MainPageVk;

import static com.codeborne.selenide.Selenide.open;

public class  Test extends BaseTest {

    @org.testng.annotations.Test
    public void deleted() throws InterruptedException {
        MainPageVk loginPage = open("", LoginPage.class)
                .loginVk(config.getUsername())
                .pass()
                .loginMailRu(config.getLoginMail(),config.getPasswordMail())
                .setTokenAndPassword(config.getPassword());
    }
}
