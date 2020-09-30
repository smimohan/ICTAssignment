package Commons;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver = null;
    public static Config config;

    static {
        try {
            config = Config.ConfigReturn();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @BeforeTest
    public static WebDriver openBrowser(){
            String browser=config.get("BROWSER");
            String url=config.get("URL");

    switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);//launch browser
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                InternetExplorerOptions ieoptions = new InternetExplorerOptions(capabilities);
                driver = new InternetExplorerDriver(ieoptions);
                break;
        }
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(url);//navigate to url
        return driver;
    }
    @AfterTest
    public static void closebrowser( ) {
        driver.close();
    }

    public static String takeScreenshot(WebDriver driver, String name) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        String file = "ss" + random.nextInt(1000) + ".png";
        String fileName = System.getProperty("user.dir") + "\\report\\" + file;
        File destinationFile = new File(fileName);
        FileUtils.copyFile(screenshot, destinationFile);
        return file;
    }
    /*public static ExtentReports reports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void viewTestReport() throws UnknownHostException{
        String path = System.getProperty("user.dir");
        reports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("report//report.html");
        reports.setSystemInfo("Machine Name", InetAddress.getLocalHost().getHostName());
        reports.attachReporter(extentSparkReporter);
    }

    @AfterSuite
    public void report()
    {
        reports.flush();
    }*/
}


