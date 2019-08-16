package com.iankuduffo.funcoder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author Ankush Mohapatra
 */

@SpringBootApplication
@EnableScheduling
public class BasicStuffsApplication implements SchedulingConfigurer{
	
	private static final Logger LOGGER = LogManager.getLogger(BasicStuffsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BasicStuffsApplication.class, args);
	}

	// dynamic initialization the CRON expression
	private String cronExp() {
		return "* * * ? * *";
	}


	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(() -> {

			// do your job here (implement the business logic which is to be scheduled)
			LOGGER.info("Scheduler Running...");

		}, (TriggerContext triggerContext) -> 
		new CronTrigger(cronExp()).nextExecutionTime(triggerContext)
				);
	}
	
}
