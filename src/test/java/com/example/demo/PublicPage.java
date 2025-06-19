package com.example.demo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PublicPage {
    public String getSetUpUrl() {
        return "https://vk.com/club225299895";
    }

    public String getServicePage() {
        return "https://vk.com/market/product/fyvaf-225299895-10044406";
    }

    public String getItemPage() {
        return "https://vk.com/market/product/test-225299895-10863893";
    }

    public String getAllServicesPage() {
        return "https://vk.com/uslugi-225299895?screen=group";
    }

    public String getAllItemsPage() {
        return "https://vk.com/market-225299895?screen=group";
    }

    public String getReviewPage() {
        return "https://vk.com/reviews-225299895";
    }

    public PublicPage() {
        Selenide.page(this);
    }

    @Name("Кнопка Услуги")
    public SelenideElement getServiceButton() {
        return $("li[data-testid='group_tab_services']");
    }

    @Name("Название товара в Услугах")
    public SelenideElement getServiceItemTitle() {
        return $x("//div[text()='фываф']");
    }

    @Name("Цена товара в Услугах")
    public SelenideElement getServiceItemPrice() {
        return $x("//div[text()='бесплатно']");
    }

    @Name("Кнопка Товары")
    public SelenideElement getItemsButton() {
        return $("li[data-testid='group_tab_market']");
    }

    @Name("Название товара")
    public SelenideElement getItemsTitle() {
        return $x("//div[text()='Тест']");
    }

    @Name("Цена товара")
    public SelenideElement getItemsPrice() {
        return $x("//div[contains(., '300') and contains(., '₽')]");
    }

    @Name("Название сообщества")
    public SelenideElement getPublicTitle() {
        return $("h1[class='page_name']");
    }

    @Name("Кнопка подписаться")
    public SelenideElement getSubscribeButton() {
        return $("span[class='FlatButton__in']");
    }

    @Name("Кнопка с отзывами")
    public SelenideElement getReviewButton() {
        return $("span[class='vkitRatingLayout__afterInner--qSCiI']");
    }

    @Name("Рейтинг(звезды)")
    public SelenideElement getRatingStars() {
        return $x("ul[data-testid='ratingstars']");
    }

    @Name("Кнопка показать все товары")
    public SelenideElement getAllItems() {
        return $x("//span[contains(@class, 'vkuiButton__content') and contains(text(), 'Показать все')]");
    }

    @Name("Кнопка показать все услуги")
    public SelenideElement getAllServices() {
        return $x("//span[contains(@class, 'FlatButton__content') and contains(text(), 'Показать все')]");
    }

    @Name("Изображение товара")
    public SelenideElement getItemImage() {
        return $("div[data-testid='product_card_picture']");    }


}
