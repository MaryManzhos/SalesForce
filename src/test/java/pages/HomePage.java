package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public static final By TITLE_OF_WIDGET = By.cssSelector("[title='Quarterly Performance']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_OF_WIDGET));
        return this;
    }
}
