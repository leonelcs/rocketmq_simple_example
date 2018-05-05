package com.example.rocketmq;

import io.github.rhwayfun.springboot.rocketmq.starter.common.DefaultRocketMqProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

@Component
public class DemoRocketMqProducerExample {

    @Resource
    private DefaultRocketMqProducer producer; //this bean is provided by default.

    private DemoMqTopic topic = new DemoMqTopic();

    @PostConstruct
    public void execute() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                DemoMqContent content = new DemoMqContent();
                content.setId(UUID.randomUUID());
                content.setDesc("城市");
                Message msg = new Message(topic.getTopic(), "test-tag", content.toString().getBytes());
                boolean sendResult = producer.sendMsg(msg);
                System.out.println("发送结果：" + sendResult);
            }
        }, 0, 10000);
    }

}
