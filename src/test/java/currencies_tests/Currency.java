package currencies_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import static utils.Currency.*;

import java.util.List;


public class Currency extends BaseTest{
    @Test
    public void testIfCurrencyChangedOverAllProducts()
    {
        homePage=new HomePage(driver);
        //select Euro from currency dropDownList[Euro , US Dollar]

        List<String>currencyText=homePage.selectCurrency(EURO)
                .getCurrenciesOfProducts();
        SoftAssert softAssert=new SoftAssert();
      for (String text :currencyText)
      {
          softAssert.assertFalse(text.contains("€"));//€
          softAssert.assertAll();
      }
    }


}
