package pages.Accounts;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class NewAccountModal extends BasePage {

    public static final By BUTTON_SAVE = By.xpath("//button[@title='Save']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    public NewAccountModal isPageOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SAVE));
        return this;
    }

    @Step("Input values into fields")
    public NewAccountModal createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new DropDown(driver, "Type").select(account.getType());
        new Input(driver, "Website").write(account.getWebsite());
        new TextArea(driver, "Description").write(account.getDescription());
        new Input(driver, "Parent Account").write(account.getParentAccount());
        new Input(driver, "Phone").write(account.getPhone());
        new DropDown(driver, "Industry").select(account.getIndustry());
        new Input(driver, "Employees").write(account.getEmployees());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingStateProvince());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZipPostalCode());
        new Input(driver, "Billing Country").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping State/Province").write(account.getShippingStateProvince());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZipPostalCode());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());
        return this;
    }

    @Step("Click button SAVE")
    public NewAccountModal clickButtonSave() {
        driver.findElement(BUTTON_SAVE).click();
        return this;
    }
}
