package intro;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{

    @Test
    public void testSelect(){
        driver.get("https://demoqa.com/select-menu");

    }
}
