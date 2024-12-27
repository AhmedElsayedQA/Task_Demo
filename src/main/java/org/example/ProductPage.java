package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page{
    public ProductPage(WebDriver driver){
        super(driver);
    }
    private final By productName=By.xpath("//div[@class='col-sm']/h1");
    private final By addToCartButton=By.id("button-cart");
    private final By mediumSizeRadioButton=By.id("input-option-value-6");
    private final By largeSizeRadioButton=By.xpath("input-option-value-7");
    private final By checkbox3=By.id("input-option-value-10");
    private final By textField=By.id("input-option-208");
    private final By colorDropDownMenu=By.name("option[217]");
    private final By textAreaField=By.name("input-option-209");
    private final By uploadFileBtn=By.id("button-upload-222");
    private final By successSnackBar=By.xpath("//*[contains(@class,'alert-success')]");


    public String getProductName(){
        return getElementText(productName);
    }

    public ProductPage clickAddToCartBtn(){
        scrollByVisibleElement(driver.findElement(addToCartButton));
        clickElement(addToCartButton);
        return this;
    }

    public ProductPage clickMediumSizeRadioBtn(){
        clickElement(mediumSizeRadioButton);
        return this;
    }

    public ProductPage clickCheckbox3(){
        clickElement(checkbox3);
        return this;
    }
    public ProductPage selectBlueColor(){
        Select select =new Select(driver.findElement(colorDropDownMenu));
        select.selectByValue("3");
        return this;
    }

    public ProductPage enterText(String text){
        sendText(textField,text);
        return this;
    }
    public ProductPage enterTextArea(String text){
        sendText(textField,text);
        return this;
    }
    public ProductPage uploadFile(String filePath){
        sendText(uploadFileBtn,filePath);
        return this;
    }

    public String getSuccessMsg(){
        return getElementText(successSnackBar);
    }
}
