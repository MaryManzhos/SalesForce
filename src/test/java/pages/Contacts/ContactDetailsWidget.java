package pages.Contacts;

import elements.Fields;
import io.qameta.allure.Step;
import models.Account;
import models.AccountFields;
import models.Contact;
import models.ContactFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.Utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactDetailsWidget extends BasePage {

    Utils utils = new Utils();

    ContactFields contactFields;

    public static final By TAB_DETAILS = By.xpath("//a[contains(@data-label,'Details')]");
    public static final By LOCATOR = By.xpath("//span[contains(text(),'Created By')]");

    public ContactDetailsWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactDetailsWidget isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR));
        return this;
    }

    @Step("Go to tab Account Details")
    public ContactDetailsWidget goToTabDetails() {
        driver.findElement(TAB_DETAILS).click();
        return this;
    }

    public ContactFields getContactDetails() {

        contactFields = new ContactFields();

        contactFields.setName(new Fields(driver,"Name").getInformationName());
        contactFields.setAccountName(new Fields(driver, "Account Name").getInformationLink());
        contactFields.setTitle(new Fields(driver,"Title").getInformationText());
        contactFields.setEmail(new Fields(driver,"Email").getInformationLink());
        contactFields.setPhone(new Fields(driver, "Phone").getInformationText());
        contactFields.setMobile(new Fields(driver, "Mobile").getInformationText());
        contactFields.setReportsTo(new Fields(driver, "Reports To").getInformationSpan());
        contactFields.setDepartment(new Fields(driver, "Department").getInformationText());
        contactFields.setFax(new Fields(driver, "Fax").getInformationText());
        contactFields.setMailingAddress(new Fields(driver, "Mailing Address").getInformationAddressLink());

        return contactFields;
    }

    @Step("Validate created account")
    public void validateContactDetails(ContactFields contactFields, Contact contact) {

        String name = utils.convertName(contact.getSalutation(),contact.getFirstName(),contact.getMiddleName(),contact.getLastName(),contact.getSuffix());
        assertEquals(contactFields.getName(), name);
        assertEquals(contactFields.getAccountName(), contact.getAccountName());
        assertEquals(contactFields.getTitle(), contact.getTitle());
        assertEquals(contactFields.getEmail(), contact.getEmail());
        assertEquals(contactFields.getPhone(), contact.getPhone());
        assertEquals(contactFields.getMobile(), contact.getMobile());
        assertEquals(contactFields.getReportsTo(), contact.getReportsTo());
        assertEquals(contactFields.getDepartment(), contact.getDepartment());
        assertEquals(contactFields.getFax(), contact.getFax());

        String mailingAddress = utils.convertAddress(contact.getMailingCity(), contact.getMailingStateProvince(), contact.getMailingZipPostalCode());
        assertTrue(utils.isExistElementInList(contactFields.getMailingAddress(), contact.getMailingStreet()));
        assertTrue(utils.isExistElementInList(contactFields.getMailingAddress(), mailingAddress));
        assertTrue(utils.isExistElementInList(contactFields.getMailingAddress(), contact.getMailingCountry()));
    }
}
