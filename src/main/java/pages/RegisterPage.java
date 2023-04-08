package pages;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class RegisterPage {
    private WebDriver driver;
   public RegisterPage(WebDriver driver)
   {
       this.driver=driver;
   }



    private By maleGender=By.id("gender-male");
    private By femaleGender=By.id("gender-female");
    private By firstName=By.id("FirstName");
    private By lastName=By.id("LastName");
    private By emailField=By.id("Email");
    private By birthDataDay=By.name("DateOfBirthDay");
    private By birthDataMonth=By.name("DateOfBirthMonth");
    private By birthDataYear=By.name("DateOfBirthYear");
    private By passwordField=By.id("Password");
    private By confirmPasswordField=By.id("ConfirmPassword");
    private By registerButton=By.id("register-button");


    public RegisterPage selectMAleGender()
    {
        driver.findElement(maleGender).click();
        return this;
    }
    public RegisterPage selectFemaleGender()
    {
        driver.findElement(femaleGender).click();
        return this;
    }
    public RegisterPage setFirstName(String name)
    {
        driver.findElement(firstName).sendKeys(name);
    return this;
    }
    public RegisterPage setLastName(String name)
    {
        driver.findElement(lastName).sendKeys(name);
    return this;
    }
    @Contract("_ -> new")
    private @NotNull Select getDropDownList(By locator)
    {return new Select(driver.findElement(locator));}
    public RegisterPage setBirthDate(String day ,String month ,String year)
    {
        getDropDownList(birthDataDay).selectByValue(day);
        getDropDownList(birthDataMonth).selectByValue(month);
        getDropDownList(birthDataYear).selectByValue(year);
        return this;
    }
    public RegisterPage setEmailField(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    return this;
    }
    public RegisterPage setPasswordField(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public RegisterPage setConfirmPasswordField(String password)
    {
        driver.findElement(confirmPasswordField).sendKeys(password);
    return this;
    }

    public MyAccountPage clickRegister()
    {
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }









}
