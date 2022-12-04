package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class getmethodautomation {

    //baseuri
    public static String baseUri = "https://api.trello.com";
    public static void main(String[] args) {
        baseURI = baseUri;
        given().param("key", "cdea85d4d3e3a564d8bd332345897ab1")
                .param("token", "22e24900076f93b84b393ff7b7b4b9d3fe415c53ec61dadf3c5acbeddf60347c")
                .when().get("/1/boards/hBblXcce")
                .then().
                log().all().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("name", equalTo("Postman Testing 1"));

    }
}
