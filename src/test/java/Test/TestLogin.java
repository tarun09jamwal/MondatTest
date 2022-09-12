package Test;

import org.testng.annotations.Test;

public class TestLogin extends BaseClass
{
    @Test
    public void TestLoginAdmin()
    {
        pageFactory.login().LoginButton();
    }
}
