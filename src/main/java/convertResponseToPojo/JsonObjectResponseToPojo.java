package convertResponseToPojo;

import io.restassured.RestAssured;
import org.codehaus.groovy.runtime.m12n.ExtensionModule;

public class JsonObjectResponseToPojo {

    public static void main(String[] args) {

        //deserialization converting json response into pojo class using method as take type of class name

        //this time you got the json response
        Employee empoyee = RestAssured.get("https://run.mocky.io/v3/f818ccc2-9f67-429f-9588-1ea2f541af6a")
                .as(Employee.class);

        int age = empoyee.getAge();
        System.out.println(age);

    }
}
