import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import vkpage.authorization.ConfigLoader;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    protected static ConfigLoader config;
    @BeforeMethod
    public void settings(){
        Configuration.baseUrl ="https://vk.com/";
        Configuration.browser ="chrome";
        Configuration.timeout = 6000;
        config = new ConfigLoader();
        open(Configuration.baseUrl);
        getWebDriver().manage().window().maximize();

    }

}
