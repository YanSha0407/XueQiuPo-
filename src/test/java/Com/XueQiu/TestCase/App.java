package Com.XueQiu.TestCase;

import Com.XueQiu.PO.BasePage;
import Com.XueQiu.PO.SearchPage;
import Com.XueQiu.PO.StockPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {
    public  static void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
   public static SearchPage toSearch() throws InterruptedException {
       Thread.sleep(5000);
       By by =  By.id("com.xueqiu.android:id/tv_search");
       findElement(by).click();
       return new SearchPage();
   }

   public static StockPage toStock(){
        By by = By.xpath("//*[contains(@resource-id, 'tab_name') and @text='自选']");
//       @resource-id = 'com.xueqiu.android:id/tab_name'
        findElement(by).click();
        By by1 = By.id("com.xueqiu.android:id/page_type_stock");
       findElement(by1).click();
        return new StockPage();
   }
}
