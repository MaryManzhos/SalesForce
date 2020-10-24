package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.Accounts.AccountListPage;
import pages.Accounts.NewAccountModal;
import pages.Contacts.ContactListPage;
import pages.Contacts.NewContactModal;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    NewAccountModal newAccountModal;
    AccountListPage accountListPage;
    ContactListPage contactListPage;
    NewContactModal newContactModal;

    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        newAccountModal = new NewAccountModal(driver);
        accountListPage = new AccountListPage(driver);
        contactListPage = new ContactListPage(driver);
        newContactModal = new NewContactModal(driver);
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
