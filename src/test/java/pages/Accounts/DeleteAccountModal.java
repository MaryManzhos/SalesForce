package pages.Accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class DeleteAccountModal extends BasePage {

    public static final By BUTTON_DELETE = By.xpath("//span[contains(text(), 'Delete')]");

    public DeleteAccountModal(WebDriver driver) {
        super(driver);
    }

    public DeleteAccountModal isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_DELETE));
        return this;
    }

    public AccountListPage clickButtonDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_DELETE));
        driver.findElement(BUTTON_DELETE).click();
        return new AccountListPage(driver);
    }
}
