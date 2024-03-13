package taf.product.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static taf.driver.DriverWait.waitElementToBeClickable;
import static taf.driver.DriverWait.waitForVisibility;

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

    @FindBy(className = "Checkbox")
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
        return firstNameInput.isDisplayed();
    }

    public void typeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public boolean isLastNameInputDisplayed() {
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
        return emailInput.isDisplayed();
    }

    public void typeNewPassword(String newPassword) {
        newPasswordInput.sendKeys(newPassword);
    }

    public boolean isNewPasswordInputDisplayed() {
        return newPasswordInput.isDisplayed();
    }

    public void typePasswordConfirmation(String passwordConfirmation) {
        passwordConfirmationInput.sendKeys(passwordConfirmation);
    }

    public boolean isPasswordConfirmationInputDisplayed() {
        return passwordConfirmationInput.isDisplayed();
    }

    public RegistrationScreen typePassword(String password) {
        typeNewPassword(password);
        typePasswordConfirmation(password);
        return this;
    }

    public RegistrationScreen clickLanguageDropdown() {
        waitElementToBeClickable(languageDropdown);
        languageDropdown.click();
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
        termOfUseCheckbox.click();
        return this;
    }

    public boolean isTermOfUseCheckboxDisplayed() {
        return termOfUseCheckbox.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    public void clickCloseCookieBanner() {
        closeCookieBanner.click();
    }
}
