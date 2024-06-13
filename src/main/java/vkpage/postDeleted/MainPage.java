package vkpage.postDeleted;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public MainPage scrollAndDeleted() {
        // Проверяем видимость заголовка, чтобы убедиться, что страница загружена
        $(byXpath("//h2")).shouldBe(visible);
        executeJavaScript("window.scrollBy(0, 500);");

        int i = 1;
        while (true) {
            // Прокручиваем страницу вниз на 500 пикселей
            sleep(500); // Пауза для ожидания загрузки элементов

            // XPath для постов и кнопок меню
            String postXpath = "(//span[@class='PostHeaderActionsButtonMoreIcon'])[" + i + "]";
            String menuXpath = "(//div[@class='ui_actions_menu _ui_menu ui_actions_menu--actionSheet'])[" + i + "]/a[1]";

            // Проверяем, существует ли элемент с текущим индексом
            if ($(byXpath(postXpath)).exists()) {
                SelenideElement postIcon = $(byXpath(postXpath));
                postIcon.scrollTo();
                executeJavaScript("window.scrollBy(0, -250);");

                sleep(500);
                // Наведение на элемент
                postIcon.hover();
                sleep(500); // Пауза для завершения анимации

                // Проверяем, существует ли меню с текущим индексом
                if ($(byXpath(menuXpath)).exists()) {
                    SelenideElement menuItem = $(byXpath(menuXpath));

                    // Наведение на меню
                    //actions().moveToElement(menuItem).perform();
                  //  sleep(500); // Пауза для завершения анимации
                    menuItem.click();
                }
            } else {
                break;
            }
            menuXpath = "(//div[@class='ui_actions_menu _ui_menu ui_actions_menu--actionSheet'])[" + i + "]/a[1]";
            i++;
        }

        return this;
    }

}
