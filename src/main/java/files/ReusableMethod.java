package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethod {

    public static JsonPath rawJson(String response) {

        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }


}
