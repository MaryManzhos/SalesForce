package pages.Accounts;

import elements.DropDown;
import elements.Fields;
import elements.Input;
import elements.TextArea;
import models.Account;
import models.AccountFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import static org.testng.Assert.*;

public class AccountDetailsWidget extends BasePage {

    AccountFields accountFields;

    public static final By TAB_DETAILS = By.xpath("//a[contains(@data-label,'Details')]");
    public static final By LOCATOR = By.xpath("//span[contains(text(),'Created By')]");

    public AccountDetailsWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountDetailsWidget isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR));
        return this;
    }

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

        /*new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingStateProvince());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingStateProvince());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());*/
        return accountFields;
    }

}
