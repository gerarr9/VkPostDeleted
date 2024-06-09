import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    @BeforeMethod
    public void settings(){
        Configuration.baseUrl ="https://vk.com/";
        Configuration.browser ="chrome";
        Configuration.timeout = 3000;
        open(Configuration.baseUrl);
        getWebDriver().manage().window().maximize();
    }
}
