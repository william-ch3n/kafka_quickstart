# Kafka Quickstart

@Author: William Ch3n  
This is just one simple project where I practice what I learnt about Kafka.

## Tech Stack
Spring Boot Web + Spring Kafka + Kafka + Kraft

## Architecture
- Sprint Boot Web: Export APIs to create Kafka Topic and send Message to Kafka
- Spring Kafka: Framework for implementing Java + Kafka easily
- Kafka + Kraft: Since zookeeper is going to fade out from native Kafka, I'd like to starting Kafka with kafka-native Kraft

## How to Install and Start Kafka Service in Local Machine

Ref: https://kafka.apache.org/quickstart

## How to Implement Spring Kafka
1. Set up and start kafka in your local machine(by following the instruction above)
2. Create configs for kafka admin, producer, consumer
   - Kafka Admin: for creating Topic programmatically
   - Kafka Producer: for sending message to Kafka service(server)
   - Kafka Consumer: for receiving and consuming the message from designated Topic
3. Create Kafka Consumer class, put @KafkaListener on any method to make it work as a consumer.  
   Note: the consumer class itself is not consumer, the method with annotation of "@KafkaListener" is!
4. Create RestController for Topic and Producer so that we can call the API to create topic or send message to Kafka server.

## How to Start Testing Spring Kafka
1. Start Kafka in your local machine
    ```bash
    $ cd ${kafka_home}
    $ bin/kafka-server-start.sh config/kraft/server.properties
    #By default, the host and port for kafka service is "localhost:9092"
    ```
2. Start this Spring Boot App
3. Call Topic API from postman to test creating topic. Request body:
    ```json
    {
      "name": "topic1",
      "numPartitions": 2,
      "replicationFactor": 1
    }
    ```
4. Call Producer API from postman to test sending message. Request body:
    ```json
   {
    "topicName": "topic1",
    "partition": 1,
    "messageKey": "m_3",
    "messageId": 3,
    "message": "test003",
    "generatedAt": "2023-12-09 20:48:00",
    "readFlg": false
   }
    ```