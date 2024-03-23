package com.epam.taf.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.epam.taf.model.User;
import com.epam.taf.service.TestDataReader;

import static com.epam.taf.driver.DriverWait.waitForVisibility;
import static com.epam.taf.driver.DriverWait.waitElementToBeClickable;
import static com.epam.taf.util.WebElementUtils.highlightElement;

public class RegistrationPage extends AbstractPage {

    public static final String LANGUAGE_VALUE_PATTERN = "//button/span[text()='%s']";
    public static final String LANGUAGE_WITH_CHECKMARK = "//button/span[text()='%s']/following-sibling::span";

    public static final String TESTDATA_REGISTRATION_PAGE_URL = "testdata.registration.page.url";

    private final Logger logger = LogManager.getRootLogger();

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

    @FindBy(css = ".CiamDropdown")
    private WebElement languageDropdown;

    @FindBy(css = ".CiamDropdown-headerText")
    private WebElement languageHeaderValue;

    @FindBy(className = "CheckboxInput-checkbox")
    private WebElement termOfUseCheckbox;

    @FindBy(className = "Button")
    private WebElement continueButton;

    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement acceptCookieBanner;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage openPage() {
        driver.get(TestDataReader.getTestData(TESTDATA_REGISTRATION_PAGE_URL));
        waitForVisibility(firstNameInput);
        logger.info("The Create account page is opened");
        return this;
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

    public RegistrationPage clickLanguageDropdown() {
        waitForVisibility(languageDropdown);
        waitElementToBeClickable(languageDropdown);
        new Actions(driver)
                .scrollToElement(languageDropdown)
                .click(languageDropdown)
                .perform();
        logger.info("The Language dropdown is opened");
        return this;
    }

    public int getLanguageDropdownSize() {
        return driver.findElements(By.cssSelector(".CiamDropdown-itemInnerText")).size();
    }

    public RegistrationPage clickLanguageByValue(String value) {
        driver.findElement(By.xpath(String.format(LANGUAGE_VALUE_PATTERN, value))).click();
        return this;
    }

    public String getLanguageDropdownHeader() {
        return languageHeaderValue.getText();
    }

    public boolean isLanguageValueHasCheckmark(String value) {
        return driver.findElement(By.xpath(String.format(LANGUAGE_WITH_CHECKMARK, value))).isDisplayed();
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

    public RegistrationPage clickAcceptCookieBanner() {
        acceptCookieBanner.click();
        return this;
    }

    public void fillOutRegistrationForm(User user) {
        typeUserName(user.getFirstName(), user.getLastName())
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickTermOfUseCheckbox()
                .clickContinueButton();
    }
}
