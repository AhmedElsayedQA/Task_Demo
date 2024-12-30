package com.opencart.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class MyAccountPage extends Page{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    private final By logoutBtn=By.xpath("(//*[contains(@class,'list-group')])[14]");
    private final By firstOrderID=By.xpath("//div[@class='table-responsive']//tbody//td[@class='text-end']");
    private final By continueBtn=By.xpath("//*[text()='Continue']");
    private final By myAccountTitle=By.xpath("//h2[text()='My Account']");
    public int getFirstOrderID(){
        String firstOrder=getElementText(firstOrderID);
        return Integer.parseInt(firstOrder.substring(1));
    }
    public boolean isUserLoggedIn(){
       return Objects.equals(getElementText(myAccountTitle), "My Account");
    }
    public void logout() {
        scrollByVisibleElement(logoutBtn);
        clickElement(logoutBtn);
        clickElement(continueBtn);
    }
}
