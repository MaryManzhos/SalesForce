package tests;

import org.testng.annotations.BeforeClass;

import static dataTest.TestData.PASSWORD;
import static dataTest.TestData.USERNAME;

public class Authorization extends BaseTest {

    @BeforeClass
    public void authorization() {
        loginPage
                .openPage()
                .isPageOpen()
                .authorization(USERNAME, PASSWORD)
                .isPageOpen();
    }
}
