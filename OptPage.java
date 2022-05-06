import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OptPage {
    private WebDriver driver;
    public OptPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pricelist = By.xpath("//a[@href='../images/stories/prices/Full_price_brestbakaleya.xls']//img[@alt='excel']");

    public OptPage downloadPrice() {
        driver.findElement(pricelist).click();
        return new OptPage(driver);
    }


}
