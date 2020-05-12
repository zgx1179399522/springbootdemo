package com.zgx.springbootdemo.controller;

import com.zgx.springbootdemo.pojo.Result;
import com.zgx.springbootdemo.pojo.Teacher;
import com.zgx.springbootdemo.service.Teacher_mybatis_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher_mybatis")
public class Teacher_Mybatis_Controller {

    @Autowired
    private Teacher_mybatis_Service mybatisService;


    @GetMapping("/")
    public List<Teacher> getAll(){
        return mybatisService.getAll();
    }

    @GetMapping("/{id}")
    public Teacher getOne(@PathVariable Integer id){
        return mybatisService.getTeacherById(id);
    }

    @PostMapping("/")
    public Result add(@RequestBody Teacher teacher){
        try {
            mybatisService.createTeach(teacher);
            return new Result(200,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"添加失败");
        }
    }

    @PutMapping("/")
    public Result update(@RequestBody Teacher teacher){
        try {
            mybatisService.updateTeacher(teacher);
            return new Result(200,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        try {
            mybatisService.deleteTeacher(id);
            return new Result(200,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(200,"删除成功");
        }
    }
}
