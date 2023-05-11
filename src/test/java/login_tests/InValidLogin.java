package login_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class InValidLogin extends BaseTest {



    @Test(groups = "regression")
    public void loginWithInvalidEmailAndPassword1()
    {
       // test= extentReports.createTest("loginWithInvalidEmailAndPassword1");
        homePage=new HomePage(driver);
        var loginPage= homePage.clickLoginIcon()
                .setEmailField("dfrgtf@dfg.com")
                .setPasswordField("Test!123")
                .clickLoginExpectToFail();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(loginPage.getUnSuccessLoginMessageText().contains("Login was unsuccessful"),"Failed Login Assertions");
        softAssert.assertEquals(loginPage.getUnSuccessLoginMessageColorInHexFormat(),"#e4434b","Error With Color Assertion");
        softAssert.assertAll();
    }

}
