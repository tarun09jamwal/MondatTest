package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class TestLogin extends BaseClass {
    @Test
    public void TestLoginAdmin() throws IOException {
        pageFactory.login().LoginButton();
    }
}
