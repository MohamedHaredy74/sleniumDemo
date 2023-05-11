package register_tests;

import base_tests.BaseTest;
import data.RegisterData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.MyAccountPage;

import java.io.IOException;


public class ValidRegister extends BaseTest {
    String currentTime = String.valueOf(System.currentTimeMillis());
    String mail="automation"+ currentTime +"@gmail.com";
    @Test (priority = 1,groups = "smoke")
    public void registerWithValidCredentials()
    {
        //test= extentReports.createTest("registerWithValidCredentials");
        homePage=new HomePage(driver);
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
        softAssert.assertTrue(new MyAccountPage(driver).getRegisterMessageColor().contains("rgba(76, 177, 124, 1)"),"Error with Message color");
        softAssert.assertAll();

    }

    @Test (priority = 2,groups = "regression")
    public void registerWithValidData() throws IOException, ParseException {
        //test= extentReports.createTest("registerWithValidData");
        RegisterData data=new RegisterData();
        data.readData();
        homePage=new HomePage(driver);
        homePage.clickRegisterIcon()
                .selectMAleGender()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setBirthDate("1","10","1999")
                .setEmailField(data.email+ currentTime +"@gmail.com")
                .setPasswordField(data.password)
                .setConfirmPasswordField(data.password)
                .clickRegister();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(new MyAccountPage(driver).getRegisterMessageText().contains("Your registration completed"),"No Success msg Displayed");
        softAssert.assertAll();



    }
}
