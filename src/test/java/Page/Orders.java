package Page;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Orders {
    WebDriver driver;
    WebDriverWait wait;
    By salesDropdown = By.linkText("Sales");
    By ordersLink = By.xpath("//p[contains(text(),'Orders')]");
    By Date = By.xpath("//input[@id='StartDate']");
    By BillingEmail = By.xpath("//input[@id='BillingEmail']");
    By Search = By.xpath("//button[@id='search-orders']");
    By Logout = By.xpath("//a[contains(text(),'Logout')]");

    public Orders(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void Orders() {
        wait.until(ExpectedConditions.elementToBeClickable(salesDropdown));
        driver.findElement(salesDropdown).click();
        wait.until(ExpectedConditions.elementToBeClickable(ordersLink));
        driver.findElement(ordersLink).click();
        driver.findElement(Date).sendKeys("03/13/2017");
        driver.findElement(BillingEmail).sendKeys("victoria_victoria@nopCommerce.com");
        driver.findElement(Search).click();
        String actual = driver.findElement(By.xpath("//a[contains(text(),'victoria_victoria@nopCommerce.com')]")).getText();
        Assert.isTrue(actual.equals("victoria_victoria@nopCommerce.com"), "Expected result does not match with actual result");
        wait.until(ExpectedConditions.elementToBeClickable(Logout));

    }
}
