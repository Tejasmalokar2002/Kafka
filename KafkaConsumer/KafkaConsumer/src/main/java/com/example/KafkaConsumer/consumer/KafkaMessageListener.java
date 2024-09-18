package com.example.KafkaConsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "multiple", groupId = "demo-group")
    public void consume1(String message) {
        logger.info("Consumer1 consumed the message: {}", message);
    }

    @KafkaListener(topics = "multiple", groupId = "demo-group")
    public void consume2(String message) {
        logger.info("Consumer2 consumed the message: {}", message);
    }

    @KafkaListener(topics = "multiple", groupId = "demo-group")
    public void consume3(String message) {
        logger.info("Consumer3 consumed the message: {}", message);
    }

    @KafkaListener(topics = "multiple", groupId = "demo-group")
    public void consume4(String message) {
        logger.info("Consumer4 consumed the message: {}", message);
    }
}
