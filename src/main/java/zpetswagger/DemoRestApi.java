package zpetswagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class DemoRestApi {

    @Test
    public void testAPI(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        Response response = given().when().get("/v2/pet/findByStatus?status=pending")
                .then().extract().response();

        System.out.println(response.prettyPrint());
    }
}
