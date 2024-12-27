package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page{
    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    private final By firstOrderID=By.xpath("//div[@class='table-responsive']//tbody//td[@class='text-end']");

    public int getFirstOrderID(){
        String firstOrder=getElementText(firstOrderID);
        return Integer.parseInt(firstOrder.substring(1));
    }
}
