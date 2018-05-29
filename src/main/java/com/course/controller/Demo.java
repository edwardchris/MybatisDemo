package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: huangxiang
 * @create: 2018/5/28 19:25
 * @description:
 */

@RestController
@Api(value = "v1", description = "第一个版本的demo")
@RequestMapping("v1")
public class Demo {

    /**
     * 获取执行sql语句的对象
     */
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "获取到用户数", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "增加用户", httpMethod = "POST")
    public int addUser(@RequestBody User user) {
        return template.insert("addUser", user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "更改用户", httpMethod = "POST")
    public int updateUser(@RequestBody User user) {
        return template.update("updateUser",user);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    @ApiOperation(value = "删除用户",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }


}
