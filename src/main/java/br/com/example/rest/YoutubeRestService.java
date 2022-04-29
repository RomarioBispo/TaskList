package br.com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class YoutubeRestService {
	
	@Value("${youtube.api.key}")
	private String apiKey;
	
	@Autowired
	private WebClient webClient;

	public String requestVideosByChannelId(String channelId) {
		
		Mono<String> entityMono = webClient.get()
			     .uri(uriBuilder -> uriBuilder
			    		    .path("/youtube/v3/search")
			    		    .queryParam("channelId", channelId)
			    		    .queryParam("key", apiKey)
			    		    .build())
			     .accept(MediaType.APPLICATION_JSON)
			     .exchangeToMono(response -> {
			         if (response.statusCode().equals(HttpStatus.OK)) {
			             return response.bodyToMono(String.class);
			         }
			         else {
			             return response.createException().flatMap(Mono::error);
			         }
			     });
		return entityMono.block();
	}
	
}
