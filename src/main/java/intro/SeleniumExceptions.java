package intro;

import org.apache.commons.compress.harmony.unpack200.bytecode.ExceptionsAttribute;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void noSuchElementExceptionTest() {
        // NoSuchElementException

        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName1")).sendKeys("Hello world!");
    }

    @Test
    public void noSuchWindowExceptionTest(){
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("Hello");
    }

    @Test
    public void noSuchFrameExceptionTest(){
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertExceptionTest(){
        browserHelper.openURL("https://demoqa.com/text-box");
        alertHelper.acceptAlert();
    }

    @Test
    public void invalidSelectionExceptionTest(){
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("//*[@id='userName'])[2]"));
    }

    @Test
    public void noSuchSessionExceptionTest(){
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceExceptionTest(){
        browserHelper.openURL("https://amazon.com");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();
            }
        }
    }

    @Test
    public void timeOutExceptionTest(){
        browserHelper.openURL("https://demoqa.com/text-box");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();
        }

    @Test
    public void test1() {
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Nuta");
    }

    @Test
    public void ElementNotIteractableException(){
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).sendKeys("saas");
       // driver.findElement(By.id("noRadio")).click();
    }

    @Test
    public void ElementNotIteractableException2(){
        browserHelper.openURL("https://demoqa.com/radio-button");
          driver.findElement(By.id("noRadio")).click();
    }

    @Test
    public void ElementClickInterceptedException(){
        browserHelper.openURL("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
//        Helper.pause(3000);
//        driver.findElement(By.xpath("//a[text()='GOT IT']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }

    @Test
    public void elementNotInteractableException(){
        driver.get("https://www.etsy.com/");
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin']"));
        loginButton.click();
        Helper.pause(2000);
        WebElement careersLink = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        careersLink.click(); //org.openqa.selenium.ElementNotInteractableException: element not interactable
    }
}
