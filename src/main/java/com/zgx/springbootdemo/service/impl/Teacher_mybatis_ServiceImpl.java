package com.zgx.springbootdemo.service.impl;

import com.zgx.springbootdemo.mapper.TeacherMapper;
import com.zgx.springbootdemo.pojo.Teacher;
import com.zgx.springbootdemo.service.Teacher_mybatis_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Teacher_mybatis_ServiceImpl implements Teacher_mybatis_Service {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }

    @Override
    public void createTeach(Teacher teacher) {
        teacherMapper.createTeach(teacher);
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Integer id) {
        teacherMapper.deleteTeacher(id);
    }
}
