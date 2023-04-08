package search_tests;

import base_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class searchWithSkuValue extends BaseTest {


    HomePage homePage=new HomePage(driver);

    private String SkuKeyword="SCI_FAITH";//APPLE_CAM or SF_PRO_11 or SCI_FAITH
    @Test
    public void searchWithSkuValue()
    {
        homePage.setSearchField(SkuKeyword);
        homePage.clickSearchButton();
        homePage.clickOnPicture();
        Assert.assertTrue(homePage.getSkuValue().contains(SkuKeyword));
        System.out.println(homePage.getSkuValue());

    }




}
