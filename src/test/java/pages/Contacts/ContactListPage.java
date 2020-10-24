package pages.Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ContactListPage extends BasePage {
    public static final String URL = "https://d2y0000004ceweay.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEW));
        return this;
    }

    public ContactListPage openPage() {
        driver.get(URL);
        return this;
    }

    public NewContactModal openModalNewAccount() {
        driver.findElement(BUTTON_NEW).click();
        return new NewContactModal(driver);
    }
}
