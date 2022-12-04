package convertResponseToPojo;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

public class ConvertJsonArrayResponseToPojoList {

    public static void main(String[] args) {

        List<Address> addresses = RestAssured.get("https://run.mocky.io/v3/776a14c5-bf82-4289-b08a-5fca6083cb78")
                .as(new TypeRef<List<Address>>() {});

        System.out.println(addresses.size());


        System.out.println(addresses.get(0).getCity());
        System.out.println(addresses.get(1).getCity());
    }
}
