package com.oneforge.utils;

/*
I use singleton design pattern to create the PropertyManager class.
Like this, we ensure that we load and read the configuration data only one time

* After the first call, we get the PropertyManager instance/object via getInstance() method
* loadData() method reads the configuration.properties file and assign the variables to the private variables
* Lastly, we have getter methods to reach the variables
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    //declare them as private since they are only used in the current class
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+"/src/main/java/com/oneforge/config/config.properties";
    private static String url;
    private static String marketStatus;
    private static String symbols;
    private static String quotes;
    private static String apiKey;



    //Create a Singleton instance. We need only one instance of Property Manager.
    // we create the instance of the class in synchronized method or synchronized block, so instance of the class is created when required.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //get the data and assign to the fields
    private void loadData(){

        //Properties class is sued to read from file and return the value based on key
        Properties prop = new Properties();

        //Read and load the file in the prop object
        try{
            prop.load(new FileInputStream(propertyFilePath));
        }catch (IOException e){
            System.out.println("Config.properties file cannot be found");
        }

        //Now that file has been loaded to prop object, we can get any value from it
        url = prop.getProperty("URL");
        marketStatus = prop.getProperty("PATH_PARAMETER_MARKET_STATUS");
        symbols = prop.getProperty("PATH_PARAMETER_SYMBOLS");
        quotes = prop.getProperty("PATH_PARAMETER_QUOTES");
        apiKey = prop.getProperty("API_KEY");

    }

    //Getters to reach the variables, because they are private !!

    public String getURL (){
        return url; }

    public String getMarketStatus () {
        return marketStatus;
    }

    public String getSymbols (){
        return symbols;
    }

    public String getQuotes () {
        return quotes;
    }

    public String getApiKey (){
        return apiKey;
    }

}
