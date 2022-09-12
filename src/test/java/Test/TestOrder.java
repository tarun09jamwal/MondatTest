package Test;

import org.testng.annotations.Test;

public class TestOrder extends BaseClass
{
    @Test
    public void UserOrder()
    {
        pageFactory.login().LoginButton();
        pageFactory.orders().Orders();
    }
}
