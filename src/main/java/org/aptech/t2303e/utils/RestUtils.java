package org.aptech.t2303e.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestUtils {
    private  RestTemplate restTemplate ;

    public RestUtils() {
        this.restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
    }

    private static Logger logger = LogManager.getLogger(RestUtils.class);
    private HttpHeaders initHeader(){
        HttpHeaders initHeader = new HttpHeaders();
        initHeader.setContentType(MediaType.APPLICATION_JSON);
        return initHeader;
    }
    // build http entity with token
    private HttpEntity<?> buildEntity(String token, Object body){
        HttpHeaders headers = initHeader();
        logger.info("Token  : {}", token);
        if(!StringUtils.isEmpty(token)){
            headers.add("token",token);
        }
        return (body != null) ?  new HttpEntity<>(body, headers)
                : new HttpEntity<>(headers);
    }
    private HttpEntity<?> buildEntityWithToken(String token){
        HttpHeaders headers = initHeader();
        logger.info("Token  : {}", token);
        if(!StringUtils.isEmpty(token)){
            headers.add("token",token);
        }
        return new HttpEntity<>(headers);
    }
    private HttpEntity<?> buildEntity(){
        return buildEntityWithToken(null);
    }
    // call with no token
     public ResponseEntity<?> send(String path, HttpMethod method,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(),responseType);
        }
    }
    public ResponseEntity<?> send(String token,String path, HttpMethod method,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntityWithToken(token),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntityWithToken(token),responseType);
        }
    }
    public ResponseEntity<?> send(String path, HttpMethod method,Object body,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(null, body),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(null, body),responseType);
        }
    }
    public ResponseEntity<?> send(String token,String path,Object body, HttpMethod method,Class<?> responseType,Object... uriVariables){
        if(uriVariables != null && uriVariables.length > 0){
            return restTemplate.exchange(path,method,buildEntity(token,body),responseType,uriVariables);
        }else{
            return restTemplate.exchange(path,method,buildEntity(token,body),responseType);
        }
    }
}
