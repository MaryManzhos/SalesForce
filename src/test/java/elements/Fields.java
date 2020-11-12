package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Fields {
    WebDriver driver;
    String label;
    String locator = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//descendant::slot[contains(@slot,'outputField')]//*";
    String locatorName = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//descendant::slot[contains(@slot,'outputField')]/lightning-formatted-name";
    String locatorA = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//a"; //Website, Phone
    String locatorSpan = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//descendant::slot[contains(@slot,'outputField')]//span";
    String locatorAddressA = "//span[contains(text(), '%s')]/ancestor::div[contains(@class, 'label-inline')]//div[contains(@class,'slds-truncate')]"; //Address

    public Fields(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public String getInformationName() {
        return driver.findElement(By.xpath(String.format(locatorName, label))).getText();
    }

    public String getInformationSpan() {
        return driver.findElement(By.xpath(String.format(locatorSpan, label))).getText();
    }

    public String getInformationText() {
        return driver.findElement(By.xpath(String.format(locator, label))).getText();
    }

    public String getInformationLink() {
        return driver.findElement(By.xpath(String.format(locatorA, label))).getText();
    }

    public List<String> getInformationAddressLink() {
        List<WebElement> elements = driver.findElements(By.xpath(String.format(locatorAddressA, label)));
        List<String> addressInformation = new ArrayList<>();

        for (WebElement value : elements) {
            addressInformation.add(value.getText());
        }

        return addressInformation;
    }
}
