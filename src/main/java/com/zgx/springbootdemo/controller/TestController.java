package com.zgx.springbootdemo.controller;

import com.zgx.springbootdemo.pojo.Car;
import com.zgx.springbootdemo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({Car.class, Person.class})
public class TestController {

    @Value("${offcn_id}")
    private String offcnId;

    @Value("${offcn_name}")
    private String offcnName;

    @Autowired
    private Car car;

    @Autowired
    private Person person;

    @RequestMapping("/test")
    public String getValue(){
        return offcnId+"---"+offcnName;
    }

    @RequestMapping("/getCar")
    public Car getCar(){
        return car;
    }

    /*@RequestMapping("/getPerson")
    public String getPerson(){
        return person.toString();
    }*/
}
