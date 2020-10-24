package tests;

import models.Contact;
import org.testng.annotations.Test;

public class ContactTest extends Authorization {

    Contact contact = new Contact("Dr.", "Mary", "Mary",
            "Man", "something", "MaryM",
            "Contact Mary", "masha@st.by", "+792345677889",
            "+375337772211", "", "CEO",
            "+123456789", "Street", "Paris",
            "Province", "123456789",
            "France");

    @Test
    public void contactShouldBeCreated() {
        contactListPage
                .openPage()
                .isPageOpen()
                .openModalNewAccount()
                .isPageOpen()
                .createAccount(contact)
                .clickButtonSave();
    }
}
