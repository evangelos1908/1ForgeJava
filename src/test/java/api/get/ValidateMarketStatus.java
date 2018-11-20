package api.get;

import com.oneforge.base.TestBase;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateMarketStatus extends TestBase {

    private CloseableHttpResponse closebaleHttpResponse;
    private String responseString;
    private JSONObject responseJson;
    private String status;

    //check if market is open
    @Test(priority = 1)
    public void validateMarketStatus() throws ClientProtocolException, IOException {

        //If the current test case is failed, then the market is closed
        //if it's passed, the the market is open
        closebaleHttpResponse = restClient.get(marketStatusUrl);

        responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");

        responseJson = new JSONObject(responseString);

        //using .optString instead of .getString, sicne the "market_is_open" is an JSONObject and not a string
        status = responseJson.optString( "market_is_open" );

        Assert.assertEquals( status, "true");

    }
}
