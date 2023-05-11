package search_tests;

import base_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import static utils.SkuKeyword.*;


public class searchWithSkuValue extends BaseTest {

    @Test(groups = "regression")
    public void searchWithSkuValue()
    {
        homePage=new HomePage(driver);
        homePage.searchWithSKU(SOUND_FORG_PRO11)
                        .clickSearchButton()
                                .clickOnPicture();
        Assert.assertTrue(homePage.getSkuValue().contains(SOUND_FORG_PRO11.toString()));
        System.out.println(homePage.getSkuValue());

    }




}
