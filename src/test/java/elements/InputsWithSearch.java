package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputsWithSearch {

    WebDriver driver;
    String label;
    String locator = "//div[contains(@title,'%s')]";

    public InputsWithSearch(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void choose() {
        driver.findElement(By.xpath(String.format(locator, label))).click();
    }

}
