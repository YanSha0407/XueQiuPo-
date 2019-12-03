package Com.XueQiu.TestCase;

import Com.XueQiu.PO.SearchPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class TestSearch {
    public static SearchPage searchPage;


    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        App.setUp();
    }
    @Before
    public void before() throws InterruptedException {
        searchPage = App.toSearch();
    }
    @Parameterized.Parameters
    public static Object[][] data(){
          return new Object[][]{
                  {"pdd",34.0},
                  {"xiaomi",40.0},
                  {"alibaba",150.0},
                  {"jd",100.0}
          } ;
    }
    @Parameterized.Parameter(0)
    public String stockName;
    @Parameterized.Parameter(1)
    public Double stockPrice;
    @Test
    public void search() throws InterruptedException {
         assertThat(searchPage.search(stockName).getCurrentStocks(),
                 greaterThanOrEqualTo(stockPrice.floatValue())) ;

    }
    @After
    public  void after(){
        searchPage.backSearch();
    }
    @AfterClass
    public static void afterClass(){

    }
}
