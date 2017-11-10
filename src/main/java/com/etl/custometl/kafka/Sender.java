package com.etl.custometl.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author anand
 *
 */
@PropertySource("classpath:env.properties")
public class Sender {

	@Autowired
	private Environment env;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String topic, String payload) {
		//LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
		kafkaTemplate.send(topic, payload);
	}

	public void send(String payload) {
		kafkaTemplate.send(env.getProperty("sender-topic"), payload);
	}
}
