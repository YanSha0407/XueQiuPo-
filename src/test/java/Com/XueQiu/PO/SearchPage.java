package Com.XueQiu.PO;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    public SearchPage search(String keyword) throws InterruptedException {
        By by = By.id("search_input_text");
        findElement(by).sendKeys(keyword);
        By by1 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]");
        findElement(by1).click();
        By by2 = by.id("com.xueqiu.android:id/stock_layout");
        findElement(by2).click();
        return this;
    }
    public Float getCurrentStocks(){
         By by = By.id("com.xueqiu.android:id/stock_current_price");
         return Float.valueOf(findElement(by).getText());
    }

    public void backSearch(){
        driver.navigate().back();
        By by = By.id("com.xueqiu.android:id/action_close");
        findElement(by).click();
    }
}
