package com.sunwx.springbootrabbitmq.service;

import com.sunwx.springbootrabbitmq.bean.Books;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @RabbitListener(queues = "overTop.news")
    public void receive(Books books){
        System.out.println("收到的消息："+books);
    }
    @RabbitListener(queues = "overTop.news")
    public void receive2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
