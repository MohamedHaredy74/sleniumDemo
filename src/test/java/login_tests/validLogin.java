package login_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;



public class validLogin extends BaseTest {
    private String validEmail="automation@gmail.com";
    private String validPassword="Test!123";

    @Test
    public void loginWithValidCredentials()
    {
        homePage=new HomePage(driver);
        var myAccountPage=
        homePage.clickLoginIcon()
              .setEmailField(validEmail)
              .setPasswordField(validPassword)
              .clickLoginButton();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(myAccountPage.isMyAccountDisplayed(),"Login Failed");
    }
}
