package intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

   WebDriver driver;
   BrowserHelper browserHelper;
   AlertHelper alertHelper;

    @BeforeClass
    public  void testSettings () {
        WebDriverManager.edgedriver().setup();// Configure ChromeDriver to connect browser
        driver = new EdgeDriver(); // creating instance of chromedriver
        driver.manage().window().maximize(); //Duration/ Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// Driver will wait 20 second
        browserHelper =new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
