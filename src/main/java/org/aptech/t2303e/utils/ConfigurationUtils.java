package org.aptech.t2303e.utils;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.annotations.ConfigurationProperties;
import org.aptech.t2303e.annotations.Value;
import org.aptech.t2303e.config.properties.DatabaseProperties;
import org.aptech.t2303e.config.properties.VietelPostApiProperties;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigurationUtils {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        VietelPostApiProperties vietelPostApiProperties = new VietelPostApiProperties();
        vietelPostApiProperties = (VietelPostApiProperties) readConfig(vietelPostApiProperties);
        System.err.println(vietelPostApiProperties);
    }
    // read class  -> set value of props for object of class  -> return obj
    public static  Object  readConfig(Object obj) throws IOException, IllegalAccessException {
        FileReader reader = new FileReader("./src/main/resources/application.properties");
        Properties props = new Properties();
        props.load(reader);
        Class<?> clazz = obj.getClass();
        System.err.println("Process read properties for class :"+ clazz.getSimpleName());
        if(clazz.getAnnotation(ConfigurationProperties.class) == null){
            System.err.println("Not have annotation ConfigurationProperties , class : "+ clazz.getSimpleName());
            return  null;
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields ){
            Value v = f.getAnnotation(Value.class);
            if(v == null){
                continue;
            }
            String value  = v.value();
            if(StringUtils.isEmpty(value)){
                System.err.println("This props cannot be empty");
                continue;
            }
            f.setAccessible(true); // set can access value of field
            f.set(obj,props.getProperty(value));
        }
        return obj;
    }
}
