package Page;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    By UserEmail = By.xpath("//input[@id='Email']");
    By Password = By.xpath("//input[@id='Password']");
    By login = By.xpath("//div[@class='buttons']/button");


    public Login(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void LoginButton() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//Nop_Commerce.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");

        String email = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(UserEmail).clear();
        driver.findElement(Password).clear();
        wait.until(ExpectedConditions.elementToBeClickable(UserEmail));
        driver.findElement(UserEmail).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(Password));
        driver.findElement(Password).sendKeys(password);
        driver.findElement(login).click();
    }
}
