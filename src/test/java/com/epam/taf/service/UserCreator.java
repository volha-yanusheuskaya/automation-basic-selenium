package com.epam.taf.service;

import com.epam.taf.model.User;

public class UserCreator {

    public static final String FIRST_NAME = "Test Automation First name";

    public static final String LAST_NAME = "Test Automation Last name";

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";

    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private UserCreator() {
    }

    public static User createExistingUser() {
        return new User(FIRST_NAME, LAST_NAME,
                TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}
