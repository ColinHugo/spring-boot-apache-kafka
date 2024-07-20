package com.hcolin.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate< String, String > kafkaTemplate;

    public void sendMessage( String msg ) {
        log.info( "Sending message to hcolin topic: {}", msg );
        kafkaTemplate.send( "hcolin", msg );
    }

}