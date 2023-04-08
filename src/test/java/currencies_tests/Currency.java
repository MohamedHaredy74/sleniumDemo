package currencies_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class Currency extends BaseTest{
    @Test
    public void testIfCurrencyChangedOverAllProducts()
    {
        //select Euro from currency dropDownList[Euro , US Dollar]
        homePage.selectCurrency(utils.Currency.EURO);
      List<String>currencyText= homePage.getCurrenciesOfProducts();
        SoftAssert softAssert=new SoftAssert();
      for (String text :currencyText)
      {
          softAssert.assertTrue(text.contains("€"));
          softAssert.assertAll();
          System.out.println( text);
      }
    }


}
