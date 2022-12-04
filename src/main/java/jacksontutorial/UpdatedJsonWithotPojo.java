package jacksontutorial;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UpdatedJsonWithotPojo {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> address = objectMapper.readValue(new File("/Users/mohitbisht/IdeaProjects/RestPractiseProject/src/main/resources/payload/address.json"),
                new TypeReference<Map<String, Object>>() {});

        System.out.println(address.get("city"));

        //update city to Mumbai
        address.put("city", "Mumbai");

        //add new field dynamically in json
        address.put("pin", "1234");

        address.remove("houseNo");
        String updated = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println(updated);

    }
}
