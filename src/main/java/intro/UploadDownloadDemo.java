package intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadDownloadDemo extends BaseTest{

    @Test
    public void test1 (){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Jaka\\OneDrive\\Документы\\Barrels.doc");
        Helper.pause(3000);
    }
}
