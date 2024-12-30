import org.example.HeaderPage;
import org.example.RegisterPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegisterTest extends BaseTest{
    RegisterPage registerPage;
    Random random=new Random();


    @Test(dataProvider = "registerUserDataProvider")
    public void registerNewUser(String firstName,String lastName,String email,String password) throws InterruptedException {
        driver.navigate().to("https://demo.opencart.com/en-gb?route=account/register");
        registerPage=new RegisterPage(driver);
        registerPage.registerWith(firstName,lastName,email,password);
        softAssert.assertEquals(registerPage.getSuccessMsg(),"Your Account Has Been Created!","User is not registered");
        softAssert.assertAll();
    }
    @DataProvider
    public Object[][] registerUserDataProvider(){
        return new Object[][]{
                {"firstName","lastName","email"+random.nextInt()+"@gmail.com","Password"},
                {"firstName1","lastName2","email"+random.nextInt()+"@gmail.com","Password2"}
        };
    }
}
