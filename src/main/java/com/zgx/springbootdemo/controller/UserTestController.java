package com.zgx.springbootdemo.controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.zgx.springbootdemo.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserTestController {

    private List<User> listUser=Collections.synchronizedList(new ArrayList<User>());

    @GetMapping("/")
    public List<User> getList(){
        return listUser;
    }

    @GetMapping("/{id}")
    public User getListById(@PathVariable Integer id){
        for (User user : listUser) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return new User();
    }

    @PostMapping("/")
    public String setList(@RequestBody User user){
        listUser.add(user);
        return "success";
    }

    @PutMapping("/")
    @ApiOperation(value = "根据id更新信息")
    @ApiImplicitParam(name = "user",value = "实体类user",required = true,dataType = "User")
    public String updateList(@RequestBody User user){
        for (User user1 : listUser) {
            if (user1.getId().equals(user.getId())){
                user1.setId(user.getId());
                user1.setName(user.getName());
                user1.setAddress(user.getAddress());
            }
        }
        return "Update success";
    }

    @DeleteMapping("/{id}")
    public String deleteList(@PathVariable Integer id){
        listUser.remove(getListById(id));
        return "Delete success";
    }


}
