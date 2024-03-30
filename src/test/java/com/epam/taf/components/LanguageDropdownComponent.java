package com.epam.taf.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.epam.taf.util.WaitUtils.waitElementToBeClickable;
import static com.epam.taf.util.WaitUtils.waitForVisibility;

public class LanguageDropdownComponent extends AbstractComponent {

    public static final String LANGUAGE_VALUE_PATTERN = "//button/span[text()='%s']";
    public static final String LANGUAGE_WITH_CHECKMARK = "//button/span[text()='%s']/following-sibling::span";

    @FindBy(css = ".CiamDropdown")
    private WebElement languageDropdown;

    @FindBy(css = ".CiamDropdown-headerText")
    private WebElement languageHeaderValue;

    public LanguageDropdownComponent(WebDriver driver) {
        super(driver);
    }

    public LanguageDropdownComponent clickLanguageDropdown() {
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

    public LanguageDropdownComponent clickLanguageByValue(String value) {
        driver.findElement(By.xpath(String.format(LANGUAGE_VALUE_PATTERN, value))).click();
        return this;
    }

    public String getLanguageDropdownHeader() {
        return languageHeaderValue.getText();
    }

    public boolean isLanguageValueHasCheckmark(String value) {
        return driver.findElement(By.xpath(String.format(LANGUAGE_WITH_CHECKMARK, value))).isDisplayed();
    }

}
