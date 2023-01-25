package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XPassDemo {

    @Test
    public void xpathTest(){
        WebDriverManager.chromedriver().setup(); // Configure ChromeDriver to connect browser

        WebDriver driver = new ChromeDriver(); // Creating instance of ChromeDriver
        driver.manage().window().maximize(); // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Driver will wait 20 secs

        driver.get("https://demoqa.com/automation-practice-form");

        String name  = driver.findElement(By.tagName("h5")).getText();
        System.out.println(name);

        

        driver.close();
        driver.quit();
    }
}

