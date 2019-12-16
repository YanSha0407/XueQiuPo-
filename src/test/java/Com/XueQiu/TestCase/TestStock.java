package Com.XueQiu.TestCase;

import Com.XueQiu.PO.StockPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestStock {
    private static StockPage stockPage;
    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
         App.setUp();
         stockPage = App.toStock();
    }

    @Test
    @Order(100)
    public void addDefaultStock(){
        if (stockPage.getStockCount().size() > 0){
            stockPage.deleteAll();// 先清空默认股票
        }
        assertThat(stockPage.addDefaultSelectedStocks().getStockCount().size(), greaterThanOrEqualTo(6));
    }

    @Test
    @Order(200)
    public void goStock() throws InterruptedException {
          assertThat(stockPage.addStock(),equalTo(Boolean.TRUE));
    }
    @AfterAll
    public static void afterAll(){

    }
}
