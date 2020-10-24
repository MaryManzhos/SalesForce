package tests;

import models.Account;
import org.testng.annotations.Test;

public class AccountTest extends Authorization {

    Account account = new Account("Mary", "Analyst",
            "https://www.pandadoc.com/", "Description",
            "Cinderella", "+792557779944", "Banking",
            "1500", "Avenu St.", "Paris",
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
    }
}
