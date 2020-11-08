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

    @Test
    public void accountShouldBeCreated() {
        accountListPage
                .openPage()
                .isPageOpen()
                .openModalNewAccount()
                .isPageOpen()
                .createAccount(account)
                .clickButtonSave();
        accountDetailsWidget
                .goToTabDetails()
                .isPageOpen();

        accountFields = accountDetailsWidget.getAccountDetails();
        accountDetailsWidget.validateAccountDetails(accountFields, account);
    }

    @AfterMethod
    public void deleteAddedAccount() {
        accountListPage
                .openPage()
                .isPageOpen();
        if (accountListPage.isNewAccountAdded(account)) {
            accountListPage
                    .openDeleteAccountModal(account)
                    .isPageOpen()
                    .clickButtonDelete()
                    .isDisplayNotification();
        }
    }
}
