package org.aptech.t2303e.httpClient;

import org.aptech.t2303e.config.properties.VietelPostApiProperties;
import org.aptech.t2303e.entity.client.VPLoginReq;
import org.aptech.t2303e.entity.client.VPLoginRes;
import org.aptech.t2303e.utils.ConfigurationUtils;
import org.aptech.t2303e.utils.RestUtils;
import org.springframework.http.*;

import java.io.IOException;
import java.io.Serializable;

public class HttpClientUtils {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        VietelPostApiProperties apiProps = new VietelPostApiProperties();
        apiProps = (VietelPostApiProperties) ConfigurationUtils.readConfig(apiProps);
        // callApilogin
        RestUtils restUtils = new RestUtils();
        VPLoginReq resquest = VPLoginReq.builder()
                .username(apiProps.getUsername())
                .password(apiProps.getPassword())
                .build();
        ResponseEntity<?> response =  restUtils.send(apiProps.getBaseUrl()+apiProps.getLoginUrl(),HttpMethod.POST,resquest,VPLoginRes.class);
        VPLoginRes res = (VPLoginRes) response.getBody();
        System.err.println(res);
    }

//    public static void main(String[] args) throws JsonProcessingException {
//        // call api get return String
//        RestTemplate restTemplate = new RestTemplate();
//        ObjectMapper mapper = new ObjectMapper();
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);
//
//        String url = "https://3db10777-5563-4cec-924c-12fe917e4e85.mock.pstmn.io/getAllUser";
////        ResponseEntity<String> res = restTemplate.getForEntity(url,String.class);
////        User u = mapper.readValue(res.getBody() , User.class);
////        System.err.println(u);
////        if(res.getStatusCode() == HttpStatus.OK){
////            // call api ok
////        }
////        if(res.getStatusCode() == HttpStatus.UNAUTHORIZED){
////            // not authorize , redirect login page
////        }
//        // call api return obj
////        User user = restTemplate.getForObject(url, User.class);
////        System.err.println(user);
//        // Call by exchange
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_JSON);
//        // create body
//        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
//        body.add("id","2");
//        HttpEntity<?> httpEntity = new HttpEntity<>(body,header);
//        ResponseEntity<User> u = restTemplate.exchange(url , HttpMethod.POST , httpEntity,User.class);
//        System.err.println(u);
//    }
    public static class User  implements Serializable {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
