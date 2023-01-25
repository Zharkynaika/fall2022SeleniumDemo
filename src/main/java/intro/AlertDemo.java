package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{
    @Test
    public void testAlert (){
        driver.get("https://demoqa.com/text-box");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(4000);
    }

    @Test
    public void testExplicitWaitAndAlert (){
        driver.get("https://demoqa.com/text-box");
        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testConfirmButton (){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("confirmButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement cancelText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(cancelText.getText(), "You selected Cancel");
    }

    @Test
    public void testPromptBox (){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("promtButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Zharkynai");
        alert.accept();
        WebElement nameText = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(nameText.getText(), "You entered Zharkynai");


    }
}
