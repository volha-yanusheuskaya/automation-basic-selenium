package com.epam.taf.model;

public class UserBuilder implements Builder {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserBuilder() {

    }

    @Override
    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User createUser() {
        return new User(firstName, lastName, email, password);
    }
}
