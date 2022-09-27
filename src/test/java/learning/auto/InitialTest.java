package learning.auto;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@Slf4j
public class InitialTest {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        log.info("Loading page");
        driver.get("https://applitools.com/request-demo/");
        log.info("Sending information");
        driver.findElement(By.name("FirstName")).sendKeys("Automation");
        driver.findElement(By.id("LastName")).sendKeys("Testing");
        driver.findElement(By.xpath("//input[contains(@placeholder,'Email')]")).sendKeys("alekx@testingcorp.com");
        synchronized (driver) { driver.wait(5000); }
        log.info("Test completed!");
        driver.close();
    }
}
