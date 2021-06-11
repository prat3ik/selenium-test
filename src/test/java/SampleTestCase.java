import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTestCase {
    static WebDriver driver;

    @BeforeMethod
    public static void Before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.demoblaze.com/");
    }

    @Test(description="This test validates login functionality", priority=1)
    public void tests() throws InterruptedException {
        String username = "prat3ik";
        String pass = "12qw!@QW";
        driver.findElement(By.cssSelector("#login2")).click();

        WebElement form = driver.findElement(By.cssSelector("#logInModal .modal-content"));
        WebElement usernameTextField = form.findElement(By.cssSelector("input#loginusername"));
        usernameTextField.sendKeys(username);
        String getInputUsername = usernameTextField.getAttribute("value");
        Assert.assertEquals(getInputUsername, username+"1");

        WebElement passwordTextField = form.findElement(By.cssSelector("input#loginpassword"));
        passwordTextField.sendKeys(pass);
        String getPasswordUsername = passwordTextField.getAttribute("value");
        Assert.assertEquals(getPasswordUsername, pass);

        form.findElement(By.cssSelector("button")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
