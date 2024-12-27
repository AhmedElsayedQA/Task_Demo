package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page{

    public SearchPage(WebDriver driver){
        super(driver);
    }
    private final By searchPageHeaderText=By.xpath("//div[@id='content']/h1");

    public String getSearchPageHeaderText(){
        return getElementText(searchPageHeaderText);
    }

    public ProductPage clickSearchResult(String searchText){
        By searchLocator=By.xpath("//div[@class='product-thumb']//*[contains(text,'"+searchText+"')]");
        clickElement(searchLocator);
        return new ProductPage(driver);
    }
}
