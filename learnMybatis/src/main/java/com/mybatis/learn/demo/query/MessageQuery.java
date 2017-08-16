package com.mybatis.learn.demo.query;


import com.mybatis.learn.demo.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MessageQuery {
    List<Map> queryAll();
    Map queryOneById(int id);
    Message getMessageById(int id);
}
