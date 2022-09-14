package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyTemplates extends BaseClass {
    @Test
    public void VerifyTemplates() throws IOException {
        pageFactory.login().LoginButton();
        pageFactory.systemInformation().Templates();
    }
}
