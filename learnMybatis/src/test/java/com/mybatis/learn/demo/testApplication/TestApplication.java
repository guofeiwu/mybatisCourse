package com.mybatis.learn.demo.testApplication;


import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.model.Person;
import com.mybatis.learn.demo.query.MessageQuery;
import com.mybatis.learn.demo.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;


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
    public void testMessageByCommandAndId(){
        Message message = messageQuery.getMessageByCommandAndId(1,"查看");
        System.out.println(message);
    }

    @Test
    public void testMessageByMap (){
        Map map = new HashMap();
        map.put("id",3);
        map.put("command","新闻");
        Message message = messageQuery.getMessageByMap(map);
        System.out.println(message);
    }

    //参数是一个list
    @Test
    public void testMessageByList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Message message = messageQuery.getMessageByList(list);
        System.out.println(message);
    }

    @Test
    public void testMessageReturnMap(){
        Map map = messageQuery.queryOneById(1);
        System.out.println(map);
    }


    @Test
    public void testMessageList(){
        // -- WHERE  DESCRIPTION LIKE '%' #{description} '%'
        List<Message> messages = messageQuery.getMessageList("%精彩%");
        System.out.println(messages);
    }


    @Test
    public void testMessageMap(){
        Map messageReturnLikeDescription = messageQuery.getMessageReturnLikeDescription("%精彩%");
        System.out.println(messageReturnLikeDescription);
    }

    @Test
    public void testPerson(){
        Person person = messageQuery.getPerson(1);
        System.out.println(person);
        //System.out.println(person.getMessages());
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
