package com.william.kafka_quickstart.controller;

import com.william.kafka_quickstart.entity.KafkaTopic;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/topic")
public class KafkaTopicController {

    private final KafkaAdmin kafkaAdmin;

    @PutMapping("/")
    public void createTopic(@RequestBody @Valid KafkaTopic topic){
        NewTopic newTopic = new NewTopic(topic.getName(), topic.getNumPartitions(), topic.getReplicationFactor());
        kafkaAdmin.createOrModifyTopics(newTopic);
        log.info("Topic(name: {}, partitions: {}, replicationFactor: {}) is created!", topic.getName(), topic.getNumPartitions(), topic.getReplicationFactor());
    }
}
