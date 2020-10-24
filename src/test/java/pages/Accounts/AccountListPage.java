package pages.Accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class AccountListPage extends BasePage {

    public static final String URL = "https://d2y0000004ceweay.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEW));
        return this;
    }

    public AccountListPage openPage() {
        driver.get(URL);
        return this;
    }

    public NewAccountModal openModalNewAccount() {
        driver.findElement(BUTTON_NEW).click();
        return new NewAccountModal(driver);
    }
}
