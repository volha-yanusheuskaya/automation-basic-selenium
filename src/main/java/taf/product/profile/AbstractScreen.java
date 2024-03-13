package taf.product.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractScreen {
    protected WebDriver driver;

    protected AbstractScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
