package Page;

import org.openqa.selenium.WebDriver;

public class PageFactory
{
    WebDriver driver;
    private Login login;
    private Orders orders;
    private GiftCards giftCards;

    public PageFactory(WebDriver driver)
    {
        this.driver = driver;
    }
    public Login login()
    {
        if(login ==null)
        {
            login = new Login(driver);
        }
        return login;
    }
    public Orders orders()
    {
        if(orders ==null)
        {
            orders = new Orders(driver);
        }
        return orders;
    }
    public GiftCards giftCards()
    {
        if(giftCards ==null)
        {
            giftCards = new GiftCards(driver);
        }
        return giftCards;
    }

}