package Com.XueQiu.PO;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static AndroidDriver driver;
    public HashMap<String,String> alterBoxs;
    public static WebElement findElement(By by){
        try {
            System.out.println("已找到 --- findElement------"+by);
            return driver.findElement(by);
        }
        catch (Exception e){
            System.out.println("Exception-------"+by);
            handleAlter();
            return  driver.findElement(by);
        }
    }

    public static void handleAlter(){
        By tips = By.id("com.xueqiu.android:id/snb_tip_text");
        List<By> list = new ArrayList<>();
        list.add(tips);
        list.add(By.id("com.xueqiu.android:id/image_cancel"));
        list.add(By.id("com.xueqiu.android:id/ib_close"));
        list.add(By.id("com.xueqiu.android:id/tv_skip"));
        list.add(By.id("com.xueqiu.android:id/md_buttonDefaultNegative"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        list.forEach(alter ->{
            List<WebElement> ads = driver.findElements(alter);
            if (alter.equals(tips)){ // 下一步阴影遮罩
                System.out.println("snb_tip found");
                Dimension size = driver.manage().window().getSize();
                try {
                    if (driver.findElements(tips).size() > 0){
                        TouchAction action = new TouchAction(driver);
                        PointOption option = new PointOption();
                        action.tap(option.point(size.getWidth()/2,size.getHeight()/2)).perform(); // 点击屏幕中心点 取消遮罩
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    System.out.println("snb_tip clicked");
                }
            }else if(ads.size() > 0) {
                 ads.get(0).click(); // 点击其他系统弹窗
            }
        });
    }
    public static List<WebElement> findElements(By by){
        System.out.println("findElements-------"+by);
        return driver.findElements(by);
    }
    public void handleAlterByPageSource(){
           alterBoxs = new HashMap<String, String>();
           String xml = driver.getPageSource();
           System.out.println("xml--------"+xml);
    }

}
