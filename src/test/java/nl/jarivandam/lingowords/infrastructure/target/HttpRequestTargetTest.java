package nl.jarivandam.lingowords.infrastructure.target;

import com.pgssoft.httpclient.HttpClientMock;
import nl.jarivandam.lingowords.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Http Request Target")
public class HttpRequestTargetTest {
    @Test
    public void verifyHttpRequest(){

        String url = "http://localhost/words";
        HttpClientMock mocktHttpClient = new HttpClientMock();
        mocktHttpClient.onPost(url).doReturnJSON("{\n" +
                "  \"id\": 1,\n" +
                "  \"word\": \"hallo\"\n" +
                "}").withStatus(200);
        HttpRequestTarget target = new HttpRequestTarget(url, mocktHttpClient);

        target.saveWord(new Word("hello"));

        mocktHttpClient.verify().post("http://localhost/words").called();
    }
}
