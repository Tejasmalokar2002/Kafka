package com.example.Docker.service;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> thisIsTheDemoMsg = template.send("multiple", message);
        thisIsTheDemoMsg.whenComplete((result, ex)->{

            if(ex == null){
                System.out.println("Sent message=[" + message +
                        "] with offset=]" + result.getRecordMetadata().offset()+"]");
            }else {
                System.out.println("Unable to send message=]" + message+"] due to : " + ex.getMessage());
            }
        });
    }
}
