package com.zgx.springbootdemo.controller;

import com.zgx.springbootdemo.pojo.Result;
import com.zgx.springbootdemo.pojo.Teacher;
import com.zgx.springbootdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public Teacher getOne(@PathVariable Integer id){
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/")
    public Result add(@RequestBody Teacher teacher){
        try {
            teacherService.createTeach(teacher);
            return new Result(200,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"添加失败");
        }
    }

    @PutMapping("/")
    public Result update(@RequestBody Teacher teacher){
        try {
            teacherService.updateTeacher(teacher);
            return new Result(200,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400,"修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        try {
            teacherService.deleteTeacher(id);
            return new Result(200,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(200,"删除成功");
        }
    }
}
