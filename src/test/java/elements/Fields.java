package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fields {
    WebDriver driver;
    String label;
    String locator = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//descendant::slot[contains(@slot,'outputField')]//*";
    String locatorA = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//a"; //Website, Phone
    String locatorAddressA = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//a"; //Website, Phone

    public Fields(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

   public String getInformationText() {
        return driver.findElement(By.xpath(String.format(locator, label))).getText();
    }

    public String getInformationLink() {
        return driver.findElement(By.xpath(String.format(locatorA, label))).getText();
    }

    public String getInformationAddressLink() {
        return driver.findElement(By.xpath(String.format(locatorAddressA, label))).getText();
    }
}
