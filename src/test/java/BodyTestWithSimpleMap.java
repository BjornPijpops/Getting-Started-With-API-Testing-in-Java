import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.playground.entities.User.ID;
import static org.playground.entities.User.LOGIN;
import static org.testng.Assert.assertEquals;

public class BodyTestWithSimpleMap extends BaseClass{

    @Test
    public void returnsCorrectLogin() throws IOException, ParseException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/BjornPijpops");
        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        String loginValue = (String) getValueFor(jsonObject, LOGIN);
        assertEquals(loginValue, "BjornPijpops");
    }

    @Test
    public void returnsCorrectID() throws IOException, ParseException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/users/BjornPijpops");
        response = client.execute(get);

        String jsonBody = EntityUtils.toString(response.getEntity());

        JSONObject jsonObject = new JSONObject(jsonBody);

        Integer loginValue = (Integer) getValueFor(jsonObject, ID);
        assertEquals(loginValue, 24245661);
    }

    private Object getValueFor(JSONObject jsonObject, String key) {
        return jsonObject.get(key);
    }
}
