import com.opencart.web.LoginPage;
import com.opencart.web.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTest extends BaseTest{
    Random random=new Random();
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @BeforeMethod
    public void setUP(){
        driver.navigate().to("https://demo.opencart.com/en-gb?route=account/login");
        loginPage=new LoginPage(driver);
    }
    @Test(dataProvider = "validCredentials")
    public void loginWithValidCredentials(String email ,String password) throws InterruptedException {
        myAccountPage=loginPage.loginWith(email,password);
        softAssert.assertEquals(myAccountPage.isUserLoggedIn(),true,"User is not logged in");
        Thread.sleep(3000);
        myAccountPage.logout();
        Thread.sleep(3000);
        softAssert.assertAll();
    }
    @Test(dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String email ,String password) throws InterruptedException {
        myAccountPage=loginPage.loginWith(email,password);
        Thread.sleep(3000);
        softAssert.assertEquals(myAccountPage.isUserLoggedIn(),false,"User is logged in");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] validCredentials(){
        return new Object[][]{
                {"email1@gmail.com","12345678"},
                {"email3@gmail.com","password"}
        };
    }
    @DataProvider
    public Object[][] invalidCredentials(){
        return new Object[][]{
                {"email"+random.nextInt()+"@gmail.com","Password"},
                {"email1@gmail.com","wrongPassword"}
        };
    }
}
