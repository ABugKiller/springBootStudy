package com.didispace.product;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZhengYingDeng
 * @email 892467242@qq.com
 * @create 20:34 2018/6/19
 **/
@Component
public class Sender {
    @Autowired(required = false)
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender:" + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
