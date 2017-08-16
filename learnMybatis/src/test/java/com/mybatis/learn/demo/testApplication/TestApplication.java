package com.mybatis.learn.demo.testApplication;


import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.query.MessageQuery;
import com.mybatis.learn.demo.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    private MessageService messageService;

    @Resource
    private MessageQuery messageQuery;


    @Test
    public void testMessageQuery1(){
        Message message = messageQuery.getMessageById(1);
        System.out.println(message);
    }


    @Test
    public void testFindMessageById(){
        Message message = messageService.findMessageById(1);
        System.out.println("description: "+ message.getDescription()+",--id:"+message.getpId());
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
