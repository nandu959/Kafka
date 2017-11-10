package com.etl.custometl.executor;

/**
 * @author anand
 *
 */
public class DataPushExecutor implements Runnable {

	private String messagePayload;
	public DataPushExecutor(String messagePayload) {
		this.messagePayload = messagePayload;
	}

	@Override
	public void run() {
		callES(messagePayload);
	}


	public String callES(String message){
		String data = "Received Message for ES :"+messagePayload;
		System.out.println(data);
		return data;
	}
}
