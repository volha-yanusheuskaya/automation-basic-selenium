package com.epam.taf.service;

import com.epam.taf.model.User;
import com.epam.taf.model.UserBuilder;

public class UserCreator {

    public static final String FIRST_NAME = "Test Automation First name";

    public static final String LAST_NAME = "Test Automation Last name";

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";

    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private UserCreator() {
    }

    public static User createExistingUser() {
        return new UserBuilder()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(TestDataReader.getTestData(TESTDATA_USER_EMAIL))
                .setPassword(TestDataReader.getTestData(TESTDATA_USER_PASSWORD))
                .createUser();
    }
}
