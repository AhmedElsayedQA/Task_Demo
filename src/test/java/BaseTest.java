import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class  BaseTest {
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }
    @BeforeClass
    void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.opencart.com/");
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    @AfterMethod
    void afterMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
        saveScreenshotPNG();
       }
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }

}
