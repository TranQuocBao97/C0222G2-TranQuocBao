package program.thimodulebe.service;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Scraping {

    private final ChromeDriver driver;
    private static final String steamURL = "https://steamcommunity.com/market/listings/";
    private static final String CSGO = "730/";
    private static final String DOTA = "570/";


    public String scrapingPriceCSGO(String nameItem) throws Exception {
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        WebDriver driver = new ChromeDriver(options);
        driver.get(steamURL + CSGO + nameItem);
        Thread.sleep(12000);
        //---------------------------------------------------------------------------------
        //Tìm theo id (bao gồm cả số lượng order và giá order lớn nhất)
        WebElement findElement = driver.findElement(By.id("market_commodity_buyrequests"));
        //---------------------------------------------------------------------------------

        //---------------------------------------------------------------------------------
        //Tách số lượng order và giá theo class (đc mảng 2 biến số lương order và giá)
        List<WebElement> elementList = findElement.findElements(By.className("market_commodity_orders_header_promote"));
        if (elementList.size() == 0) {
            return "0.033";
        }
        System.out.println("price csgo can tim = " + elementList.get(1).getText().substring(1));
        //---------------------------------------------------------------------------------
        return elementList.get(1).getText().substring(1);
    }

    public String scrapingPriceDOTA(String nameItem) throws Exception {
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
        driver.get(steamURL + DOTA + nameItem);
        Thread.sleep(12000);
        //---------------------------------------------------------------------------------
        //Tìm theo id (bao gồm cả số lượng order và giá order lớn nhất)
        WebElement findElement = driver.findElement(By.id("market_commodity_buyrequests"));
        //---------------------------------------------------------------------------------


        //---------------------------------------------------------------------------------
        //Tách số lượng order và giá theo class (đc mảng 2 biến số lương order và giá)
        List<WebElement> elementList = findElement.findElements(By.className("market_commodity_orders_header_promote"));
        if (elementList.size() == 0) {
            return "0.033";
        }
        System.out.println("price dota2 can tim = " + elementList.get(1).getText().substring(1));
        //---------------------------------------------------------------------------------
        return elementList.get(1).getText().substring(1);
    }


//    public static void main(String[] args)  {
//
//        String url = "https://steamcommunity.com/market/listings/730/";
//        String name = "AK-47 | Ice Coaled (Field-Tested)";
//
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
//        driver.get(url + name);
////        try {
////            Thread.sleep(1000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
//
//        //Tìm theo id (bao gồm cả số lượng order và giá order lớn nhất)
//        WebElement findElement = driver.findElement(By.id("market_commodity_buyrequests"));
//        //Tách số lượng order và giá theo class (đc mảng 2 biến số lương order và giá)
//        List<WebElement> test1 = findElement.findElements(By.className("market_commodity_orders_header_promote"));
//        System.out.println("price can tim = " + test1.get(1).getText().substring(1));
//        String text2 = findElement.getText();
//        System.out.println("price test = " + text2);
//
//
////        Document doc = Jsoup.connect(url).get();
////        Element element = doc.getElementById("market_commodity_buyrequests");
////        System.out.println("test here: " + element.outerHtml());
////        System.out.println(doc);
//    }
}
