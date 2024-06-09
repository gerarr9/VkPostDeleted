import vkpage.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void deleted()   {
        LoginPage loginPage = open("", LoginPage.class)
                .autho("");

    }
}
