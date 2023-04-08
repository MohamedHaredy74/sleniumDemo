package currencies_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.util.List;

public class Currency extends BaseTest{
    HomePage homePage=new HomePage(driver);

    @Test
    public void testIfCurrencyChangedOverAllProducts()
    {
        //select Euro from currency dropDownList[Euro , US Dollar]
        homePage.selectCurrency("Euro");
      List<String>currencyText= homePage.getCurrenciesOfProducts();
        SoftAssert softAssert=new SoftAssert();
      for (String  t :currencyText)
      {
          softAssert.assertTrue(t.contains("€"));
          softAssert.assertAll();
          System.out.println(t);
      }
    }


}
