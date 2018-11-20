package api.get;

import com.oneforge.base.TestBase;
import com.oneforge.client.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;

public class QuotesToCSV extends TestBase {


    private CloseableHttpResponse closebaleHttpResponse;
    private String responseString;
    private JSONArray responseJsonArray;
    private String tenFirstSymbolsParameter;
    private String quotesFirstTenPairsUrl;
    private String responseStringTenFirst;
    private JSONArray responseJsonTenFirst;
    private String csv;


    //get the first 10 symbols, get the quotes and stores the values into a csv file
    @Test(priority = 2)
    public void returnFirstTenSymbols() throws ClientProtocolException, IOException {

        //get the entire list of symbols and store it as JSONArray
        closebaleHttpResponse = restClient.get(symbolsUrl);
        responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
        responseJsonArray = new JSONArray(responseString);


        //extract the first 10 symbols and save them as String with "," as delimiter
        String[] firstTemSymbols = new String[10];
        for(int i = 0; i< 10; i++) {
            firstTemSymbols[i] = responseJsonArray.getString(i);
        }

        tenFirstSymbolsParameter = String.join( ",", firstTemSymbols);


        //using the above string send a GET request in order to get the quotes for these particular pairs
        quotesFirstTenPairsUrl = serviceUrl + quotes + "pairs=" + tenFirstSymbolsParameter + "&api_key=" + api_key;
        closebaleHttpResponse = restClient.get(quotesFirstTenPairsUrl);
        responseStringTenFirst = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
        responseJsonTenFirst = new JSONArray(responseStringTenFirst);

        //Store the data from the JSONArray response in csv format
        csv = CDL.toString(responseJsonTenFirst);

        //create a csv file and write the response
        File file = new File ("/Users/evangelos/Downloads/1Forge-master/sample.csv");
        file.getParentFile().mkdirs();
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write(csv);
        printWriter.close();


    }
}
