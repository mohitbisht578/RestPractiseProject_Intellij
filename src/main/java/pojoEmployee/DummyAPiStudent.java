package pojoEmployee;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

public class DummyAPiStudent {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setAccountNo(111);
        s1.setBalance(23.32);
        s1.setEmail("mohit@250");
        s1.setGender("Male");
        s1.setFirst_name("Mohit");
        s1.setLast_name("Bisht");

        Student s2 = new Student();
        s1.setAccountNo(111);
        s1.setBalance(23.32);
        s1.setEmail("mohit@250");
        s1.setGender("Male");
        s1.setFirst_name("Mohit");
        s1.setLast_name("Bisht");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);

        RestAssured.given().log().all().body(list)
                .when().get();

    }
}
