package pages.Accounts;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class AccountListPage extends BasePage {

    public static final String URL = "https://d2y0000004ceweay.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");
    public static final String ADDED_ACCOUNT = "//a[contains(@title, '%s')]";
    public static final String ICON_FOR_MENU = "//a[contains(@title, '')]/ancestor::tr//a[contains(@role,'button')]";
    public static final By MENU_ITEM_DELETE = By.xpath("//a[contains(@title, 'Delete')]");
    //public static final By LIST_OF_ACCOUNTS = By.xpath("//table[contains(@class, 'uiVirtualDataTable')]");
    public static final By NOTIFICATION = By.xpath("//div[contains(@class, 'forceToastMessage')]");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEW));
        return this;
    }

    public AccountListPage isDisplayNotification() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION));
        return this;
    }

    @Step("Open Account list page")
    public AccountListPage openPage() {
        driver.get(URL);
        return this;
    }

    @Step("Open New Account Modal")
    public NewAccountModal openModalNewAccount() {
        driver.findElement(BUTTON_NEW).click();
        return new NewAccountModal(driver);
    }

    public boolean isNewAccountAdded(Account account) {
        try {
            driver.findElement(By.xpath(String.format(ADDED_ACCOUNT, account.getAccountName())));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Step("Open Delete Account Modal")
    public DeleteAccountModal openDeleteAccountModal(Account account) {
        driver.findElement(By.xpath(String.format(ICON_FOR_MENU, account.getAccountName()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MENU_ITEM_DELETE));
        wait.until(ExpectedConditions.elementToBeClickable(MENU_ITEM_DELETE));
        driver.findElement(MENU_ITEM_DELETE).click();
        return new DeleteAccountModal(driver);
    }

}
