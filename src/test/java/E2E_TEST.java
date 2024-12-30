import org.example.*;
import org.testng.annotations.Test;

import java.util.Random;

public class E2E_TEST extends BaseTest {

    RegisterPage registerPage;
    HeaderPage headerPage;
    SearchPage searchPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    MyAccountPage myAccountPage;
    Random random=new Random();
    String searchWord="Apple Cinema 30";
    String firstName="firstName";
    String lastName="lastName";
    String filePath="https://demo.opencart.com/image/catalog/opencart-logo.png";

    @Test
    public void checkoutFLow() throws InterruptedException {
        driver.navigate().to("https://demo.opencart.com/en-gb?route=account/register");
        registerPage=new RegisterPage(driver);
        headerPage=new HeaderPage(driver);
        registerPage.registerWith(firstName,lastName,random.nextInt()+"@gmail.com","Password");
        softAssert.assertEquals(registerPage.getSuccessMsg().contains("Your Account Has Been Created!"),true,"User is not registered");
        searchPage=headerPage.searchWith(searchWord);
        softAssert.assertEquals(searchPage.getSearchPageHeaderText(),"Search - "+searchWord,"Search is not working");
        softAssert.assertEquals(searchPage.getSearchResultsCount()>=1,true,"There are no search results");
        productPage=searchPage.clickSearchResult();
        productPage.addProductToCart("test","test",filePath);
        softAssert.assertEquals(productPage.getSuccessMsg().contains("Success: You have added Apple Cinema 30"),true,"Item is not added to the cart");
        checkoutPage=headerPage.clickCheckoutBtn();
        checkoutPage.fillPersonalData("firstName","lastName","Agami","Alexandria","123456");
        softAssert.assertEquals(checkoutPage.getAddressSuccessMsg(),"Success: You have changed shipping address!","Address wasn't added");
        checkoutPage.chooseShippingMethod().choosePaymentMethod().clickConfirmOrderBtn();
        softAssert.assertEquals(checkoutPage.getOrderSuccessMsg().contains("Your order has been placed!"),true,"Order is not placed Successfully");
        myAccountPage=headerPage.clickMyAccountBtn().clickOrderHistoryBtn();
        System.out.println("Order ID is: "+myAccountPage.getFirstOrderID());
        softAssert.assertAll();

    }

}
