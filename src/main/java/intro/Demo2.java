package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Demo2 extends BaseTest{
    @Test
    public void cssTest1 (){
//        driver.get("https://www.amazon.com/");
         driver.findElement(By.id("//input[@id=\"nav-bb-search\"]")).sendKeys("iphone",Keys.ENTER);

        WebElement brandNameUL = driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul"));
        List<WebElement> brandNameLi = brandNameUL.findElements(By.tagName("li"));

        for (WebElement liName:brandNameLi) {
            if(liName.getText().equals("SUMSUNG")){
                WebElement linkBrand = liName.findElement(By.tagName("a"));
//                linkBrand.click();
                System.out.println(linkBrand.getText());
                break;
            }
        }


    }

}


