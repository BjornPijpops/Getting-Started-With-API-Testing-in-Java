import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get401 extends BaseClass {

    @Test
    public void userReturns401() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user");
        response = client.execute(get);

        int actualStatus = response.getCode();

        assertEquals(actualStatus, 401);
    }

    @Test
    public void userFollowersReturns401() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/user/followers");
        response = client.execute(get);

        int actualStatus = response.getCode();

        assertEquals(actualStatus, 401);
    }

    @Test
    public void notificationsReturns401() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/notifications");
        response = client.execute(get);

        int actualStatus = response.getCode();

        assertEquals(actualStatus, 401);
    }
}
