package com.example.demo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Name;

import static com.codeborne.selenide.Selenide.$;

// page_url = https://vk.com/club225299895?w=product-225299895_10044406
public class ProductPage {
    public String getSetUpUrl() {
        return "https://vk.com/club225299895?w=product-225299895_10044406";
    }

    public ProductPage() {
        Selenide.page(this);
    }

    @Name("Название товара")
    public SelenideElement getItemTitle() {
        return $("h1[data-testid='market_item_page_title']");
    }

    @Name("Цена товара")
    public SelenideElement getItemPrice() {
        return $("h2[data-testid='market_item_page_price']");
    }

    @Name("Дисклеймер")
    public SelenideElement getItemDisclaimer(){
        return $("span[data-testid='market_item_disclaimer']");
    }

    @Name("Описание")
    public SelenideElement getDescriptionTitle() {
        return $("span[data-testid='market_item_description_title']");
    }

    @Name("Текст описания")
    public SelenideElement getDescriptionText() {
        return $("div[data-testid='market_item_page_description']");
    }

    @Name("Поделиться")
    public SelenideElement getShareButton() {
        return $("button[data-testid='market_item_page_share']");
    }

    @Name("Кнопка Пожаловаться на услугу")
    public SelenideElement getMakeAReportButton(){
        return $("div[data-testid='market_item_page_report']");
    }


    @Name("Кнопка Написать")
    public SelenideElement getWriteButton(){
        return $("button[data-testid='market_item_page_primary_button']");
    }

    @Name("Кнопка Подписаться")
    public SelenideElement getSubscribeButton(){
        return $("button[data-testid='market_item_page_subscribe_button']");
    }

    @Name("Ссылка на магазин под кнопкой написать")
    public SelenideElement getShopNameButtonInTheMiddle(){
        return $("span[data-testid='market_item_page_shop_text']");
    }


}
