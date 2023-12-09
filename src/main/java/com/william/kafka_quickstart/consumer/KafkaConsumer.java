package com.william.kafka_quickstart.consumer;

import com.william.kafka_quickstart.entity.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaConsumer {

    /**
     * `@KafkaListener`: enable this method as a listener by specifying topic name, partition and offset, so whenever
     *                   the message has been sent to this specific topic and partition, it will receive the message
     */
    @KafkaListener(
            topics = "topic1",
            topicPartitions = {
                    @TopicPartition(
                            topic = "topic1",
                            partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "0")
                    ),
            },
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume1(KafkaMessage message) {
        log.info("[consume1] consumed message: {}", message);
    }


    /**
     * We can create multiple listener(consumer) to listen different topics or partitions
     */
    @KafkaListener(
            topics = "topic2",
            topicPartitions = {
                    @TopicPartition(
                            topic = "topic2",
                            partitionOffsets = @PartitionOffset(partition = "2", initialOffset = "0")
                    ),
            },
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume2(KafkaMessage message) {
        log.info("[consume2] consumed message: {}", message);
    }

}
