package com.epam.taf.cucumber.stepdefinitions;

import com.epam.taf.components.CookieBannerComponent;
import com.epam.taf.driver.DriverSingleton;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class CookieBannerComponentStepDefinitions {

    public final CookieBannerComponent cookieBannerComponent = PageFactory.initElements(DriverSingleton.getInstance().getDriver(), CookieBannerComponent.class);

    @When("I close cookie banner")
    public void iCloseCookieBanner() {
        cookieBannerComponent.clickAcceptCookieBanner();
    }

}
