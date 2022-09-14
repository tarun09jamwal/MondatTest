package Test;

import Page.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseClass {
    static WebDriver driver;
    public static PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public static void Setup(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void Logout() {
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        driver.close();
    }

}