package basic.rest.qjsonResponseValidation;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class HandleJsonArray {

    @Test
    public void verifyrespionseTest() {
        baseURI = "https://api.trello.com";

       Response response =  given().param("key", "cdea85d4d3e3a564d8bd332345897ab1")
                .param("token", "22e24900076f93b84b393ff7b7b4b9d3fe415c53ec61dadf3c5acbeddf60347c")
                .when().get("/1/boards/hBblXcce")
                .then()
                .assertThat().statusCode(200).and().log().all()
                .and().contentType(ContentType.JSON)
                .and().extract().response();

       //typecast into string
        String jsonResponse = response.asString();
        JsonPath responseBody = new JsonPath(jsonResponse);

        System.out.println("" + responseBody.get("name"));
        System.out.println("card Aging : " + responseBody.get("prefs.cardAging"));
        System.out.println("card Aging : " + responseBody.get("prefs.backgroundBrightness"));

        System.out.println("Background Image width : " + responseBody.get("prefs.backgroundImageScaled[4].width"));

    }
}
