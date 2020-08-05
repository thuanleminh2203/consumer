package com.venesa.consumer.ConsumerCommon.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venesa.consumer.ConsumerCommon.dto.UserDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "queue_common")
    public <T> void listener(Message<T> message){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("===== mess ===" + message.getPayload().toString());
//        String data = objectMapper.readValue()
//        UserDTO userDTO = (UserDTO) message.getPayload();
        UserDTO userDTO = objectMapper.convertValue(message.getPayload(), UserDTO.class);

        System.out.println("=====receive messs ====" +  userDTO.toString());
    }
}
