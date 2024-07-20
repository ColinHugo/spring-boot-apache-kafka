package com.hcolin.kafka.consumer;

import com.hcolin.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    // @KafkaListener( topics = "hcolin", groupId = "myGroup" )
    public void consumeMsg( String msg ) {
        log.info( "Consume msg from hcolin topic: {}", msg );
    }

    @KafkaListener( topics = "hcolin", groupId = "myGroup" )
    public void consumeJsonMsg( Student student ) {
        log.info( "Consume msg from hcolin topic: {}", student.toString() );
    }

}