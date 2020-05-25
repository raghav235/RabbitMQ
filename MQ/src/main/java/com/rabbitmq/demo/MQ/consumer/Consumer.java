package com.rabbitmq.demo.MQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@RabbitListener(queues="${rabbitmq.queue}")
	public void receiveMessage(String msg){
		System.out.println("Received message "+msg);
		
	}

}
