package Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class TestVerifyMenuList extends BaseClass
{
    @Test
    public void TestList() throws IOException {
        pageFactory.login().LoginButton();
        pageFactory.giftCards().MenuListItem();

    }
}
