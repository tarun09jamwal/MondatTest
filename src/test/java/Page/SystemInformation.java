package Page;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SystemInformation {
    WebDriver driver;
    WebDriverWait wait;

    By SystemDropDown = By.linkText("System");
    By SystemInformation = By.xpath("//p[contains(text(),'System information')]");
    By Templates = By.xpath("//p[contains(text(),'Templates')]");
    By Name = By.xpath("//input[@id='AddCategoryTemplate_Name']");
    By ViewPath = By.xpath("//input[@id='AddCategoryTemplate_ViewPath']");
    By DisplayOrder = By.xpath("(//span[@aria-label='Increase value'and @title='Increase value'])[1]");
    By AddNewRecords = By.xpath("//button[@id='addCategoryTemplate']");


    public SystemInformation(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void SystemInformationDetails() {
        driver.findElement(SystemDropDown).click();
        wait.until(ExpectedConditions.elementToBeClickable(SystemInformation));
        driver.findElement(SystemInformation).click();
        String actual = driver.findElement(By.xpath("//h1[contains(text(),'System information')]")).getText();
        Assert.isTrue(actual.equals("System information"), "Expected result does not match with actual result");
    }

    public void Templates() {
        driver.findElement(SystemDropDown).click();
        wait.until(ExpectedConditions.elementToBeClickable(Templates));
        driver.findElement(Templates).click();
        driver.findElement(Name).sendKeys("Tarun");
        wait.until(ExpectedConditions.elementToBeClickable(ViewPath));
        driver.findElement(ViewPath).sendKeys("Tarun/UserData/MyData");
        wait.until(ExpectedConditions.elementToBeClickable(DisplayOrder));
        driver.findElement(DisplayOrder).click();
        wait.until(ExpectedConditions.elementToBeClickable(AddNewRecords));
        driver.findElement(AddNewRecords).click();
        String actual = driver.findElement(By.xpath("//td[contains(text(),'Tarun/UserData/MyData')]")).getText();
        Assert.isTrue(actual.equals("Tarun/UserData/MyData"), "Expected result does not match with actual result");
    }
}
