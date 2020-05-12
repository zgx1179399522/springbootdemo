package com.zgx.springbootdemo.controller;

import com.zgx.springbootdemo.pojo.Result;
import com.zgx.springbootdemo.pojo.Student;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidController {


    @RequestMapping("/valid3")
    public String valid3(@Validated Student student, BindingResult result){
        if (result.hasErrors()){
            Result result1 = new Result(200,result.getFieldError().getDefaultMessage());
            return result1.toString();
        }
        return student.toString();
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
