import org.apache.hc.client5.http.classic.methods.HttpOptions;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Options204 extends BaseClass{
    @Test
    public void optionsReturnsCorrectMethodList() throws IOException{
        String header = "access-control-allow-methods";
        String expectedReply = header + ": GET, POST, PATCH, PUT, DELETE";

        HttpOptions request = new HttpOptions(BASE_ENDPOINT);
        response = client.execute(request);

        String actualValue = String.valueOf(response.getFirstHeader(header));

        assertEquals(actualValue, expectedReply);
    }
}
