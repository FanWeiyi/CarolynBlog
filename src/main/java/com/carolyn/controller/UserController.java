package com.carolyn.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.carolyn.entity.User;
import com.carolyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Carolyn
 * @since 2023-03-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 测试
     */
//    @GetMapping("/index")
//    public Object index(){
////        return userService.getById(1L);
//        //test
//        return "hello";
//    }

    /**
     * 测试实体校验
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Object testUser(@Validated @RequestBody User user) {
        return user.toString();
    }
}
