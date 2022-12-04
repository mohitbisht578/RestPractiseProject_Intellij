package pojoEmployee.nestedObjects;

import io.restassured.RestAssured;

public class CreatedNestedPayload {

    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.setFirstName("Mohit");
        emp.setLastName("Bisht");
        emp.setProfession("IT");

        Address address = new Address();
        address.setHouseNo("1");
        address.setCity("kotdwar");
        address.setStreetName("rean");
        address.setState("karantaka");
        address.setCountry("India");

        emp.setAddress(address);

        RestAssured.given().log().all().body(emp).post();


    }


}
