package Com.XueQiu.TestCase;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public static AndroidDriver driver;
    public static WebElement findElement(By by){
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        try {
            System.out.println("findElement------"+by);
            return driver.findElement(by);
        }
        catch (Exception e){
//            List<By> list = new ArrayList<By>();
//            list.add(by);
//            list.add(by.xpath("dddd"));
//            for (int i = 0; i < list.size();i++){
//                By by1 = list.get(i);
            System.out.println("findElement  Exception------"+by);
                List<WebElement> ads = driver.findElements(by);
                if (ads.size() > 0){
                    ads.get(0).click();
//                }
            }
            return findElement(by);
        }
    }
}
