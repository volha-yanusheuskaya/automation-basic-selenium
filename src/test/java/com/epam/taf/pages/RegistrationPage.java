package com.epam.taf.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.epam.taf.service.TestDataReader;

import static com.epam.taf.util.WaitUtils.*;
import static com.epam.taf.util.WebElementUtils.highlightElement;

public class RegistrationPage extends AbstractPage {

    public static final String TESTDATA_REGISTRATION_PAGE_URL = "testdata.registration.page.url";

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "newPassword")
    private WebElement newPasswordInput;

    @FindBy(id = "passwordConfirmation")
    private WebElement passwordConfirmationInput;

    @FindBy(className = "CheckboxInput-checkbox")
    private WebElement termOfUseCheckbox;

    @FindBy(className = "Button")
    private WebElement continueButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(TestDataReader.getTestData(TESTDATA_REGISTRATION_PAGE_URL));
        waitForVisibility(firstNameInput);
        logger.info("The Create account page is opened");
    }

    public String getPageUrl() {
        String url = driver.getCurrentUrl();
        logger.info(String.format("The URL of the page - '%s'", url));
        return url;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info(String.format("The Title of the page - '%s'", title));
        return title;
    }

    public void typeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        logger.info(String.format("First name -'%s'", firstName));
    }

    public boolean isFirstNameInputDisplayed() {
        highlightElement(firstNameInput);
        boolean isFirstNameInputDisplayed = firstNameInput.isDisplayed();
        logger.info("The First name input is displayed");
        return isFirstNameInputDisplayed;
    }

    public void typeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        logger.info(String.format("Last name -'%s'", lastName));
    }

    public boolean isLastNameInputDisplayed() {
        highlightElement(lastNameInput);
        boolean isLastNameInputDisplayed = lastNameInput.isDisplayed();
        logger.info("The Last name input is displayed");
        return isLastNameInputDisplayed;
    }

    public RegistrationPage typeUserName(String firstName, String lastName) {
        typeFirstName(firstName);
        typeLastName(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        emailInput.sendKeys(email);
        logger.info(String.format("Email -'%s'", email));
        return this;
    }

    public boolean isEmailInputDisplayed() {
        highlightElement(emailInput);
        boolean isEmailInputDisplayed = emailInput.isDisplayed();
        logger.info("The Email input is displayed");
        return isEmailInputDisplayed;
    }

    public void typeNewPassword(String newPassword) {
        new Actions(driver)
                .sendKeys(Keys.TAB, newPassword)
                .perform();
    }

    public boolean isNewPasswordInputDisplayed() {
        highlightElement(newPasswordInput);
        boolean isNewPasswordInputDisplayed = newPasswordInput.isDisplayed();
        logger.info("The New password input is displayed");
        return isNewPasswordInputDisplayed;
    }

    public void typePasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationInput.sendKeys(passwordConfirmation);
    }

    public boolean isPasswordConfirmationInputDisplayed() {
        highlightElement(passwordConfirmationInput);
        boolean isPasswordConfirmationInputDisplayed = passwordConfirmationInput.isDisplayed();
        logger.info("The Password confirmation input is displayed");
        return isPasswordConfirmationInputDisplayed;
    }

    public RegistrationPage typePassword(String password) {
        typeNewPassword(password);
        typePasswordConfirmation(password);
        logger.info(String.format("Password -'%s'", password));
        return this;
    }

    public RegistrationPage clickTermOfUseCheckbox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termOfUseCheckbox);
        logger.info("The Term of use checkbox is clicked");
        return this;
    }

    public boolean isTermOfUseCheckboxDisplayed() {
        highlightElement(termOfUseCheckbox);
        boolean isTermOfUseCheckboxDisplayed = termOfUseCheckbox.isDisplayed();
        logger.info("The Term of use checkbox is displayed");
        return isTermOfUseCheckboxDisplayed;
    }

    public void clickContinueButton() {
        continueButton.click();
        logger.info("The Continue button is clicked");
    }

    public boolean isContinueButtonDisplayed() {
        highlightElement(continueButton);
        boolean isContinueButtonDisplayed = continueButton.isDisplayed();
        logger.info("The Continue button is displayed");
        return isContinueButtonDisplayed;
    }
}
