package pages.Modals;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ContextMenuInGrid extends BasePage {

    public static final By MENU_ITEM_DELETE = By.xpath("//a[contains(@title, 'Delete')]");

    public ContextMenuInGrid(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContextMenuInGrid isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MENU_ITEM_DELETE));
        return this;
    }

    @Step("Open Delete Modal")
    public DeleteModal openDeleteAccountModal() {
        driver.findElement(MENU_ITEM_DELETE).click();
        return new DeleteModal(driver);
    }

}
