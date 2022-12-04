package serializationdeserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PojoObjectToJsonObject {

    public static void main(String[] args) throws JsonProcessingException {

        Person person = new Person();
        person.setName("Mohit");
        person.setAge(28);

        ObjectMapper objectMapper = new ObjectMapper();
        String s1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

        System.out.println(s1);

    }
}
