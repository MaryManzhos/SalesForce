package tests;

import org.testng.annotations.BeforeClass;

import static data.TestData.PASSWORD;
import static data.TestData.USERNAME;

public class Authorization extends BaseTest {

    @BeforeClass
    public void authorization() {
        loginPage
                .openPage()
                .isPageOpened()
                .authorization(USERNAME, PASSWORD)
                .isPageOpened();
    }
}
