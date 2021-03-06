package com.mybatis.learn.demo.model;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("AMessage")
public class Message{
    private Integer id;

    private String command;

    private String description;

    private String content;

    private Integer pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command == null ? null : command.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", pid=" + pid +
                '}';
    }
}