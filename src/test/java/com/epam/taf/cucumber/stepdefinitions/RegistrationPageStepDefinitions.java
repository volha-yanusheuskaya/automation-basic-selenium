package com.epam.taf.cucumber.stepdefinitions;

import com.epam.taf.cucumber.BasePage;
import com.epam.taf.driver.DriverSingleton;
import com.epam.taf.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationPageStepDefinitions {

    private final BasePage basePage = PageFactory.initElements(DriverSingleton.getInstance().getDriver(), BasePage.class);
    private final RegistrationPage registrationPage = PageFactory.initElements(DriverSingleton.getInstance().getDriver(), RegistrationPage.class);

    @Given("I have navigated to the Create account page")
    public void iHaveNavigatedToTheCreateAccountPage() {
        registrationPage.openPage();
    }

    @Then("The URL of the page ends with {string}")
    public void theURLOfThePageEndsWith(String url) {
        assertTrue(registrationPage.getPageUrl().endsWith(url));
    }

    @Then("^The Title of the page is equals to \"((.+))\"$")
    public void theTitleOfThePageIsEqualsTo(String title) {
        assertEquals(registrationPage.getPageTitle(), title);
    }

    @Then("The {string} element is displayed")
    public void theElementIsDisplayed(String elementName) {
        assertTrue(basePage.isElementDisplayed(elementName));
    }

}
