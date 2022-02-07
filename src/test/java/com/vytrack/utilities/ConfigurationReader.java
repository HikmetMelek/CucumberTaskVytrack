package com.vytrack.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {

        try {
            String path="configuration.properties";
            FileInputStream fileInputStream= new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static String get(String key){
        return properties.getProperty(key);
    }
}
