package Com.XueQiu.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
public class StockPage extends BasePage {

    // 如果页面中没有有  加入自选股  按钮   com.xueqiu.android:id/add_to_portfolio_stock
    // 先取消 加入自选股中的所有股票
    // 编辑自选股按钮  com.xueqiu.android:id/edit_group
    // 全选  com.xueqiu.android:id/check_all
    // 取消关注  com.xueqiu.android:id/cancel_follow
    // 确定 com.xueqiu.android:id/md_buttonDefaultPositive
    // 完成 com.xueqiu.android:id/action_close

    // 获取股票数量
    public ArrayList<String> getStockCount(){
              By by = By.id("com.xueqiu.android:id/portfolio_stockName");
              ArrayList arrayList = new ArrayList();
              for (int i = 0;i<driver.findElements(by).size();i++ ){
                     WebElement web = (WebElement) driver.findElements(by).get(i);
                     arrayList.add(web.getText());
                     System.out.println("默认股票数 arrayList-----"+arrayList);
              }
              return arrayList;
    }

    public StockPage deleteAll(){
            By by1 = By.id("com.xueqiu.android:id/edit_group");
            findElement(by1).click();
            By by2 = By.id("com.xueqiu.android:id/check_all");
            findElement(by2).click();
            By by3 = By.id("com.xueqiu.android:id/cancel_follow");
            findElement(by3).click();
            By by4 = By.id("com.xueqiu.android:id/md_buttonDefaultPositive");
            findElement(by4).click();
            By by5 = By.id("com.xueqiu.android:id/action_close");
            findElement(by5).click();
            return this;
    }
    public StockPage addDefaultSelectedStocks(){
        findElement(By.id("com.xueqiu.android:id/add_to_portfolio_stock"));
        return this;
    }

    // 判断界面是否有加入自选股  按钮
    public Boolean addStock() throws InterruptedException {
        // 没有加自选按钮  先取消关注股票
        By by = By.id("com.xueqiu.android:id/add_to_portfolio_stock");
        System.out.println("加自选按钮  222222 ------"+driver.findElements(by));
        findElement(by).click();
        By by1 = By.id("com.xueqiu.android:id/action_search");
        findElement(by1).click();
        By by2 = By.id("com.xueqiu.android:id/search_input_text");
        findElement(by2).sendKeys("pdd");
        // //*[contains(@resource-id, 'tab_name') and @text='自选']"
        By by3 = By.xpath("//*[contains(@text,'拼多多')]");
        findElement(by3).click();
        By by5 = By.xpath("//*[contains(@text,'加自选')]");
        if(driver.findElements(by5).size() > 0){
            findElement(by5).click();
            By by6 = By.id("com.xueqiu.android:id/action_close");
            findElement(by6).click();
            return true;
        }
        else {
            return false;
        }
    }
    // 如果页面中有加入自选股 按钮 com.xueqiu.android:id/add_to_portfolio_stock
    //点击加入自选股
    // 断言股票数据 是否加入成功
    // 点击搜索按钮
    // 点击加自选 按钮  com.xueqiu.android:id/follow_btn
    // 如果股票已被添加 则显示已添加 按钮 未被添加 显示加自选
    // 点击取消按钮 com.xueqiu.android:id/action_close
    // 断言股票是否加入成功
}
