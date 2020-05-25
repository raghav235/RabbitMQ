package com.rabbitmq.demo.MP.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.demo.MP.producer.Producer;

@RestController
public class ProducerController {
	@Autowired
	Producer producer;
	
	@RequestMapping("/send")
	public String sendMessage(@RequestParam("msg") String msg){
		producer.produceMessage(msg);
		return "Message Sent";
	}
	
}
