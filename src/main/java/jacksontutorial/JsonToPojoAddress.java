package jacksontutorial;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToPojoAddress {

    //jackson library provide a one class called Object Mapper
    //This is really a  useful class to read and write from json
    //read from json to pojo and pojo to json
    public static void main(String[] args) throws IOException {

        //json file converted desericlaize to pojo address java class
        ObjectMapper objectMapper = new ObjectMapper();

        Address address = objectMapper.readValue(new File("/Users/mohitbisht/IdeaProjects/RestPractiseProject/src/main/resources/payload/address.json"),
                Address.class);

        System.out.println(address.getCity()); //Bangalore

        //now a dont want to pass city as Bangalore i will pass mumbai
        address.setCity("Mumbai");

        String updatedJson1 = objectMapper.writeValueAsString(address);
        System.out.println(updatedJson1);

        String updatedJson2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
        System.out.println(updatedJson2);




    }
}
