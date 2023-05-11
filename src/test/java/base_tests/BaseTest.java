package base_tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseTest {
    public static WebDriver driver;
    public static HomePage homePage;

    public static ExtentReports extentReports;
    public static ExtentTest test;
    ExtentSparkReporter sparkReporter;

    ChromeOptions options = new ChromeOptions();
    private final String demoLink = "https://demo.nopcommerce.com/";


    @BeforeSuite
    public void setReports()
    {
        extentReports=new ExtentReports();
        sparkReporter=new ExtentSparkReporter("reports/extentReprt.html");
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().enableOfflineMode(true);
        sparkReporter.config().setDocumentTitle("seleniumDemo");
        sparkReporter.config().setReportName("Project Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


    }


    @BeforeTest
    @Parameters("BrowserType")
    public void setUp(String browserType)
    {
        if (browserType.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if (browserType.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }


        driver.manage().window().fullscreen();
        System.out.println("Befor test");
    }
    @BeforeClass
    public void goHome()
    {
        driver.navigate().to(demoLink);
    }

    @BeforeMethod
    public void creatTest(Method method) {
        System.out.println("Befor Method");
        test=extentReports.createTest(method.getName());

    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        System.out.println("After Method");
        System.out.println(result.getName());
        if (ITestResult.SUCCESS == result.getStatus()) {
            test.pass("test is pass");
        } else if (ITestResult.FAILURE == result.getStatus()) {
            var camera=(TakesScreenshot)driver;
             File screen = camera.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screen, new File("ScreenShots/"+result.getName()+".png"));
            test.fail("test fail");
        } else if (ITestResult.SKIP == result.getStatus()) {
            test.skip("test skipped");
        }

    }


    @AfterTest
    public void tearDown() {

        driver.quit();
        System.out.println("After Test");

    }
    @AfterSuite
    public void saveReport() throws IOException {
        extentReports.flush();
        Desktop.getDesktop().browse(new File("reports/extentReprt.html").toURI());
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
