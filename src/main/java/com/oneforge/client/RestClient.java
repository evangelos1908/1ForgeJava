package com.oneforge.client;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class RestClient {

    //1. Send a GET request and create a CloseableHttpResponse object with the response
    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault(); //create HTTP Client object
        HttpGet httpget = new HttpGet(url); //http get request
        CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL

        return closebaleHttpResponse;

    }
}
