package login_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class InValidLogin extends BaseTest {

    @Test
    public void loginWithInvalidEmailAndPassword()
    {
        var myAccount= homePage.clickLoginIcon()
                .setEmailField("dfrgtf@dfg.com")
                .setPasswordField("Test!123")
                .clickLoginButton();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(myAccount.getUnSuccessLoginMessageText().contains("Login was unsuccessful"),"Login Message Assertion");
        softAssert.assertEquals(myAccount.getUnSuccessLoginMessageColorInHexFormat(),"#e4434b","Error With Color Assertion");
        softAssert.assertAll();
    }
}
