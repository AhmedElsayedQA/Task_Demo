package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends LoginPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.id("input-firstname");
    private final By lastNameField = By.id("input-lastname");
    private final By emailField = By.id("input-email");
    private final By passwordField = By.id("input-password");
    private final By privacyPolicyButton = By.xpath("//input[@type='checkbox']");
    private final By signupButton = By.xpath("//button[@type='submit']");
    private final By successMsg = By.id("content");

    public RegisterPage enterFirstName(String firstName) {
        sendText(firstNameField, firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        sendText(lastNameField, lastName);
        return this;
    }
    public RegisterPage enterEmail(String email) {
        sendText(emailField, email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        sendText(passwordField, password);
        return this;
    }

    public RegisterPage clickPrivacyPolicyCheck() {
        clickElement(privacyPolicyButton);
        return this;
    }

    public RegisterPage clickContinue() {
        clickElement(signupButton);
        return this;
    }

    public String getSuccessMsg() {
        return getElementText(successMsg);
    }



}
