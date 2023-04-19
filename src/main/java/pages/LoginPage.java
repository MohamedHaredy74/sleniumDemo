package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;


public class LoginPage {
    private WebDriver driver;
   public LoginPage(WebDriver driver)
   {
       this.driver=driver;
   }


    private By emailField =By.id("Email");
    private By passwordField=By.id("Password");
    private By loginButton=By.xpath("//button[contains(text(),'Log')]");
    private By emailErrorMessage=By.id("Email-error");
    private By unSuccessLoginMessage = By.xpath("//div[contains(text(),'Login was unsuccessful')]");


    public LoginPage setEmailField(String email)
    {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public LoginPage setPasswordField(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public MyAccountPage clickLoginButton()
    {
        driver.findElement(loginButton).click();
        return new MyAccountPage(driver);
    }

    public LoginPage clickLoginExpectToFail()
    {
        driver.findElement(loginButton).click();
        return this;
    }
    public String getUnSuccessLoginMessageColorInHexFormat() {
        String color = Color.fromString(driver.findElement(unSuccessLoginMessage).getCssValue("color")).asHex();
        return color;
    }
    public String getUnSuccessLoginMessageText() {
        return driver.findElement(unSuccessLoginMessage).getText();
    }











}
