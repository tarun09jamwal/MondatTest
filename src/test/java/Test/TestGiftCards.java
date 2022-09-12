package Test;

import org.testng.annotations.Test;

public class TestGiftCards extends BaseClass
{
    @Test
    public void GiftCards()
    {
        pageFactory.login().LoginButton();
        pageFactory.giftCards().UserGiftCards();
    }
}
