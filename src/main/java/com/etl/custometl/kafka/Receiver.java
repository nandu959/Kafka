package com.etl.custometl.kafka;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * @author anand
 *
 */
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	} 

	@KafkaListener(topics = "member-poc" )
	public void receive(String payload) {
		latch.countDown();
		System.out.println("Kafka Payload: "+payload);
	}
}
