package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class TestGiftCards extends BaseClass {
    @Test
    public void GiftCards() throws IOException {
        pageFactory.login().LoginButton();
        pageFactory.giftCards().UserGiftCards();
    }
}
