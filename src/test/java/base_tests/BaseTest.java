package base_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;


import java.time.Duration;


public class BaseTest {
    protected   WebDriver driver;
   public HomePage homePage=null;

    private final String demoLink ="https://demo.nopcommerce.com/";

    @BeforeTest
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver =new ChromeDriver(options);
        driver.manage().window().fullscreen();
        homePage=new HomePage(driver);
        driver.navigate().to(demoLink);

    }

    @AfterTest
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
