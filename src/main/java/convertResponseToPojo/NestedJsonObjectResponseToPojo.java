package convertResponseToPojo;

import io.restassured.RestAssured;

public class NestedJsonObjectResponseToPojo {

    public static void main(String[] args) {

        EmployeeWithAddress employee = RestAssured.get("https://run.mocky.io/v3/37b177a5-d1ad-445a-bfbe-aacac041d971")
                .as(EmployeeWithAddress.class);

        String fn = employee.getFirstname();
        System.out.println(fn);

        String sn = employee.getAddress().getStreetName();
        System.out.println(sn);

    }
}
