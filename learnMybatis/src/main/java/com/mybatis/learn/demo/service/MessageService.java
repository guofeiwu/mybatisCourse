package com.mybatis.learn.demo.service;

import com.mybatis.learn.demo.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();
    Message findMessageById(int id);
}
