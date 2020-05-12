package com.zgx.springbootdemo.mapper;

import com.zgx.springbootdemo.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    public List<Teacher> getAll();

    public void createTeach(Teacher teacher);
    //获取指定id用户信息
    public Teacher getTeacherById(Integer id);
    //更新指定id用户信息
    public void updateTeacher(Teacher teacher);
    //删除指定id用户
    public void deleteTeacher(Integer id);
}
