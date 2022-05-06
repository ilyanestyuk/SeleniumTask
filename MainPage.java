import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By optTorgButton = By.xpath("//span[contains(text(),'Оптовая торговля')]");

    public MainPage clickSection() {
        driver.findElement(optTorgButton).click();
        return new MainPage(driver);
    }
}
