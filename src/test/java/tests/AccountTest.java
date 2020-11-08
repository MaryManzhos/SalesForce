package tests;

import models.Account;
import models.AccountFields;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AccountTest extends Authorization {

    AccountFields accountFields = new AccountFields();

    Account account = new Account("Mary", "Analyst",
            "https://www.pandadoc.com/", "Description",
            "Cinderella", "+792557779944", "Banking",
            "50", "Avenu St.", "Paris",
            "France", "123456789", "France",
            "Street", "Berlin", "Berlin",
            "987654321", "Germany");

    @Test(description = "Create new Account", retryAnalyzer = RetryAnalyzer.class)
    public void accountShouldBeCreated() {
        accountListPage
                .openPage()
                .isPageOpened()
                .openModalNewAccount()
                .isPageOpened()
                .createAccount(account)
                .clickButtonSave();
        accountDetailsWidget
                .goToTabDetails()
                .isPageOpened();

        accountFields = accountDetailsWidget.getAccountDetails();
        accountDetailsWidget.validateAccountDetails(accountFields, account);
    }

    @AfterMethod
    public void deleteAddedAccount() {
        accountListPage
                .openPage()
                .isPageOpened();
        if (accountListPage.isNewAccountAdded(account)) {
            accountListPage
                    .openDeleteAccountModal(account)
                    .isPageOpened()
                    .clickButtonDelete()
                    .isDisplayNotification();
        }
    }
}
