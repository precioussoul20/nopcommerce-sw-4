package com.nopcommerce.demo.propertyreader;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    /**
     * Rules for implementing singleton design patter
     * 1. make the constructor private
     * 2. create a static method to get the instance
     * 3. create a static member variable
     */

    // declare the propertyReader variable
    private static volatile PropertyReader propInstance;

    // create Private constructor because of prevent the instantiation of class
    private PropertyReader(){

    }

    /**
     * This method will return instance of propertyReader class
     *
     * @return
     */
    public static synchronized PropertyReader getInstance(){
        if (propInstance == null){

            propInstance = new PropertyReader();
        }
        return propInstance;
    }
    /**
     * This method will read property from property file
     *
     * propertyName
     * @return
     */

    public String getProperty(String propertyName){
        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null){
                return prop.getProperty(propertyName);
        }
        }
        catch (Exception e){
            System.out.println("Property not found");
        }
        return null;
    }



}
