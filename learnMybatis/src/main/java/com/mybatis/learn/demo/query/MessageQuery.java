package com.mybatis.learn.demo.query;


import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.model.Person;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface MessageQuery {
    List<Map> queryAll();
    Map queryOneById(int id);
    Message getMessageById(int id);
    Message getMessageByCommandAndId(@Param("id") Integer id, @Param("command") String command);
    Message getMessageByMap(Map map);
    Message getMessageByList(List<Integer> ids);
    List<Message> getMessageListd(String description);
    @MapKey("id")
    Map getMessageReturnLikeDescription(String description);
    //Map<Integer,Message> getMessageReturnLikeDescription(String description);
    List<Message> getMessageListp(Integer pid);


}
