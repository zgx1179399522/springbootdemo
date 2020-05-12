package com.zgx.springbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {

    private int id;
    private String name;
    private int age;
    private String address;
}
