package pages.Modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class NotificationModal extends BasePage {

    public static final By NOTIFICATION = By.xpath("//div[contains(@class, 'forceToastMessage')]");

    public NotificationModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public NotificationModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NOTIFICATION));
        return this;
    }

}
