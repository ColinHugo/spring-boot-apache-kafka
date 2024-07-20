package com.hcolin.wikimedia.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WikimediaConsumer {

    @KafkaListener( topics = "wikimedia-stream", groupId = "myGroup" )
    public void consumeMsg( String msg ) {
        log.info( "Consume msg from wikimedia-stream topic: {}", msg );
    }

}