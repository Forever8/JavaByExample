package com.javabyexample.kafka.service;

import com.javabyexample.kafka.common.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {
    private final Logger logger = LoggerFactory.getLogger(KafKaConsumerService.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(String message) {
        logger.info(String.format("Message received -> %s", message));
    }
}
