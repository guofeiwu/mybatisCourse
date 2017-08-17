package com.mybatis.learn.demo.testApplication;


import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.model.Person;
import com.mybatis.learn.demo.query.MessageQuery;
import com.mybatis.learn.demo.query.PersonQuery;
import com.mybatis.learn.demo.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageService messageService;

    @Resource
    private MessageQuery messageQuery;

    @Resource
    private PersonQuery personQuery;


    @Test
    public void testInsertBatchPerson(){
        Person person = new Person();
        person.setName("Person1");
        person.setAge(21);
        person.setAddress("Shanghai1");

        Person person1 = new Person();
        person1.setName("Person2");
        person1.setAge(22);
        person1.setAddress("Shanghai2");

        personQuery.insertBatchPerson(Arrays.asList(person,person1));

    }


    @Test
    public void testSelectPerson(){
        List<Person> persons = personQuery.selectPersonByforeach(Arrays.asList(1,2));
        logger.info("person={}" ,persons);
    }

    @Test
    public void testUpdatePersonByPerson(){
        Person person = new Person();
        person.setPid(3);
        person.setName("Alice");
        person.setAddress("NanChang");
        person.setAge(30);
        personQuery.updatePersonByPerson(person);
    }




    @Test
    public void testUpdatePerson(){
        personQuery.updatePersonName(3,"Jerry");
    }
    @Test
    public void testMessageByPersonId(){
//        Person person = personQuery.getPersonById(1);
//        logger.info("person={}",person);
//        logger.info("person={}" ,person.getMessages());
        List<Message> message = messageQuery.getMessageListp(1);
        logger.info("person={}",message);

    }

    @Test
    public void testMessageQuery1(){
        Message message = messageQuery.getMessageById(1);

        System.out.println(message);
        Message message2 = messageQuery.getMessageById(1);
        System.out.println(message2);
        System.out.println(message == message2);
    }

    @Test
    public void testMessageByCommandAndId(){
        Message message = messageQuery.getMessageByCommandAndId(1,"查看");
        System.out.println(message);
        logger.info("message={}",message);
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
        List<Message> messages = messageQuery.getMessageListd("%精彩%");
        System.out.println(messages);
    }

    @Test
    public void testPersonLike(){
        Person person = new Person();
        person.setName("%e%");
        List<Person> persons = personQuery.selectPersonLike(person);
        logger.info("persons={}",persons);
    }


    @Test
    public void testMessageMap(){
        Map messageReturnLikeDescription = messageQuery.getMessageReturnLikeDescription("%精彩%");
        System.out.println(messageReturnLikeDescription);
    }

    @Test
    public void testPerson(){
        Person person = personQuery.getPerson(1);
        logger.info("person={}",person);
        logger.info("message={}",person.getMessages());

    }


    @Test
    public void testFindMessageById(){
        Message message = messageService.findMessageById(1);
        System.out.println("description: "+ message.getDescription()+",--id:"+message.getPid());
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
