package com.kafka.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.request.TransactionDetails;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class MessageProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/publish")
    public void sendMessage(@RequestBody TransactionDetails entity) {
        logger.info("Entity in /publish :: {}", entity);
        try {
            int prt = 0;
            if ("false".equals(entity.getStatus()))
                prt = 1;
            kafkaTemplate.send("transactionTopic", prt, null, entity.toString());
        } catch (Exception e) {
            logger.error("Error in /publish :: {}", e.getMessage());
        }
    }
}
