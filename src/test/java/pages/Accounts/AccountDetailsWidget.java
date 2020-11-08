package pages.Accounts;

import elements.Fields;
import io.qameta.allure.Step;
import models.Account;
import models.AccountFields;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

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
        return accountFields;
    }

    public void validateAccountDetails(AccountFields accountFields, Account account) {
        assertEquals(accountFields.getAccountName(), account.getAccountName());
        assertEquals(accountFields.getType(), account.getType());
        assertEquals(accountFields.getWebsite(), account.getWebsite());
        assertEquals(accountFields.getDescription(), account.getDescription());
        assertEquals(accountFields.getPhone(), account.getPhone());
        assertEquals(accountFields.getIndustry(), account.getIndustry());
        assertEquals(accountFields.getEmployees(), account.getEmployees());
    }

}
