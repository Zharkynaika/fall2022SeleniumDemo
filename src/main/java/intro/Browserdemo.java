package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Browserdemo extends BaseTest{

    @Test
    public void test(){
    browserHelper.openURL("https://demoqa.com/browser-windows");
    WebElement newTab = driver.findElement(By.id("tabButton"));
    newTab.click();
    Helper.pause(3000);
    browserHelper.switchToWindow(1);
    Helper.pause(3000);
    browserHelper.switchToParent();
    Helper.pause(3000);
    }

}
