package pages.Accounts;

import elements.Fields;
import io.qameta.allure.Step;
import models.Account;
import models.AccountFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountDetailsWidget extends BasePage {

    public static final By TAB_DETAILS = By.xpath("//a[contains(@data-label,'Details')]");
    public static final By LOCATOR = By.xpath("//span[contains(text(),'Created By')]");
    AccountFields accountFields;

    public AccountDetailsWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountDetailsWidget isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR));
        return this;
    }

    @Step("Go to tab Account Details")
    public AccountDetailsWidget goToTabDetails() {
        driver.findElement(TAB_DETAILS).click();
        return this;
    }

    public AccountFields getAccountDetails() {

        accountFields = new AccountFields();

        accountFields.setAccountName(new Fields(driver, "Account Name").getInformationText());
        accountFields.setType(new Fields(driver, "Type").getInformationText());
        accountFields.setWebsite(new Fields(driver, "Website").getInformationLink());
        accountFields.setDescription(new Fields(driver, "Description").getInformationText());
        accountFields.setParentAccount(new Fields(driver, "Parent Account").getInformationText());
        accountFields.setPhone(new Fields(driver, "Phone").getInformationLink());
        accountFields.setIndustry(new Fields(driver, "Industry").getInformationText());
        accountFields.setEmployees(new Fields(driver, "Employees").getInformationText());
        accountFields.setBillingAddressInformation(new Fields(driver, "Billing Address").getInformationAddressLink());
        accountFields.setShippingAddressInformation(new Fields(driver, "Shipping Address").getInformationAddressLink());

        return accountFields;
    }

    @Step("Validate created account")
    public void validateAccountDetails(AccountFields accountFields, Account account) {

        assertEquals(accountFields.getAccountName(), account.getAccountName());
        assertEquals(accountFields.getType(), account.getType());
        assertEquals(accountFields.getWebsite(), account.getWebsite());
        assertEquals(accountFields.getDescription(), account.getDescription());
        assertEquals(accountFields.getPhone(), account.getPhone());
        assertEquals(accountFields.getIndustry(), account.getIndustry());
        assertEquals(accountFields.getEmployees(), account.getEmployees());

        String billingAddress = convertAddress(account.getBillingCity(), account.getBillingStateProvince(), account.getBillingZipPostalCode());
        assertTrue(isExistElementInList(accountFields.getBillingAddressInformation(), account.getBillingStreet()));
        assertTrue(isExistElementInList(accountFields.getBillingAddressInformation(), billingAddress));
        assertTrue(isExistElementInList(accountFields.getBillingAddressInformation(), account.getBillingCountry()));

        String shippingAddress = convertAddress(account.getShippingCity(), account.getShippingStateProvince(), account.getShippingZipPostalCode());
        assertTrue(isExistElementInList(accountFields.getShippingAddressInformation(), account.getShippingStreet()));
        assertTrue(isExistElementInList(accountFields.getShippingAddressInformation(), shippingAddress));
        assertTrue(isExistElementInList(accountFields.getShippingAddressInformation(), account.getShippingCountry()));
    }

    public String convertAddress(String city, String state, String code) {
        return String.format(city + ", " + state + " " + code);
    }

    public boolean isExistElementInList(List<String> list, String str) {

        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }
}
