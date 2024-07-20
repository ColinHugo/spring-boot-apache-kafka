package com.hcolin.kafka.producer;

import com.hcolin.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaJsonProducer {

    private final KafkaTemplate< String, Student > kafkaTemplate;

    public void sendMessage( Student student ) {

        Message< Student > message = MessageBuilder
                .withPayload( student )
                .setHeader( KafkaHeaders.TOPIC, "hcolin" )
                .build();

        kafkaTemplate.send( message );

    }

}