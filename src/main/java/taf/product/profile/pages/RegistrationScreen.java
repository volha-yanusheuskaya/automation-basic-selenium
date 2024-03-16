package taf.product.profile.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static taf.driver.DriverWait.*;
import static taf.util.WebElementUtils.highlightElement;

public class RegistrationScreen extends AbstractScreen {

    public static final String REGISTRATION_PAGE_URL = "https://account.thomsonreuters.com/en-us/profile/create-account";

    public static final String LANGUAGE_VALUE_PATTERN = "//button/span[text()='%s']";
    public static final String LANGUAGE_WITH_CHECKMARK = "//button/span[text()='%s']/following-sibling::span";

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

    @FindBy(css = ".banner-close-button")
    private WebElement closeCookieBanner;

    public RegistrationScreen(WebDriver driver) {
        super(driver);
    }

    public RegistrationScreen openPage() {
        driver.get(REGISTRATION_PAGE_URL);
        waitForVisibility(firstNameInput);
        return this;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void typeFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public boolean isFirstNameInputDisplayed() {
        highlightElement(firstNameInput);
        return firstNameInput.isDisplayed();
    }

    public void typeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public boolean isLastNameInputDisplayed() {
        highlightElement(lastNameInput);
        return lastNameInput.isDisplayed();
    }

    public RegistrationScreen typeUserName(String firstName, String lastName) {
        typeFirstName(firstName);
        typeLastName(lastName);
        return this;
    }

    public RegistrationScreen typeExistsEmail() {
        emailInput.sendKeys("test_email_profile1@mailinator.com");
        return this;
    }

    public boolean isEmailInputDisplayed() {
        highlightElement(emailInput);
        return emailInput.isDisplayed();
    }

    public void typeNewPassword(String newPassword) {
        new Actions(driver)
                .sendKeys(Keys.TAB, newPassword)
                .perform();
    }

    public boolean isNewPasswordInputDisplayed() {
        highlightElement(newPasswordInput);
        return newPasswordInput.isDisplayed();
    }

    public void typePasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationInput.sendKeys(passwordConfirmation);
    }

    public boolean isPasswordConfirmationInputDisplayed() {
        highlightElement(passwordConfirmationInput);
        return passwordConfirmationInput.isDisplayed();
    }

    public RegistrationScreen typePassword(String password) {
        typeNewPassword(password);
        typePasswordConfirmation(password);
        return this;
    }

    public RegistrationScreen clickLanguageDropdown() {
        waitForVisibility(languageDropdown);
        waitElementToBeClickable(languageDropdown);
        new Actions(driver)
                .scrollToElement(languageDropdown)
                .click(languageDropdown)
                .perform();
        return this;
    }

    public int getLanguageDropdownSize() {
        return driver.findElements(By.cssSelector(".CiamDropdown-itemInnerText")).size();
    }

    public RegistrationScreen clickLanguageByValue(String value) {
        driver.findElement(By.xpath(String.format(LANGUAGE_VALUE_PATTERN, value))).click();
        return this;
    }

    public String getLanguageDropdownHeader() {
        return languageHeaderValue.getText();
    }

    public boolean isLanguageValueHasCheckmark(String value) {
        return driver.findElement(By.xpath(String.format(LANGUAGE_WITH_CHECKMARK, value))).isDisplayed();
    }

    public RegistrationScreen clickTermOfUseCheckbox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termOfUseCheckbox);
        return this;
    }

    public boolean isTermOfUseCheckboxDisplayed() {
        highlightElement(termOfUseCheckbox);
        return termOfUseCheckbox.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isContinueButtonDisplayed() {
        highlightElement(continueButton);
        return continueButton.isDisplayed();
    }

    public RegistrationScreen clickCloseCookieBanner() {
        closeCookieBanner.click();
        return this;
    }
}
