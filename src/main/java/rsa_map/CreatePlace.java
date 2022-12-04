package rsa_map;

import files.Payload;
import files.ReusableMethod;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreatePlace {

    @Test
    public void createPlace() {
        baseURI = "https://rahulshettyacademy.com";
        given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)");

    }

    @Test
    public void createNewPlaceUpdate() {
        baseURI = "https://rahulshettyacademy.com";
        Response response =   given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)")
                .extract().response();

        String jsonString = response.asString();
        JsonPath jsonPath = new JsonPath(jsonString);

        String placeId = jsonPath.getString("place_id");
        System.out.println(placeId);

        //update the place
        String newAddress = "Summer Walk, Africa";
        given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        //get place

        String resp = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .header("Content-Type", "application/json")
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
                //.body("address", equalTo(newAddress));

     //   JsonPath jsonPath1 = new JsonPath(resp);
        JsonPath js1 =  ReusableMethod.rawJson(resp);
        String actualAddress = js1.getString("address");
        Assert.assertEquals(actualAddress, newAddress);

    }

    //Add place --> Update place with new address --> get place to validate if new address is present in response
    @Test
    public void updatePlace() {
        baseURI = "https://rahulshettyacademy.com";
        Response response =   given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.addPlace()).when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)")
                .extract().response();

    }

}
