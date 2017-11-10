package com.etl.custometl.kafka;

import java.io.Serializable;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;
import org.springframework.util.SerializationUtils;

/**
 * @author anand
 *
 * @param <T>
 */
public class CustomSerializer<T extends Serializable> implements Serializer<T> {
	
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, T data) {
		return SerializationUtils.serialize(data);
	}

	@Override
	public void close() {
	}
}
