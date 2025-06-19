package com.example.demo;

import com.codeborne.selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class ProductPageTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";}

    @BeforeEach
    public void setUp() {
        ProductPage productPage = new ProductPage();
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open(productPage.getSetUpUrl());
    }

    @Test
    public void search() throws InterruptedException {
        Thread.sleep(1_000);
    }

    @DisplayName("Проверка названия товара")
    @Test
    public void testItemTitleDisplayed(){
        ProductPage productPage = new ProductPage();
        productPage.getItemTitle()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("фываф"));
    }

    @DisplayName("Проверка цены")
    @Test
    public void testPriceDisplayed(){
        ProductPage productPage = new ProductPage();
        productPage.getItemPrice()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("бесплатно"));
    }

    @DisplayName("Проверка дисклеймера")
    @Test
    public void testDisclaimerDisplayed(){
        ProductPage productPage = new ProductPage();
        productPage.getItemDisclaimer()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Перед покупкой уточняйте характеристики и комплектацию у продавца"));
    }

    @DisplayName("Проверка наличия заголовка Описание")
    @Test
    public void testDescriptionTitleDisplayed(){
        ProductPage productPage = new ProductPage();
        productPage.getDescriptionTitle()
                .scrollTo()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("Описание"));
    }

    @DisplayName("Проверка текста описания")
    @Test
    public void testDescriptionTextDisplayed(){
        ProductPage productPage = new ProductPage();
        productPage.getDescriptionText()
                .scrollTo()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText("testing product"));
    }

    @DisplayName("Проверка кнопки Пожаловаться на услугу")
    @Test
    public void testReportButton(){
        ProductPage productPage = new ProductPage();
        productPage.getMakeAReportButton()
                .scrollTo()
                .shouldBe(Condition.visible)
                .click();

        Selenide.webdriver().shouldHave(WebDriverConditions.title("Жалоба"));
    }


    @DisplayName("Проверка нажатия кнопки Написать")
    @Test
    public void testWriteButton(){
        ProductPage productPage = new ProductPage();
        productPage.getWriteButton()
                .shouldBe(Condition.visible)
                .click();

        Selenide.webdriver().shouldHave(WebDriverConditions.title("ВКонтакте | Добро пожаловать"));
    }

    @DisplayName("Проверка нажатия на название магазина")
    @Test
    public void testShopNameInTheMiddleButton(){
        ProductPage productPage = new ProductPage();
        productPage.getShopNameButtonInTheMiddle()
                .shouldBe(Condition.visible)
                .click();
        Selenide.webdriver().shouldHave(WebDriverConditions.title("Test public for test | ВКонтакте"));
    }

    @DisplayName("Проверка кнопки Поделиться")
    @Test
    public void testShareButton(){
        ProductPage productPage = new ProductPage();
        productPage.getShareButton()
                .shouldBe(Condition.visible)
                .click();
        $("div[data-testid='box_layout']").shouldBe(Condition.visible);
    }

    @DisplayName("Проверка кнопки Подписаться")
    @Test
    public void testSubscribeButton(){
        ProductPage productPage = new ProductPage();
        productPage.getSubscribeButton()
                .shouldBe(Condition.visible)
                .click();

        Selenide.webdriver().shouldHave(WebDriverConditions.title("ВКонтакте | Добро пожаловать"));
    }




}
