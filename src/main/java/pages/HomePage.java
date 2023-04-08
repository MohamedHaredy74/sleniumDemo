package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Currency;
import utils.SkuKeyword;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomePage {
    private  WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }



     // Element Locators
    private By registerIcon=By.xpath("//a[@class='ico-register']");
    private By loginIcon=By.xpath("//a[@class='ico-login']");
    private By priceItemForProducts = By.xpath("//span[@class='price actual-price']");
    private By currencyList = By.id("customerCurrency");
    private By productsTitle =By.xpath("//h2[@class='product-title']");
    private By searchField=By.id("small-searchterms");
    private By searchButton=By.xpath("//button[@class='button-1 search-box-button']");
    private By skuValueOfAppleCam=By.cssSelector(".additional-details .sku"); //mor dynamic
    private By searchResultItem=By.cssSelector(".search-results .picture");
    private By pageTitle=By.className("page-title");




    //important Arrays
    private List<String >TextOfProducts=new ArrayList<String>();
    private List<WebElement> elementList=new ArrayList<WebElement>();

    public RegisterPage clickRegisterIcon()
    {
        driver.findElement(registerIcon).click();
        return new RegisterPage(driver);
    }
    public LoginPage clickLoginIcon()
    {
        driver.findElement(loginIcon).click();
        return new LoginPage(driver);
    }
    private  Select getDropDownList(By locator)
    {return new Select(driver.findElement(locator));}
    public HomePage selectCurrency(Currency value) {
        getDropDownList(currencyList).selectByVisibleText(value.toString());
        return this;
    }

    public List<String > getCurrenciesOfProducts() {
        elementList = driver.findElements(priceItemForProducts);
        for (WebElement element : elementList) {
           String text= element.getText();
           TextOfProducts.add(text);
        }
        return TextOfProducts;
        }
        public HomePage setSearchField(String keyword)
        {
            driver.findElement(searchField).sendKeys(keyword);
            return this;
        }
    public HomePage searchWithSKU(SkuKeyword keyword)
    {
        driver.findElement(searchField).sendKeys(keyword.toString());
        return this;
    }
        public HomePage clickSearchButton()
        {
            driver.findElement(searchButton).click();
            return this;
        }

        public List<String > getProductsTextOfSearchResult() {
        elementList = driver.findElements(productsTitle);
        for (WebElement element : elementList) {
            String text= element.getText().toLowerCase();
            TextOfProducts.add(text);
        }
        return TextOfProducts;
    }
    public String getCurrentURL()
    {return driver.getCurrentUrl();}

    public String getSkuValue()
    {
        return driver.findElement(skuValueOfAppleCam).getText();
    }
    public void clickOnPicture()
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultItem));
        driver.findElement(searchResultItem).click();
    }


    public String getPageTitle()
    {return driver.findElement(pageTitle).getText();}




    }








