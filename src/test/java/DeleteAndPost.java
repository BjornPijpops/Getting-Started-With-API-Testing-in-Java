import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.utils.Base64;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;

public class DeleteAndPost extends BaseClass{

    @Ignore
    @Test
    public void createRepoUsingBasicAuthReturns201() throws IOException {
        HttpPost request = new HttpPost("https://api.github.com/user/repos");

        // Basic Auth -- no longer supported for GitHub
        String auth = ""; //Credentials.EMAIL + ":" + Credentials.PASSWORD;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);
        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        //define JSON
        String json = "{\"name\": \"deletename\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        int actualStatusCode = response.getCode();

        assertEquals(actualStatusCode, 201);
    }

    @Test
    public void createRepoUsingTokenReturns201() throws IOException {
        HttpPost request = new HttpPost("https://api.github.com/user/repos");

        // token auth
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + "");

        //define JSON
        String json = "{\"name\": \"deletename\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        response = client.execute(request);

        int actualStatusCode = response.getCode();

        assertEquals(actualStatusCode, 201);
    }

    @Test
    public void deleteIsSuccessful() throws IOException {
        HttpDelete request = new HttpDelete("https://api.github.com/repos/BjornPijpops/deletename");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token " + "");

        response = client.execute(request);

        int actualStatusCode = response.getCode();

        assertEquals(actualStatusCode, 204);
    }
}
