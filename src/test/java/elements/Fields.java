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
    String locatorA = "//*[contains(text(), '%s')]/ancestor::div[contains(@class,'label-inline')]//a"; //Website, Phone
    String locatorAddressA = "//span[contains(text(), '%s')]/ancestor::div[contains(@class, 'label-inline')]//div[contains(@class,'slds-truncate')]"; //Address

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

    public List<String> getInformationAddressLink() {
        List<WebElement> elements = driver.findElements(By.xpath(String.format(locatorAddressA, label)));
        List<String> addressInformation = new ArrayList<String>();

        for (WebElement value : elements) {
            addressInformation.add(value.getText());
        }

        return addressInformation;
    }
}
