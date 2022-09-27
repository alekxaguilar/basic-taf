package webapp.linear;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class HomePageTest {
    public static void main(String[] args) throws InterruptedException {
        log.info("Setting up web driver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        log.info("Loading page");
        driver.get("https://demo.opencart.com/");  //if you are using local configuration http:127.0.0.1:8080
        log.info("Is displayed? : " + driver.findElement(By.id("carousel-banner-0")).isDisplayed());
        //Looking for image displayed in the carousel, using CSS Selector in chain
        String message = driver.findElement(By.cssSelector("#carousel-banner-0")).findElement(By.cssSelector(".carousel-item.active")).findElement(By.cssSelector("img")).getAttribute("alt").toString();
        log.info("Carousel image displayed:"+ message);
        synchronized (driver) { driver.wait(3000); }
        //Looking for image displayed in the carousel, using CSS Selector one time. (same as line 20)
        message = driver.findElement(By.cssSelector("#carousel-banner-0 .carousel-item.active img")).getAttribute("alt").toString();
        log.info("Image loaded:"+ message);
        log.info("Test completed!");
        driver.close();
    }
}