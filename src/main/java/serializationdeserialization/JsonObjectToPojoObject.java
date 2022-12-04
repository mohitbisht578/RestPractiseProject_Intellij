package serializationdeserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonObjectToPojoObject {

    public static void main(String[] args) throws JsonProcessingException {

        String jsonResponse = "{\n" +
                "  \"name\": \"Mohit\",\n" +
                "  \"age\" : 28\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
       Person p =  objectMapper.readValue(jsonResponse, Person.class);

       System.out.println(p.getName());
       System.out.println(p.getAge());

       //use as a map

        System.out.println("-------");

        Map<String, Object> map1 = objectMapper.readValue(jsonResponse, Map.class);
        System.out.println(map1.get("name"));
        System.out.println(map1.get("age"));
    }
}
