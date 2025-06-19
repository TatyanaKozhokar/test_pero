package com.example.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

public class PublicPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";

    }

    @BeforeEach
    public void setUp() {
        PublicPage publicPage = new PublicPage();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open(publicPage.getSetUpUrl());
    }

    @DisplayName("Проверка названия сообщества")
    @Test
    public void testPriceDisplayed(){
        PublicPage publicPage = new PublicPage();
        publicPage.getPublicTitle()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Test public for test"));
    }

    @DisplayName("Проверка кнопки Подписаться")
    @Test
    public void testSubscribeButton(){
        PublicPage publicPage = new PublicPage();
        publicPage.getSubscribeButton()
                .shouldBe(Condition.visible)
                .click();
        Selenide.webdriver().shouldHave(WebDriverConditions.title("ВКонтакте | Добро пожаловать"));
    }

    @DisplayName("Проверка кнопки с отзывами")
    @Test
    public void testReviewButton(){
        PublicPage publicPage = new PublicPage();
        publicPage.getReviewButton()
                .shouldBe(Condition.visible)
                .click();
        Selenide.webdriver().shouldHave(WebDriverConditions.url(publicPage.getReviewPage()));
    }

    @DisplayName("Проверка кнопки с отзывами(звезды)")
    @Test
    public void testRatingStarsButton(){
        PublicPage publicPage = new PublicPage();
        publicPage.getRatingStars()
                .shouldBe(Condition.visible)
                .click();
        Selenide.webdriver().shouldHave(WebDriverConditions.title("ВКонтакте | Добро пожаловать"));    }

    @DisplayName("Проверка кнопки Услуги")
    @Test
    public void testServiceButton() {
        PublicPage publicPage = new PublicPage();
        publicPage.getServiceButton()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click();

        publicPage.getServiceItemTitle()
                .shouldBe(Condition.visible);

        publicPage.getServiceItemPrice()
                .shouldBe(Condition.visible);
    }

    @DisplayName("Проверка кнопки Товары")
    @Test
    public void testItemsButton() {
        PublicPage publicPage = new PublicPage();
        publicPage.getServiceButton()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click();
        publicPage.getItemsButton()
                .shouldBe(Condition.visible)
                .click();

        publicPage.getItemsTitle()
                .shouldBe(Condition.visible);

        publicPage.getItemsPrice()
                .shouldBe(Condition.visible);
    }

    @DisplayName("Проверка кнопки Показать все товары")
    @Test
    public void testShowAllItemsButton() {
        PublicPage publicPage = new PublicPage();
        publicPage.getAllItems()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click();
        Selenide.webdriver().shouldHave(WebDriverConditions.url(publicPage.getAllItemsPage()));
    }

    @DisplayName("Проверка кнопки Показать все услуги")
    @Test
    public void testShowAllServicesButton() {
        PublicPage publicPage = new PublicPage();
        publicPage.getServiceButton()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click();
        publicPage.getAllServices().click();
        Selenide.webdriver().shouldHave(WebDriverConditions.url(publicPage.getAllServicesPage()));
    }

    @DisplayName("Проверка перехода в товар по клике на карточку")
    @Test
    public void testItemsCardButton() {
        PublicPage publicPage = new PublicPage();
        publicPage.getItemsButton()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible);
        publicPage.getItemImage().click();
        Selenide.webdriver().shouldHave(WebDriverConditions.url(publicPage.getItemPage()));
    }

    @DisplayName("Проверка перехода в услугу по клике на карточку")
    @Test
    public void testServiceCardButton() {
        PublicPage publicPage = new PublicPage();
        publicPage.getServiceButton()
                .scrollIntoView("{block: 'center'}")
                .shouldBe(Condition.visible)
                .click();
        publicPage.getServiceButton().click();
        Selenide.webdriver().shouldHave(WebDriverConditions.url(publicPage.getServicePage()));
    }

}
