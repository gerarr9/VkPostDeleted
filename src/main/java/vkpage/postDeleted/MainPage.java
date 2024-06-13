package vkpage.postDeleted;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {


    public MainPage scrollAndDeleted() {
        // Проверяем видимость заголовка, чтобы убедиться, что страница загружена
        $(byXpath("//h2")).shouldBe(visible);
        String postXpath = "(//span[@class='PostHeaderActionsButtonMoreIcon'])[1]";
        String menuXpath = "(//div[@class='ui_actions_menu _ui_menu ui_actions_menu--actionSheet'])[1]/a[1]";


        // Прокручиваем страницу вниз на 500 пикселей
        sleep(500); // Пауза для ожидания загрузки элементов

        // XPath для постов и кнопок меню


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
            SelenideElement menuItem = $(byXpath(menuXpath));
            menuItem.click();
            Selenide.refresh();
            scrollAndDeleted();
        }
        return this;
    }
}