package pages.Accounts;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.Modals.ContextMenuInGrid;

public class AccountListPage extends BasePage {

    public static final String URL = "https://d2y0000004ceweay.lightning.force.com/lightning/o/Account/list?filterName=Recent";
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");
    public static final String ADDED_ACCOUNT = "//a[contains(@title, '%s')]";
    public static final String ICON_FOR_MENU = "//a[contains(@title, '%s')]/ancestor::tr//a[contains(@role,'button')]";


    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_NEW));
        return this;
    }

    @Step("Open context menu in grid Account")
    public ContextMenuInGrid openContextMenuInGrid(Account account) {
        driver.findElement(By.xpath(String.format(ICON_FOR_MENU, account.getAccountName()))).click();
        return new ContextMenuInGrid(driver);
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

}
