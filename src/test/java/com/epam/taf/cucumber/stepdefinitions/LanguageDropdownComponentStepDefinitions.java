package com.epam.taf.cucumber.stepdefinitions;

import com.epam.taf.components.LanguageDropdownComponent;
import com.epam.taf.cucumber.BasePage;
import com.epam.taf.driver.DriverSingleton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LanguageDropdownComponentStepDefinitions {

    private final BasePage basePage = PageFactory.initElements(DriverSingleton.getInstance().getDriver(), BasePage.class);

    private final LanguageDropdownComponent languageDropdownComponent = PageFactory.initElements(DriverSingleton.getInstance().getDriver(), LanguageDropdownComponent.class);

    @When("I click on the {string} element")
    public void iClickOnTheElement(String elementName) {
        basePage.clickElement(elementName);
    }

    @Then("{int} languages are displayed in the dropdown")
    public void languagesAreDisplayedInTheDropdown(int expectedDropdownSize) {
        int actualDropdownSize = languageDropdownComponent.getLanguageDropdownSize();
        assertEquals(actualDropdownSize, expectedDropdownSize);
    }

    @And("I click on the {string} item in dropdown")
    public void iClickOnTheItemInDropdown(String value) {
        languageDropdownComponent.clickLanguageByValue(value);
    }

    @Then("The header of the dropdown is displayed with the {string} text")
    public void theHeaderOfTheDropdownIsDisplayedWithTheText(String expectedDropdownHeader) {
        String actualDropdownHeader = languageDropdownComponent.getLanguageDropdownHeader();
        assertEquals(actualDropdownHeader, expectedDropdownHeader);
    }

    @Then("The selected {string} item has a checkmark")
    public void theSelectedItemHasACheckmark(String value) {
        assertTrue(languageDropdownComponent.isLanguageValueHasCheckmark(value));
    }
}
