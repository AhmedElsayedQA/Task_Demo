package org.example;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void visibilityWait(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        highlightAndScreenshotElement(element);
    }
    @Step("-Click Element ")

    public void clickElement(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        highlightAndScreenshotElement(element);
    }
    @Step("-Send Text")
    public void sendText(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        highlightAndScreenshotElement(element);
    }
    @Step("-get element Text")

    public String getElementText(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        highlightAndScreenshotElement(element);
        return element.getText();
    }
    @Step("-scroll By Visible Element")

    public void scrollByVisibleElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element=driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView();",element );
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        highlightAndScreenshotElement(element);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

    public void highlightAndScreenshotElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='7px groove green'", element);
        saveScreenshotPNG();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
    }

}

