package convertResponseToPojo;

import io.restassured.RestAssured;

public class ConvertJsonArrayResponseToPojo {

    public static void main(String[] args) {

        Address[]  addresses = RestAssured.get("https://run.mocky.io/v3/776a14c5-bf82-4289-b08a-5fca6083cb78")
                .as(Address[].class);

        System.out.println(addresses.length);


        System.out.println(addresses[0].getCity());
        System.out.println(addresses[1].getCity());
    }
}
