package base_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;


import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    private final String demoLink ="https://demo.nopcommerce.com/";

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver =new ChromeDriver(options);
        homePage=new HomePage(driver);
        driver.navigate().to(demoLink);
        driver.manage().window().fullscreen();

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }




//    public void takeScreenOnFailure(ITestResult result) throws IOException {
//        if (ITestResult.FAILURE== result.getStatus())
//        {
//            var camera=(TakesScreenshot)driver;
//            File screen = camera.getScreenshotAs(OutputType.FILE);
//            Files.copy(screen, new File("./screenshots/"+result.getName()+".png"));
//        }
//    }


}
