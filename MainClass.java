import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) throws Exception {
        String path = "D:\\test";
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe"); //path to ChromeDriver
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://www.brestbakaleya.com/"); //link to a site

        MainPage mainPage = new MainPage(driver);
        OptPage optPage = new OptPage(driver);
        mainPage.clickSection();
        optPage.downloadPrice();
        TimeUnit.SECONDS.sleep(1);

        File price = new File(path+"\\Full_price_brestbakaleya.xls");

        if(price.exists()){
            FileInputStream file = new FileInputStream(price);
            HSSFWorkbook wb = new HSSFWorkbook(file);
            String result = wb.getSheetAt(0).getRow(5).getCell(0).getStringCellValue();
            System.out.printf("File exists! Search result is " + result);
            file.close();
        } else{
            System.out.printf("There is no file in the directory");
        }

    }
}
