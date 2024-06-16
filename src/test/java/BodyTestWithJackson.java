import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.ParseException;
import org.playground.entities.RateLimit;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.playground.ResponseUtils.unmarshall;
import static org.testng.Assert.assertEquals;

public class BodyTestWithJackson extends BaseClass{

    @Test
    public void correctRateLimitsAreSet() throws IOException, ParseException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        response = client.execute(get);

        RateLimit rateLimit = unmarshall(response, RateLimit.class);

        assertEquals(rateLimit.getCoreLimit(), 60);
        assertEquals(rateLimit.getSearchLimit(), "10");
    }
}
