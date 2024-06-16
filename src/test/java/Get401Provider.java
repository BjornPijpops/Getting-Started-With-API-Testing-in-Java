import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get401Provider extends BaseClass {

    @DataProvider
    private Object[][] endpoints(){
        return new Object[][] {
                {"/user"},
                {"/user/followers"},
                {"/notifications"}
        };
    }

    @Test(dataProvider = "endpoints")
    public void userReturns401(String endpoint) throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + endpoint);
        response = client.execute(get);

        int actualStatus = response.getCode();

        assertEquals(actualStatus, 401);
    }
}
