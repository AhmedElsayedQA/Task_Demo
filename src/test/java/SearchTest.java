import org.example.HeaderPage;
import org.example.SearchPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{
    HeaderPage headerPage;
    SearchPage searchPage;
    @Test(dataProvider = "validSearchInputs")
    public void searchWithValidInputs(String searchInput){
        headerPage=new HeaderPage(driver);
        searchPage=  headerPage.searchWith(searchInput);
        softAssert.assertEquals(searchPage.getSearchPageHeaderText(),"Search - "+searchInput,"Search is not working");
        softAssert.assertEquals(searchPage.getSearchResultsCount()>=1,true,"There are no search results");
        softAssert.assertAll();
    }
    @Test(dataProvider = "invalidSearchInputs")
    public void searchWithInvalidInputs(String searchInput){
        headerPage=new HeaderPage(driver);
        searchPage=  headerPage.searchWith(searchInput);
        softAssert.assertEquals(searchPage.getSearchPageHeaderText(),"Search - "+searchInput,"Search is not working");
        softAssert.assertEquals(searchPage.getSearchResultsCount()==0,true,"There are search results");
        softAssert.assertAll();

    }



    @DataProvider
    public Object[][] validSearchInputs(){
        return new Object[][]{
                {"Apple Screen"},
                {"Iphone"}
        };
    }
    @DataProvider
    public Object[][] invalidSearchInputs(){
        return new Object[][]{
                {"adsxczd"},
                {"$#@~%!"}
        };
    }
}
