package nl.jarivandam.lingowords.infrastructure.target;

import nl.jarivandam.lingowords.domain.Word;
import nl.jarivandam.lingowords.domain.WordTarget;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class HttpRequestTarget implements WordTarget {
    private String urlString;
    private HttpClient httpClient;

    public HttpRequestTarget(String url,HttpClient httpClient){
        this.urlString = url;
        this.httpClient = httpClient;
    }
    @Override
    public void saveWord(Word word)  {
        URI uri = null;
        try {
            uri = new URI(this.urlString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String jsonOutput = "{ \"word\" : \"" + word.getWord() +"\"}";

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(jsonOutput))
                .header("Content-type", "application/json")
                .build();
        HttpResponse<String> response = null;
        try {
            response = this.httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (response.statusCode() != 200) {
            System.out.println(response.body());
        }

    }
}
