package com.opencart.web;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Page{

    public SearchPage(WebDriver driver){
        super(driver);
    }
    private final By searchPageHeaderText=By.xpath("//div[@id='content']/h1");
    private final By searchResults=By.xpath("//div[@class='col mb-3']");
    private final By elementPrice=By.className("price-new");


    @Step("Get Search Page Header")
    public String getSearchPageHeaderText(){
        return getElementText(searchPageHeaderText);
    }

    @Step("Click on search result")
    public ProductPage clickSearchResult(){
        By locator=By.xpath("(//div[@class='product-thumb'])[1]");
        scrollByVisibleElement(locator);
        clickElement(locator);
        return new ProductPage(driver);
    }
    @Step("Get search Result Count")
    public int getSearchResultsCount(){
        visibilityWait(searchPageHeaderText);
       return driver.findElements(searchResults).size();
    }
}
