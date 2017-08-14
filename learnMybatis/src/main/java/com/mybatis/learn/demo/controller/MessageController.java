package com.mybatis.learn.demo.controller;


import com.mybatis.learn.demo.model.Message;
import com.mybatis.learn.demo.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Resource
    private MessageService messageService;

    @GetMapping("/get/{id}")
    public Message getMessage(@PathVariable int id){
        //System.out.println("id: "+id);
        return messageService.findMessageById(id);
    }
}
