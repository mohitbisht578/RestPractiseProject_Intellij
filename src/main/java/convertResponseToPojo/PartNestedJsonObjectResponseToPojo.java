package convertResponseToPojo;

import io.restassured.RestAssured;

public class PartNestedJsonObjectResponseToPojo {

    public static void main(String[] args) {

        //part of json into pojo
        Address address = RestAssured.get("https://run.mocky.io/v3/37b177a5-d1ad-445a-bfbe-aacac041d971")
                .jsonPath()
                .getObject("address", Address.class);

        System.out.println(address.getCity());

    }
}
