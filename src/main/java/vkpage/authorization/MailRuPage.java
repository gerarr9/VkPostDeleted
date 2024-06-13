package vkpage.authorization;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MailRuPage {
    WebDriver driver = WebDriverRunner.getWebDriver();
    String token ;
    String mainWindowHandle;


    public MailRuPage switchToFrame(String frameXpath) {
        // Явное ожидание iframe
        $(By.xpath(frameXpath)).shouldBe(Condition.visible);
        Selenide.switchTo().frame($(By.xpath(frameXpath)));
        return this;
    }

    public MailRuPage switchToDefaultContent() {
        Selenide.switchTo().defaultContent();
        return this;
    }

    public MailRuPage loginMailRu(String login, String pass) {
        mainWindowHandle = driver.getWindowHandle();
        openNewWindow();
        String emailXpath = "//input[@name='username']";
        String passwordXpath = "//input[@name='password']";
        String iframeXpath = "//iframe[@class='ag-popup__frame__layout__iframe']";

        $(By.xpath("//button[contains(text(),'Войти')]")).shouldBe(Condition.visible).click();

        // Переключаемся на iframe
        switchToFrame(iframeXpath);

        // Выполняем действия внутри iframe
        $(By.xpath(emailXpath)).shouldBe(Condition.visible).sendKeys(login);
        $(By.xpath("//button[@data-test-id='next-button']")).click();
        $(By.xpath(passwordXpath)).shouldBe(Condition.visible).sendKeys(pass);
        $(By.xpath("//button[@data-test-id='submit-button']")).click();

        // Возвращаемся к основному контенту
        switchToDefaultContent();
        initialize();
        closeCurrentWindowAndSwitchBack();
        return this;
    }

    public TapePageVk setTokenAndPassword(String password) {
        $(By.xpath("//input[@name='otp-cell']")).shouldBe(Condition.visible).sendKeys(token);
        $(By.xpath("//input[@name='password']")).shouldBe(Condition.visible).sendKeys(password);
        $(By.xpath("//span[@class='vkuiButton__in']")).click();
        return page(TapePageVk.class);
    }

    private void openNewWindow() {

        // Использование JavaScript для открытия новой вкладки
        ((JavascriptExecutor) driver).executeScript("window.open('https://mail.ru/?from=logout', '_blank');");

        // Переключение на новую вкладку
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

    private void initialize() {
        String xp = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']//a";
        String code = "//b/b";
        $(byXpath(xp)).shouldBe(Condition.visible).click();
        token = $(byXpath(code)).shouldBe(Condition.visible).text();
    }
    private void closeCurrentWindowAndSwitchBack() {
        driver.close();
        driver.switchTo().window(mainWindowHandle); // Переключаемся обратно на основное окно
    }
}
