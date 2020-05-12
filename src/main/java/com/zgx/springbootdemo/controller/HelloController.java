package com.zgx.springbootdemo.controller;

import com.zgx.springbootdemo.pojo.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Validated
public class HelloController {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping("/get")
    public Student getStudent(){
        Student student = new Student(1,"zhende",new Date());
        return student;
    }

    @RequestMapping("/getAll")
    public String getALL(String name){
        return name;
    }

    @RequestMapping("/getStudent")
    public Student getStudent(String name){
        Student student = new Student();
        student.setName(name);
        return student;
    }


    @RequestMapping("/getStudentList")
    public List<Student> getStudentList(){
        ArrayList<Student> arrayList = new ArrayList<Student>();
        Student student = new Student(1,"小飞",new Date());
        Student student1 = new Student(2,"小池",new Date());
        Student student2 = new Student(3,"小网",new Date());

        arrayList.add(student);
        arrayList.add(student1);
        arrayList.add(student2);
        return arrayList;
    }

    @RequestMapping("/getShuJu/{name}")
    public String getshuju(@PathVariable String name,String address){

        return name+"----"+address;
    }

    @RequestMapping("/getShuJu1/{name}")
    public String getshuju1(@PathVariable(name = "name") String username,String address){

        return username+"----"+address;
    }

    @RequestMapping("/getJson")
    public Student getJson(@RequestBody Student student){
        return student;
    }

    @RequestMapping("/getValid/{name:[a-zA-Z0-9_]+}")
    public String getValid(@PathVariable String name){
        return name;
    }

    @RequestMapping("/getValid1")
    public String getValid1(@NotBlank(message = "不能为空")@Email(message = "格式错误") String email){
        return email;
    }


    @RequestMapping("/Valid2")
    public Student Valid2(@RequestBody@Validated Student student){
        return student;
    }


}
