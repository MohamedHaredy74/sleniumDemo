package login_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class InValidLogin extends BaseTest {
    HomePage homePage=new HomePage(driver);
    @Test
    public void loginWithInvalidEmailAndPassword()
    {
       var login= homePage.clickLoginIcon();
       login.setEmailField("sdfgfd@gmail.com");
       login.setPasswordField("654123");
       var myAccount=login.clickLoginButton();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(myAccount.getUnSuccessLoginMessageText().contains("Login was unsuccessful"),"Login Message Assertion");
        softAssert.assertEquals(myAccount.getUnSuccessLoginMessageColorInHexFormat(),"#e4434b","Error With Color Assertion");
        softAssert.assertAll();
    }
}