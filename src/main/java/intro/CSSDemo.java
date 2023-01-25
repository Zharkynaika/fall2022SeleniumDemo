package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CSSDemo extends BaseTest{

    @Test
    public void cssTest1(){
        driver.get("https://www.amazon.com/");

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

//        WebElement clickSee = driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[12]"));
//        clickSee.click();

        WebElement allBrandsUl = driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]/ul"));

        List<WebElement> allBrandsLi = allBrandsUl.findElements(By.tagName("li"));
        for (WebElement brand: allBrandsLi) {
            if(brand.getText().equals("SAMSUNG")){
                WebElement clickBrand = brand.findElement(By.tagName("a"));
                clickBrand.click();
                break;

            }
        }
    }

}

