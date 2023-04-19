package pages;


import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }
    private By successRegisterMessage = By.xpath("//div[@class='result']");
    private By myAccountTab = By.xpath("//a[@class='ico-account']");



    public String getRegisterMessageText() {
        return driver.findElement(successRegisterMessage).getText();
    }

    public String getRegisterMessageColor() {
        return driver.findElement(successRegisterMessage).getCssValue("color");
    }

    public String getURL() {
        return driver.getPageSource();
    }

    public boolean isMyAccountDisplayed() {
        return driver.findElement(myAccountTab).isDisplayed();
    }





    private @NotNull Select getDropDownList(By locator) {
        return new Select(driver.findElement(locator));
    }




    }






