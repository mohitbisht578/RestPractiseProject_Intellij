package basic.rest.postcall;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class postcallautomation {

    @Test
    public static void createBoard() {
        baseURI = "https://api.trello.com";
        String boardName = "My Board Name" + (int)(Math.random() * 100);
        given().queryParam("key", "cdea85d4d3e3a564d8bd332345897ab1")
                .queryParam("token", "22e24900076f93b84b393ff7b7b4b9d3fe415c53ec61dadf3c5acbeddf60347c")
                .queryParam("name", boardName)
                .header("Content-Type", "application/json")
                .when().post("/1/boards")
                .then().
                log().all().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("name", equalTo(boardName));
    }

    }
