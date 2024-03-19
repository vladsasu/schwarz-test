import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SchwarzTest {

    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\WORK\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://www.lidl.de/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='onetrust-accept-btn-handler']")));

        driver.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']")).click();

        driver.findElement(By.cssSelector("a[class='n-navigation__menu-nav--link n-header__icon-link'] span[class='m-icon m-icon--user']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='EmailOrPhone']")));

        driver.findElement(By.cssSelector("input[name='EmailOrPhone']")).sendKeys("vlad.mihai.sasu@gmail.com");

        driver.findElement(By.id("button_btn_submit_email")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='Password']")));

        driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("Schwarz123!");

        driver.findElement(By.id("button_submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button_logout_button")));

        String text = driver.findElement(By.id("button_logout_button")).getText();

        Assert.assertEquals("Login failed", "ABMELDEN", text);

        driver.quit();
    }
}
