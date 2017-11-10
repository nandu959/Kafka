package com.etl.custometl.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.etl.custometl.config.AppConfig;

/**
 * @author anand
 *
 */
@Component
public class Scheduler {

	TaskExecutor taskExecutor;
	
	@Scheduled(fixedDelay=2000)
	public void checkTransactionLog() {
		System.out.println("Called");
		Random rand = new Random();
		int  val = rand.nextInt(50) + 1;
		if(val>=25){
			taskExecutor.execute(new DataFetchExecuter(val));
		}
	}
	
	public List<Integer> checkTransactionLogTable(){
		List<Integer> persons = new ArrayList<Integer>();
		//Write DB code to fetch members from Transaction log table
		return persons;
	}

	@PostConstruct
	void start(){
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");
	}

}
