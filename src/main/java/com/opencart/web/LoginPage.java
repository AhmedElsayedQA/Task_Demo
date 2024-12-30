package com.opencart.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    private final By emailField= By.id("input-email");
    private final By passwordField=By.id("input-password");
    private final By loginBtn=By.xpath("//button[@type='submit']");

    public LoginPage enterEmail(String email) {
        sendText(emailField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendText(passwordField, password);
        return this;
    }

    public MyAccountPage clickLoginBtn(){
        clickElement(loginBtn);
        return new MyAccountPage(driver);
    }

    public MyAccountPage loginWith(String email ,String password){
         enterEmail(email).enterPassword(password).clickLoginBtn();
         return new MyAccountPage(driver);
    }
}
