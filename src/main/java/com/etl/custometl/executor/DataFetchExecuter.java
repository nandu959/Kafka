package com.etl.custometl.executor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.etl.custometl.config.SenderConfig;
import com.etl.custometl.kafka.Sender;

/**
 * @author anand
 *
 */
public class DataFetchExecuter implements Runnable {

	private int personId;
	public DataFetchExecuter(int personId) {
		this.personId = personId;
	}

	@Override
	public void run() {
		processPersonId(personId);
	}

	public void processPersonId(int id) {
		String data = callPersonWS(id);

		ApplicationContext context = new AnnotationConfigApplicationContext(SenderConfig.class);
		Sender sender  = (Sender) context.getBean("sender");
		
		sender.send(data);
	}
	public String callPersonWS(int personId){
		String data = "Received person Id:"+personId;
		System.out.println(data);
		return data;
	}

}
