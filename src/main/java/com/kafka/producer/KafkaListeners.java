package com.kafka.producer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "transactionTopic", groupId = "groupId1")
    void listener(String data) {
        System.out.println("listener Received 1:" + data + "\n");
    }

    @KafkaListener(topics = "transactionTopic", groupId = "groupId1")
    void listener2(String data) {
        System.out.println("listener Received 2:" + data + "\n");
    }

    @KafkaListener(topics = "transactionTopic", groupId = "groupId2")
    void listener3(String data) {
        System.out.println("listener Received 3:" + data + "\n");
    }
}
