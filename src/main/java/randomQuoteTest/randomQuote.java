package randomQuoteTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class randomQuote {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		Quote quote = new Quote();
		
		Gson gson = new Gson();
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest getRequest = HttpRequest.newBuilder()
				.uri(new URI("https://api.quotable.io/random"))
				.build();
		
		HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
			
		quote = gson.fromJson(getResponse.body(), Quote.class);
		System.out.println("\"" + quote.getContent() + "\"\n- " + quote.getAuthor());
		
	}

}
