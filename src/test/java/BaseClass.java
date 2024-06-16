import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.playground.entities.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.playground.ResponseUtils.unmarshall;
import static org.testng.Assert.assertEquals;

public class BaseClass {
    protected static final String BASE_ENDPOINT = "https://api.github.com";

    CloseableHttpClient client;
    CloseableHttpResponse response;

    @BeforeMethod
    public void setup() {
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        EntityUtils.consume(response.getEntity());
        client.close();
        response.close();
    }

    @Test
    public void returnsCorrectLogin() throws IOException, ParseException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/BjornPijpops");
        response = client.execute(get);

        User user = unmarshall(response, User.class);

        assertEquals(user.getLogin(), "BjornPijpops");
    }
}
