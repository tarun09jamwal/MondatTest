package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class TestSystemInformation extends BaseClass {
    @Test
    public void InformationAboutSystem() throws IOException {
        pageFactory.login().LoginButton();
        pageFactory.systemInformation().SystemInformationDetails();
    }
}
