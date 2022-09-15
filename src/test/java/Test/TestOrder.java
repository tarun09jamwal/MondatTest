package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class TestOrder extends BaseClass {
    @Test
    public void UserOrder() throws IOException {
        pageFactory.login().LoginButton();
        pageFactory.orders().Orders();
    }
}
