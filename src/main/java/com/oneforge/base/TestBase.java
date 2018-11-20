package com.oneforge.base;

import com.oneforge.client.RestClient;
import com.oneforge.utils.PropertyManager;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;


   // private TestBase testBase;
    public String serviceUrl;
    public String marketStatus;
    public String symbols;
    public String quotes;
    public String api_key;
    public String marketStatusUrl;
    public String symbolsUrl;
    public RestClient restClient;



    @BeforeMethod
    public void setUp() throws ClientProtocolException, IOException {

        //testBase = new TestBase();
        serviceUrl = PropertyManager.getInstance().getURL();
        marketStatus = PropertyManager.getInstance().getMarketStatus();
        symbols = PropertyManager.getInstance().getSymbols();
        quotes = PropertyManager.getInstance().getQuotes();
        api_key = PropertyManager.getInstance().getApiKey();

        marketStatusUrl = serviceUrl + marketStatus + "api_key=" + api_key;
        symbolsUrl = serviceUrl + symbols + "api_key=" + api_key;

        restClient = new RestClient();

    }

}
