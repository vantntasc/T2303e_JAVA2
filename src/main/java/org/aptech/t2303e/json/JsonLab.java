package org.aptech.t2303e.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aptech.t2303e.session3.db.User;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JsonLab {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // convert object to json string.
        List<Profile> profiles = Arrays.asList(
                new Profile("it", 4000000),
                new Profile("doctor", 20000000),
                new Profile("engineer" , 100000000)
        );
        User u = User.builder()
                .id(1)
                .username("sfdsf")
                .password("34werwefdgdg")
                .createdAt(new Date())
                .updatedAt(new Date())
                .createdBy("admin")
                .profiles(profiles)
                .build();
        // write object to string json
        String jsonStr = mapper.writeValueAsString(u);
//        System.err.println(jsonStr);
        // pretty
        jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(u);
        System.err.println(jsonStr);
//        String jsonStr = "{\n" +
//                "  \"id\" : 1,\n" +
//                "  \"username\" : \"sfdsf\",\n" +
//                "  \"password\" : \"34werwefdgdg\",\n" +
//                "  \"status\" : 0,\n" +
//                "  \"loginFail\" : 0,\n" +
//                "  \"createdAt\" : 1701174010604,\n" +
//                "  \"updatedAt\" : null,\n" +
//                "  \"createdBy\" : \"admin\",\n" +
//                "  \"updatedBy\" : null,\n" +
//                "  \"profiles\" : [ {\n" +
//                "    \"job\" : \"it\",\n" +
//                "    \"salary\" : 4000000\n" +
//                "  }, {\n" +
//                "    \"job\" : \"doctor\",\n" +
//                "    \"salary\" : 20000000\n" +
//                "  }, {\n" +
//                "    \"job\" : \"engineer\",\n" +
//                "    \"salary\" : 100000000\n" +
//                "  } ]\n" +
//                "}";
        u = mapper.readValue(jsonStr , User.class);
        System.err.println(u);
//        jsonMap();
    }
    private static void jsonList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Profile> profiles = Arrays.asList(
                new Profile("it", 4000000),
                new Profile("doctor", 20000000),
                new Profile("engineer" , 100000000)
        );
        String json = mapper.writeValueAsString(profiles);
        System.err.println(json);
        List<Profile> parsedProfiles = mapper.readValue(json, new TypeReference<List<Profile>>() {});
        parsedProfiles.stream().forEach(item  -> System.err.println(item));
    }
    private static void jsonMap() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
                String jsonStr = "{\n" +
                "  \"id\" : 1,\n" +
                "  \"username\" : \"sfdsf\",\n" +
                "  \"password\" : \"34werwefdgdg\",\n" +
                "  \"status\" : 0,\n" +
                "  \"loginFail\" : 0,\n" +
                "  \"createdAt\" : 1701174010604,\n" +
                "  \"updatedAt\" : null,\n" +
                "  \"createdBy\" : \"admin\",\n" +
                "  \"updatedBy\" : null,\n" +
                "  \"profiles\" : [ {\n" +
                "    \"job\" : \"it\",\n" +
                "    \"salary\" : 4000000\n" +
                "  }, {\n" +
                "    \"job\" : \"doctor\",\n" +
                "    \"salary\" : 20000000\n" +
                "  }, {\n" +
                "    \"job\" : \"engineer\",\n" +
                "    \"salary\" : 100000000\n" +
                "  } ]\n" +
                "}";
        Map<String,Object> map = mapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {});
        System.err.println(map);
        // insert list student to file by json
        // read list student from file
    }
}
