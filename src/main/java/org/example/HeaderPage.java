package org.example;

import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage extends Page{

    HeaderPage(WebDriver driver){
        super(driver);
    }
    private final By myAccountBtn= By.xpath("//span[text()='My Account']");
    private final By registerBtn=By.xpath("//a[@class='dropdown-item' and text()='Register']");
    private final By loginBtn=By.xpath("//a[@class='dropdown-item' and text()='Login']");
    private final By orderHistoryBtn=By.xpath("//a[@class='dropdown-item' and text()='Order History']");

    private final By shoppingCartBtn= By.xpath("//span[text()='Shopping Cart']");
    private final By checkoutBtn= By.xpath("//span[text()='Checkout']");
    private final By logo=By.className("img-fluid");
    private final By searchBar=By.name("search");
    private final By searchBtn=By.xpath("//div[@id='search']/button");

    public HeaderPage clickMyAccountBtn(){
        clickElement(myAccountBtn);
        return this;
    }

    public RegisterPage clickRegisterBtn(){
        clickElement(registerBtn);
        return new RegisterPage(driver);
    }

    public RegisterPage clickLoginBtn(){
        clickElement(loginBtn);
        return new RegisterPage(driver);
    }

    public HomePage goHome(){
        clickElement(logo);
        return new HomePage(driver);
    }

    public SearchPage searchWith(String searchText){
        sendText(searchBar,searchText);
        clickElement(searchBtn);
        return new SearchPage(driver);
    }


}
