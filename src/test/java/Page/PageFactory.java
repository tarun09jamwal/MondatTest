package Page;

import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class PageFactory {
    WebDriver driver;
    private Login login;
    private Orders orders;
    private GiftCards giftCards;
    private SystemInformation systemInformation;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public Login login() throws IOException {
        if (login == null) {
            login = new Login(driver);
        }
        return login;
    }

    public Orders orders() {
        if (orders == null) {
            orders = new Orders(driver);
        }
        return orders;
    }

    public GiftCards giftCards() {
        if (giftCards == null) {
            giftCards = new GiftCards(driver);
        }
        return giftCards;
    }

    public SystemInformation systemInformation() {
        if (systemInformation == null) {
            systemInformation = new SystemInformation(driver);
        }
        return systemInformation;
    }

}