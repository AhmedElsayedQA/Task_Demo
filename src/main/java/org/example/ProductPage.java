package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By productName = By.xpath("//div[@class='col-sm']/h1");
    private final By addToCartButton = By.id("button-cart");
    private final By mediumSizeRadioButton = By.id("input-option-value-6");
    private final By largeSizeRadioButton = By.xpath("input-option-value-7");
    private final By checkbox3 = By.id("input-option-value-10");
    private final By textField = By.id("input-option-208");
    private final By colorDropDownMenu = By.name("option[217]");
    private final By textAreaField = By.id("input-option-209");
    private final By uploadFileBtn = By.id("button-upload-222");
    private final By uploadFile = By.name("option[222]");

    private final By successSnackBar = By.xpath("//*[contains(@class,'alert-success')]");

    public ProductPage clickAddToCartBtn() {
        scrollByVisibleElement(addToCartButton);
        clickElement(addToCartButton);
        return this;
    }

    public ProductPage clickMediumSizeRadioBtn() {
        scrollByVisibleElement(mediumSizeRadioButton);
        clickElement(mediumSizeRadioButton);
        return this;
    }

    public ProductPage clickCheckbox3() {
        scrollByVisibleElement(checkbox3);
        clickElement(checkbox3);
        return this;
    }

    public ProductPage selectBlueColor() {
        scrollByVisibleElement(colorDropDownMenu);
        Select select = new Select(driver.findElement(colorDropDownMenu));
        select.selectByValue("3");
        return this;
    }

    public ProductPage enterText(String text) {
        scrollByVisibleElement(textField);
        sendText(textField, text);
        return this;
    }

    public ProductPage enterTextArea(String text) {
        scrollByVisibleElement(textAreaField);
        sendText(textAreaField, text);
        return this;
    }

    public ProductPage uploadFile(String filePath) throws InterruptedException {
        scrollByVisibleElement(uploadFileBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //the element is hidden,so we set it to be visible as it throws element is not intractable exception
        js.executeScript("arguments[0].setAttribute('type', 'text');", driver.findElement(uploadFile));
        driver.findElement(uploadFile).sendKeys(filePath);
        return this;
    }

    public ProductPage addProductToCart(String text, String textArea, String filePath) throws InterruptedException {
        return clickMediumSizeRadioBtn()
                .clickCheckbox3()
                .enterText(text)
                .selectBlueColor()
                .enterTextArea(textArea)
                .uploadFile(filePath)
                .clickAddToCartBtn();
    }


    public String getSuccessMsg() {
        String msg = getElementText(successSnackBar);
        //closing the snack bar
        clickElement(By.className("btn-close"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(successSnackBar));
        return msg;
    }
}
