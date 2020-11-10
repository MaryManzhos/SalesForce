package pages.Modals;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class DeleteModal extends BasePage {

    public static final By BUTTON_DELETE = By.xpath("//span[contains(text(), 'Delete')]");

    public DeleteModal(WebDriver driver) {
        super(driver);
    }

    public DeleteModal isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_DELETE));
        return this;
    }

    @Step("Click button DELETE")
    public void clickButtonDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_DELETE));
        driver.findElement(BUTTON_DELETE).click();
    }

}
