package tests;

import models.Contact;
import models.ContactFields;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ContactTest extends Authorization {

    ContactFields contactFields = new ContactFields();

    Contact contact = new Contact("Dr.", "Mary", "Mary",
            "Man", "something", "Test",
            "Contact Mary", "masha@st.by", "+792345677889",
            "+375337772211", "", "CEO",
            "+123456789", "Street", "Paris",
            "Province", "123456789",
            "France");

    @Test(description = "Create new Contact", retryAnalyzer = RetryAnalyzer.class)
    public void contactShouldBeCreated() {
        contactListPage
                .openPage()
                .isPageOpened()
                .openModalNewAccount()
                .isPageOpened()
                .createAccount(contact)
                .clickButtonSave();
        contactDetailsWidget
                .goToTabDetails()
                .isPageOpened();

        contactFields = contactDetailsWidget.getContactDetails();
        contactDetailsWidget.validateContactDetails(contactFields, contact);
    }

    @AfterMethod(description = "Delete added contact")
    public void deleteAddedAccount() {
        contactListPage
                .openPage()
                .isPageOpened();
        if (contactListPage.isNewContactAdded(contact)) {
            contactListPage
                    .openContextMenuInGrid(contact)
                    .isPageOpened()
                    .openDeleteAccountModal()
                    .isPageOpened()
                    .clickButtonDelete();
            notificationModal
                    .isPageOpened();
        }
    }
}
