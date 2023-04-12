package base_tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected ExtentReports extentReports;
    ExtentSparkReporter sparkReporter;
    ExtentTest test;
    ChromeOptions options = new ChromeOptions();
    private final String demoLink = "https://demo.nopcommerce.com/";


    @BeforeSuite
    public void setReports()
    {
        extentReports=new ExtentReports();
        sparkReporter=new ExtentSparkReporter("reports/extentReprt.html");
        extentReports.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void saveReport() throws IOException {
        extentReports.flush();
        Desktop.getDesktop().browse(new File("reports/extentReprt.html").toURI());
    }

    @BeforeClass
    public void goHome()
    {
        WebDriverManager.chromedriver().setup();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().fullscreen();
        homePage = new HomePage(driver);
        driver.navigate().to(demoLink);
        System.out.println("befor test");
    }





//    @BeforeMethod
//    public void print(Method method)
//    {
//        System.out.println("befor Method");
//        System.out.println(method.getName());
//
//
//    }
    @AfterMethod
    public void print2(ITestResult result)
    {
        System.out.println("After Method");
        System.out.println(result.getName());
        test=extentReports.createTest(result.getName());
        if (ITestResult.SUCCESS== result.getStatus())
        {
            test.pass("test is pass");
        } else if (ITestResult.FAILURE== result.getStatus())
        {
            test.fail("test fail");
        } else if (ITestResult.SKIP==result.getStatus()) {
            test.skip("test skipped");
        }


    }

    @AfterClass
    public void tearDown() {

        driver.quit();

    }


}























//@AfterMethod
//    public void takeScreenOnFailure(ITestResult result) throws IOException {
//
//        if (ITestResult.FAILURE== result.getStatus())
//        {
//            var camera=(TakesScreenshot)driver;
//             File screen = camera.getScreenshotAs(OutputType.FILE);
//            FileHandler.copy(screen, new File("screenshots.png"));
//        }
//    }
//


//
// extentReports=new ExtentReports();
//         sparkReporter=new ExtentSparkReporter("reports/SparkReport.html");
//         extentReports.attachReporter(sparkReporter);
