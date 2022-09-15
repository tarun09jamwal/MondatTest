package Test;

import Page.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
    static WebDriver driver;
    protected static PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public static void Setup(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            String Node = "http://10.20.20.109:4444/wd/hub";
            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setBrowserName("chrome");
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.get("https://admin-demo.nopcommerce.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("Firefox") ) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
//            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            String Node = "http://10.20.20.109:4444/wd/hub";
            DesiredCapabilities cap = new DesiredCapabilities();
//            cap.setBrowserName("firefox");
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.get("https://admin-demo.nopcommerce.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            pageFactory = new PageFactory(driver);

        }
    }

    @AfterClass
    public static void Logout() {
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        driver.close();
    }

}