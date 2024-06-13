import vkpage.authorization.LoginPage;
import vkpage.authorization.TapePageVk;
import vkpage.postDeleted.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class  Test extends BaseTest {

    @org.testng.annotations.Test
    public void deleted() throws InterruptedException {
        TapePageVk loginPage = open("", LoginPage.class)
                .loginVk(config.getUsername())
                .pass()
                .loginMailRu(config.getLoginMail(),config.getPasswordMail())
                .setTokenAndPassword(config.getPassword());

        MainPage mainPage = loginPage.openMainPage()
                .scrollAndDeleted();
    }
}
