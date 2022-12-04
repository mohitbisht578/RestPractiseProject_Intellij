package rsa_map;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ComplexJsonParse {

    @Test
    public static void verifyCourse() {

        JsonPath jsonPath = new JsonPath(Payload.coursePrice());

       //1 . Print No of courses returned by API
       List<String> listCourse = jsonPath.getList("courses.title");
       System.out.println(listCourse);

        //2.Print Purchase Amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        //3. Print Title of the first course
        String firstTitleCourse = jsonPath.getString("courses[0].title");
        System.out.println(firstTitleCourse);

        //4. Print All course titles and their respective Prices
        int count = jsonPath.getInt("courses.size()");
        for(int i=0; i<count; i++) {
            String title = jsonPath.get("courses["+i+"].title");
            String price = jsonPath.get("courses["+i+"].price").toString();
            System.out.println(title);
            System.out.println(price);
        }

        //5. Print no of copies sold by RPA Course
        int copiesRPACourse = jsonPath.getInt("courses[2].copies");
        System.out.println(copiesRPACourse);

        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int sum = 0;
        for(int i=0; i<count; i++) {
            int coursesPrice = jsonPath.getInt("courses["+i+"].price");
            int coursesCopes = jsonPath.getInt("courses["+i+"].copies");
            int amount = coursesPrice * coursesCopes;
            System.out.println(amount);
           sum += amount;
        }
        System.out.println("----");
        System.out.println(sum);
       Assert.assertEquals(purchaseAmount, sum);



    }
}
