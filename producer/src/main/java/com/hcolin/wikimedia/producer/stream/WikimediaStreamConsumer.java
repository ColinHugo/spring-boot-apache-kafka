package com.hcolin.wikimedia.producer.stream;

import com.hcolin.wikimedia.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer producer;

    public WikimediaStreamConsumer( WebClient.Builder webClientBuilder, WikimediaProducer producer) {
        this.webClient = webClientBuilder
                .baseUrl( "https://stream.wikimedia.org/v2" )
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish() {
        webClient
                .get()
                .uri( "/stream/recentchange" )
                .retrieve()
                .bodyToFlux( String.class )
                // .subscribe( System.out::println );
                .subscribe( producer::sendMessage );
    }

}