package com.zgx.springbootdemo.service.impl;

import com.zgx.springbootdemo.pojo.Teacher;
import com.zgx.springbootdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Teacher> getAll() {
        return jdbcTemplate.query("select * from teacher",new BeanPropertyRowMapper(Teacher.class));
    }

    @Override
    public void createTeach(Teacher teacher) {
        jdbcTemplate.update("insert into teacher(id,name,age,address) values (?,?,?,?)",null,teacher.getName(),teacher.getAge(),teacher.getAddress());
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        Teacher teacher = new Teacher();
        jdbcTemplate.query("select * from teacher where id=" + id, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                teacher.setId(resultSet.getInt("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setAge(resultSet.getInt("age"));
                teacher.setAddress(resultSet.getString("address"));
            }
        });
        System.out.println(teacher);
        return teacher;
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        jdbcTemplate.update("update teacher set name = ? where id= ?",teacher.getName(),teacher.getId());
    }

    @Override
    public void deleteTeacher(Integer id) {
        jdbcTemplate.update("delete from teacher where id = ?",id);
    }
}
