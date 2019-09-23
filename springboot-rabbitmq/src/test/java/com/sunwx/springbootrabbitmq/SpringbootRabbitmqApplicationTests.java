package com.sunwx.springbootrabbitmq;

import com.sunwx.springbootrabbitmq.bean.Books;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    public void contextLoads() {
        //Message需要自己构造一个。定义消息体内容和消息头
       //rabbitTemplate.send(exange,routingKey,massage);
        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,rountingKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","第一个消息");
        map.put("data", Arrays.asList("helloworld",122,true));
        //对象被默认序列化后发送出去
        //对象被默认序列化后发送出去
        rabbitTemplate.convertAndSend("exchange-direct","overTop",map);
    }
    //接受数据，将数据自动转化为json发送出去
    @Test
    public void receive(){
        Message overTop = rabbitTemplate.receive("overTop");
        System.out.println(overTop.getClass());
        System.out.println(overTop);

    }
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange-topic","overTop.news", new Books(1,"红楼梦","曹雪芹"));
    }
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,
                "amqpAdmin.exchange","amqp.hah",null));
    }

}
