package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




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











}
