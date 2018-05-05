package com.example.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RocketmqApplication implements CommandLineRunner {

	@Autowired
	DemoMQConsumer consumer;

	@Autowired
	DemoRocketMqProducerExample producer;

	public static void main(String[] args) {
		SpringApplication.run(RocketmqApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        producer.execute();
        DemoMqContent content = new DemoMqContent();
        consumer.consumeMsg(content, new MessageExt());
    }
}
