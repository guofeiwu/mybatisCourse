package com.mybatis.learn.demo.testApplication;


import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    private MessageService messageService;

    @Test
    public void testFindMessageById(){
        Message message = messageService.findMessageById(1);
        System.out.println("description: "+ message.getDescription());
    }


    @Test
    public void testFindAllMessage(){
        List<Message> allMessage = messageService.getAllMessage();
        Iterator<Message> iterator = allMessage.iterator();
        while (iterator.hasNext()){
            Message message = iterator.next();
            System.out.println("DESCRIPTION: "+message.getDescription()+"---COMMAND:   "+message.getCommand());
        }
    }

}
