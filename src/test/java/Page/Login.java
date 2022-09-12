package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;
    By login = By.xpath("//div[@class='buttons']/button");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginButton()
    {
        driver.findElement(login).click();
    }
}
