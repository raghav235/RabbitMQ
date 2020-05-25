package com.rabbitmq.demo.MP.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	@Value("${rabbitmq.routingkey}")
	private String routingKey;
	@Value("${rabbitmq.queue}")
	private String queue;
	
	public void produceMessage(String msg){
		rabbitTemplate.convertAndSend(exchange, routingKey, msg);
		System.out.println("Send Message"+msg);
	}
	
	@Bean
	Queue queue(){
		return new Queue(queue, false);
	}
	
	@Bean
	TopicExchange exchange(){
		return new TopicExchange(exchange);
	}
	@Bean
	Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
	
	
}
