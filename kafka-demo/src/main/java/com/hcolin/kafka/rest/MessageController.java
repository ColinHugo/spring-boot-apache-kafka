package com.hcolin.kafka.rest;

import com.hcolin.kafka.payload.Student;
import com.hcolin.kafka.producer.KafkaJsonProducer;
import com.hcolin.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping( "/api/v1/mesagges" )
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity< String > sendMessage( @RequestBody String message ) {
        kafkaProducer.sendMessage( message );
        return ResponseEntity.ok().body( "Message queued successfully" );
    }

    @PostMapping( "/json" )
    public ResponseEntity< String > sendJsonMessage( @RequestBody Student student ) {
        kafkaJsonProducer.sendMessage( student );
        return ResponseEntity.ok().body( "Message queued successfully as JSON" );
    }

}