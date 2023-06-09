package search_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class searchResultValidation  extends BaseTest {
    private String searchKeyword="laptop";

    @Test
    public void searchAndValidateResults()
    {
        homePage=new HomePage(driver);
        homePage.setSearchField(searchKeyword)
                        .clickSearchButton();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(homePage.getCurrentURL().contains(searchKeyword),"SearchKeyword Not Found");

       for(String title : homePage.getProductsTextOfSearchResult())
       {
           softAssert.assertTrue(title.contains(searchKeyword));
       }
       softAssert.assertAll();
    }




}
