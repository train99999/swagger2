package com.quan.swagger2.controller;

import com.quan.swagger2.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户数据接口")
public class UserController {

    // 方法描述
    @ApiOperation(value = "查询用户",notes = "根据用户ID查询用户")
    // 参数描述
    @ApiImplicitParam(name="userId",value = "用户Id",required = true,defaultValue = "99")
    @GetMapping("/user")
    public User getUserById(Integer userId){
        User user  = new User();
        user.setId(userId);
        return user;
    }

    @ApiOperation(value = "删除用户",notes = "根据用户Id删除用户")
    // 参数描述
    @ApiImplicitParam(name="id",value = "用户Id",required = true,defaultValue = "99")
    // 从请求路径中取出Id
    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Integer id){
        System.out.println(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value = "用户名"),
            @ApiImplicitParam(name = "id",value = "用户id")
    })
    @ApiOperation(value = "更新用户",notes = "根据用户ID更新用户名")
    @PutMapping("/user")
    public User updateUsernameById(String username,Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    @ApiOperation(value = "添加用户",notes = "传递JSON数据，添加用户")
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return user;
    }
}
