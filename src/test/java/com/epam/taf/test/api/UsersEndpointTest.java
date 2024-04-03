package com.epam.taf.test.api;

import org.apache.hc.core5.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersEndpointTest {

    public static final String ENDPOINT = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void getStatusCode() {
        given().when().get(ENDPOINT).then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getResponseHeader() {
        given().when().get(ENDPOINT).then().assertThat().statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.APPLICATION_JSON.toString().toLowerCase());
    }

    @Test
    public void getResponseBody() {
        given().when().get(ENDPOINT).then().assertThat().statusCode(HttpStatus.SC_OK)
                .body("users.size()", equalTo(10))
                .body("users.id", everyItem(notNullValue()))
                .body("users.name", everyItem(notNullValue()))
                .body("users.username", everyItem(notNullValue()))
                .body("users.email", everyItem(notNullValue()))
                .body("users.address", everyItem(notNullValue()))
                .body("users.phone", everyItem(notNullValue()))
                .body("users.website", everyItem(notNullValue()))
                .body("users.company", everyItem(notNullValue()))
                .body("username[0]", equalTo("Bret"))
                .body("name[1]", equalTo("Ervin Howell"))
                .body("email[2]", equalTo("Nathan@yesenia.net"))
                .body("address.street[3]", equalTo("Hoeger Mall"))
                .body("address.city[4]", equalTo("Roscoeview"))
                .body("phone[5]", equalTo("1-477-935-8478 x6430"))
                .body("website[6]", equalTo("elvis.io"))
                .body("company.name[7]", equalTo("Abernathy Group"))
                .body("company.catchPhrase[8]", equalTo("Switchable contextually-based project"))
                .body("id[9]", equalTo(10));
    }
}
