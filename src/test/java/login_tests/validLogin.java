package login_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;



public class validLogin extends BaseTest {
    private String validEmail="automation@gmail.com";
    private String validPassword="Test!123";
    HomePage homePage=new HomePage(driver);
    @Test
    public void loginWithValidCredentials()
    {
      homePage.clickLoginIcon()
              .setEmailField(validEmail)
              .setPasswordField(validPassword)
              .clickLoginButton();
    }
}
