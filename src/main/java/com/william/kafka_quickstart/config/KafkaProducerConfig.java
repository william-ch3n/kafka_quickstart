package com.william.kafka_quickstart.config;

import com.william.kafka_quickstart.entity.KafkaMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;


    /**
     * Create a bean of ProducerFactory:
     *  The prototype for producer factory which is to set up properties for producer
     */
    @Bean
    public ProducerFactory<String, KafkaMessage> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // if the value is a java object, use JsonSerializer for it
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Create a bean of KafkaTemplate:
     *  KafkaTemplate is a kind of kafka producer responsible for sending message to kafka server
     */
    @Bean
    public KafkaTemplate<String, KafkaMessage> kafkaProducerTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
