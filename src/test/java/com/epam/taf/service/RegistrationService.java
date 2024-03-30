package com.epam.taf.service;

import com.epam.taf.model.User;
import com.epam.taf.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegistrationService {

    private final RegistrationPage registrationPage;

    public RegistrationService(WebDriver driver) {
        registrationPage = new RegistrationPage(driver);
    }

    public void fillOutRegistrationForm(User user) {
        registrationPage
                .typeUserName(user.getFirstName(), user.getLastName())
                .typeEmail(user.getEmail())
                .typePassword(user.getPassword())
                .clickTermOfUseCheckbox()
                .clickContinueButton();
    }
}
