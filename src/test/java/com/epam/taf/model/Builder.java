package com.epam.taf.model;

public interface Builder {
    Builder setFirstName(String firstName);

    Builder setLastName(String lastName);

    Builder setEmail(String email);

    Builder setPassword(String password);
}
