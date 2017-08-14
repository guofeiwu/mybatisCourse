package com.mybatis.learn.demo.service.impl;

import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.model.mapper.MessageMapper;
import com.mybatis.learn.demo.query.MessageQuery;
import com.mybatis.learn.demo.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Resource
    private MessageQuery messageQuery;
    @Override
    public List<Message> getAllMessage() {
        /**
         * 多表查询返回map
         */
        List<Map> maps = messageQuery.queryAll();

        List<Message> messages = new ArrayList<>();
        for(Map map:maps){
            Message message = new Message();
            int id = (int) map.get("ID");
            String command = (String) map.get("COMMAND");
            String description = (String) map.get("DESCRIPTION");
            String content = (String) map.get("CONTENT");
            int p_id = (int) map.get("P_ID");
            message.setId(id);
            message.setCommand(command);
            message.setDescription(description);
            message.setContent(content);
            message.setpId(p_id);
            messages.add(message);
        }
        return messages;
    }

    @Override
    public Message findMessageById(int id) {
        if(messageMapper == null){
            System.out.println("messageMapper is null ... ");
            return null;
        }
        return messageMapper.selectByPrimaryKey(id);
    }
}
