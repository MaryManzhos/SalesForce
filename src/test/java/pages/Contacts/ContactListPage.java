package pages.Contacts;

import io.qameta.allure.Step;
import models.Account;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.Modals.ContextMenuInGrid;

public class ContactListPage extends BasePage {

    public static final String URL = "https://d2y0000004ceweay.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");
    public static final String ADDED_CONTACT = "//a[contains(@title, '%s')]";
    public static final String ICON_FOR_MENU = "//a[contains(@title, '%s')]/ancestor::tr//a[contains(@role,'button')]";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage isPageOpened() {
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

    public boolean isNewContactAdded(Contact contact) {
        try {
            driver.findElement(By.xpath(String.format(ADDED_CONTACT, contact.getAccountName())));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Step("Open context menu in grid Contact")
    public ContextMenuInGrid openContextMenuInGrid(Contact contact) {
        driver.findElement(By.xpath(String.format(ICON_FOR_MENU, contact.getAccountName()))).click();
        return new ContextMenuInGrid(driver);
    }

}
