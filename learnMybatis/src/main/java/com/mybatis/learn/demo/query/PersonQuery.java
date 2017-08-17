package com.mybatis.learn.demo.query;

import com.mybatis.learn.demo.model.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonQuery {
    Person getPerson(Integer pid);
    Person getPersonById(Integer id);
    void updatePersonName(@Param("pId") Integer pId, @Param("pName") String pName);
    void updatePersonByPerson(Person person);
    List<Person> selectPersonByforeach(List<Integer> ids);
    void insertBatchPerson(@Param("persons") List<Person> persons);
    List<Person> selectPersonLike(Person person);

}
