package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

    public HomePage(WebDriver driver){
        super(driver);
    }
    //Header Components
    private By myAccountBtn= By.xpath("//span[text()='My Account']");
    private By registerBtn=By.xpath("//a[@class='dropdown-item' and text()='Register']");
    private By loginBtn=By.xpath("//a[@class='dropdown-item' and text()='Login']");
    private By shoppingCartBtn= By.xpath("//span[text()='Shopping Cart']");
    private By checkoutBtn= By.xpath("//span[text()='Checkout']");


}
