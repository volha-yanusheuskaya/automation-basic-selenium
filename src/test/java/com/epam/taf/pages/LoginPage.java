package com.epam.taf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.taf.util.WaitUtils.waitForVisibility;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement userNameInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserNameInputDisplayed() {
        waitForVisibility(userNameInput);
        logger.info("The Login form is displayed");
        return userNameInput.isDisplayed();
    }
}
