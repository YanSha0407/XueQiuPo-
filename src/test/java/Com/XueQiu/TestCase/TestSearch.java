package Com.XueQiu.TestCase;

import Com.XueQiu.PO.SearchPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSearch {
    public static SearchPage searchPage;
    @BeforeAll
    public static void beforeClass() throws MalformedURLException {
        App.setUp();
        String xml = App.driver.getPageSource();
        System.out.println("xml--------"+xml);
    }
    @BeforeEach
    public void before() throws InterruptedException {
        searchPage = App.toSearch();
    }
    // junit 4 参数化
//    @Parameterized.Parameters
//    public static Object[][] data(){
//          return new Object[][]{
//                  {"pdd",34.0},
//                  {"xiaomi",40.0},
//                  {"alibaba",150.0},
//                  {"jd",100.0}
//          } ;
//    }
//    @Parameterized.Parameter(0)
//    public String stockName;
//    @Parameterized.Parameter(1)
//    public Double stockPrice;


    // junit5 参数化

    @Test
    public void search() throws InterruptedException {
//         assertThat(searchPage.search(stockName).getCurrentStocks(),
//                 greaterThanOrEqualTo(stockPrice.floatValue())) ;

    }
//    @ParameterizedTest
//    @MethodSource("data")
//    public void  addStock(String name, String code){
////          assertThat();
//    }
//    public  Stream<Arguments> data(){
//        return Stream.of(
//                arguments("pdd", "拼多多"),
//                arguments("jd", "京东")
//        );
//    }
    @AfterEach
    public  void after(){
        searchPage.backSearch();
    }
    @AfterAll
    public static void afterClass(){

    }
}
