package com.opencart.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends Page {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    private final By myAccountBtn = By.xpath("//span[text()='My Account']");
    private final By registerBtn = By.xpath("//a[@class='dropdown-item' and text()='Register']");
    private final By loginBtn = By.xpath("//a[@class='dropdown-item' and text()='Login']");
    private final By orderHistoryBtn = By.xpath("//a[@class='dropdown-item' and text()='Order History']");

    private final By shoppingCartBtn = By.xpath("//span[text()='Shopping Cart']");
    private final By checkoutBtn = By.xpath("//span[text()='Checkout']");
    private final By logo = By.className("img-fluid");
    private final By searchBar = By.name("search");
    private final By searchBtn = By.xpath("//div[@id='search']/button");
    private final By homeBreadCrumb = By.xpath("//i[@class='fas fa-home']");

    public HeaderPage clickMyAccountBtn() {
        clickElement(myAccountBtn);
        return this;
    }

    public RegisterPage clickRegisterBtn() {
        clickElement(registerBtn);
        return new RegisterPage(driver);
    }

    public RegisterPage clickLoginBtn() {
        clickElement(loginBtn);
        return new RegisterPage(driver);
    }

    public SearchPage searchWith(String searchText) {
        scrollByVisibleElement(searchBar);
        sendText(searchBar, searchText);
        clickElement(searchBtn);
        return new SearchPage(driver);
    }

    public CheckoutPage clickCheckoutBtn() {
        scrollByVisibleElement(checkoutBtn);
        clickElement(checkoutBtn);
        return new CheckoutPage(driver);
    }

    public MyAccountPage clickOrderHistoryBtn() {
        clickElement(orderHistoryBtn);
        return new MyAccountPage(driver);
    }


}
