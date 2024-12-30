package com.opencart.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Page {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.id("input-shipping-firstname");
    private final By lastNameField = By.id("input-shipping-lastname");
    private final By addressField = By.id("input-shipping-address-1");
    private final By cityField = By.id("input-shipping-city");
    private final By postCodeField = By.id("input-shipping-postcode");
    private final By countryDropDown = By.id("input-shipping-country");
    private final By stateDropDown = By.id("input-shipping-zone");
    private final By continueBtn = By.id("button-shipping-address");
    private final By confirmOrderBtn = By.xpath("//*[@class='text-end']/button");
    private final By shippingMethodChooseBtn = By.id("button-shipping-methods");
    private final By paymentMethodChooseBtn = By.id("button-payment-methods");
    private final By paymentMethodOption = By.xpath("//form[@id='form-payment-method']//div[@class='form-check']/input");
    private final By shippingMethodOption = By.xpath("//form[@id='form-shipping-method']//div[@class='form-check']/input");
    private final By shippingMethodContinueBtn = By.xpath("//form[@id='form-shipping-method']//button");
    private final By paymentMethodContinueBtn = By.xpath("//form[@id='form-payment-method']//button");
    private final By orderPlacedSuccessMsg = By.xpath("//*[@id='common-success']//*[@id='content']");
    private final By changAddressSuccessMsg = By.xpath("//*[contains(@class,'alert-success')]");


    public CheckoutPage enterFirstName(String firstName) {
        sendText(firstNameField, firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        sendText(lastNameField, lastName);
        return this;
    }

    public CheckoutPage enterAddress(String address) {
        sendText(addressField, address);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        sendText(cityField, city);
        return this;
    }

    public CheckoutPage enterPostCode(String postCode) {
        sendText(postCodeField, postCode);
        return this;
    }

    public CheckoutPage selectCountry() {
        scrollByVisibleElement(countryDropDown);
        Select select =new Select(driver.findElement(countryDropDown));
        select.selectByValue("63");
        return this;
    }

    public CheckoutPage selectState() {
        scrollByVisibleElement(stateDropDown);
        Select select =new Select(driver.findElement(stateDropDown));
        select.selectByValue("1006");

        return this;
    }

    public CheckoutPage clickContinue() {
        scrollByVisibleElement(continueBtn);
        clickElement(continueBtn);
        return this;
    }

    public CheckoutPage clickChooseShippingMethod() {
        clickElement(shippingMethodChooseBtn);
        return this;
    }

    public CheckoutPage chooseShippingMethodOption() {
        clickElement(shippingMethodOption);
        return this;
    }

    public CheckoutPage clickShippingMethodContinueBtn() {
        clickElement(shippingMethodContinueBtn);
        return this;
    }

    public CheckoutPage clickChoosePaymentMethod() {
        clickElement(paymentMethodChooseBtn);
        return this;
    }

    public CheckoutPage choosePaymentMethodOption() {
        clickElement(paymentMethodOption);
        return this;
    }

    public CheckoutPage clickPaymentMethodContinueBtn() {
        clickElement(paymentMethodContinueBtn);
        return this;
    }

    public CheckoutPage clickConfirmOrderBtn() {
        scrollByVisibleElement(confirmOrderBtn);
        clickElement(confirmOrderBtn);
        return this;
    }

    public CheckoutPage fillPersonalData(String firstName, String lastName, String Address, String city, String postCode) {
        return enterFirstName(firstName)
                .enterLastName(lastName)
                .enterAddress(Address)
                .enterCity(city)
                .enterPostCode(postCode)
                .selectCountry()
                .selectState()
                .clickContinue();
    }

    public CheckoutPage chooseShippingMethod(){
        scrollByVisibleElement(shippingMethodChooseBtn);
       return clickChooseShippingMethod().chooseShippingMethodOption().clickShippingMethodContinueBtn();
    }
    public CheckoutPage choosePaymentMethod(){
        return clickChoosePaymentMethod().choosePaymentMethodOption().clickPaymentMethodContinueBtn();
    }
    public String getOrderSuccessMsg() {
        return getElementText(orderPlacedSuccessMsg);
    }

    public String getAddressSuccessMsg() {
        String msg=getElementText(changAddressSuccessMsg);
        //closing the snack bar
//        clickElement(By.className("btn-close"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(changAddressSuccessMsg));
        return msg;
    }

}
