package Page;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GiftCards {
    WebDriver driver;
    List<WebElement> allElementDisplay ;
    By salesDropdown = By.linkText("Sales");
    By giftCars = By.xpath("//p[contains(text(),'Gift cards')]");
    By RecieverName = By.xpath("//input[@id='RecipientName']");
    By SendName = By.xpath("//button[@id='search-giftcards']");


    public GiftCards(WebDriver driver) {
        this.driver = driver;
    }

    public void UserGiftCards() {
        driver.findElement(salesDropdown).click();
        driver.findElement(giftCars).click();
        driver.findElement(RecieverName).sendKeys("Brenda Lindgren");
        driver.findElement(SendName).click();
        String actual = driver.findElement(By.xpath("//td[contains(text(),'Brenda Lindgren')]")).getText();
        Assert.isTrue(actual.equals("Brenda Lindgren"), "Expected result does not match with actual result");
    }

    public void MenuListItem() {
        allElementDisplay = driver.findElements(By.xpath("//div[@class='os-content']"));
        for(WebElement allElements:allElementDisplay)
        {
            String StrLinkText=allElements.getText();
            System.out.println(StrLinkText);
        }
    }
}
