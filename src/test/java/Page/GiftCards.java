package Page;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCards
{
    WebDriver driver;
    By salesDropdown = By.xpath("(//li/a[@class='nav-link'])[14]");
    By giftCars = By.xpath("//p[contains(text(),'Gift cards')]");

    By RecieverName = By.xpath("//input[@id='RecipientName']");
    By SendName = By.xpath("//button[@id='search-giftcards']");
    By Recipiens = By.xpath("//td[contains(text(),'Brenda Lindgren')]");

    public GiftCards(WebDriver driver)
    {
        this.driver = driver;
    }
    public void UserGiftCards()
    {
        driver.findElement(salesDropdown).click();
        driver.findElement(giftCars).click();
        driver.findElement(RecieverName).sendKeys("Brenda Lindgren");
        driver.findElement(SendName).click();
        String actual = driver.findElement(By.xpath("//td[contains(text(),'Brenda Lindgren')]")).getText();
        Assert.isTrue(actual.equals("Brenda Lindgren"), "Expected result does not match with actual result");
        System.out.println(actual);
    }
}
