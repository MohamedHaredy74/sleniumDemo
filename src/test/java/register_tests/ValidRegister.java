package register_tests;

import base_tests.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MyAccountPage;


public class ValidRegister extends BaseTest {
    String date= String.valueOf(System.currentTimeMillis());
    String mail="automation"+date+"@gmail.com";
    @Test
    public void registerWithValidCredentials()
    {
     homePage.clickRegisterIcon()
             .selectMAleGender()
             .setFirstName("test")
             .setLastName("automation")
             .setBirthDate("1","10","1999")
             .setEmailField(mail)
             .setPasswordField("Test!123")
             .setConfirmPasswordField("Test!123")
             .clickRegister();


        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(new MyAccountPage(driver).getRegisterMessageText().contains("Your registration completed"),"No Success msg Displayed");
        softAssert.assertTrue(new MyAccountPage(driver).getRegisterMessageColor().contains("rgba(76, 177, 124, 1)"),"Error with Message color");
        softAssert.assertAll();



    }
}
