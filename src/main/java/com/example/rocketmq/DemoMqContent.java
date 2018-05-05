package com.example.rocketmq;

import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqContent;

import java.util.UUID;

public class DemoMqContent extends RocketMqContent {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

}
