package com.william.kafka_quickstart.controller;

import com.william.kafka_quickstart.entity.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class KafkaProducerController {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @PostMapping("/message")
    public void produceMessage(@RequestBody KafkaMessage message){
        kafkaTemplate.send(message.getTopicName(), message.getPartition(), message.getMessageKey(), message);
        log.info("Message is sent! Message: {}", message);
    }

}
