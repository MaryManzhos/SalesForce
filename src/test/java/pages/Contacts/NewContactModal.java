package pages.Contacts;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class NewContactModal extends BasePage {

    public static final By BUTTON_SAVE = By.xpath("//button[@title='Save']");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewContactModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAVE));
        return this;
    }

    public NewContactModal createAccount(Contact contact) {
        new DropDown(driver, "Salutation").select(contact.getSalutation());
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write(contact.getMiddleName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Suffix").write(contact.getSuffix());
        new Input(driver, "Account Name").write(contact.getAccountName());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Reports To").write(contact.getReportsTo());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing State/Province").write(contact.getMailingStateProvince());
        new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZipPostalCode());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());
        return this;
    }

    public NewContactModal clickButtonSave() {
        driver.findElement(BUTTON_SAVE).click();
        return this;
    }
}
