package com.carolyn.controller;

//import cn.hutool.core.lang.Assert;
import org.springframework.util.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.carolyn.common.Result;
import com.carolyn.dto.LoginDto;
import com.carolyn.entity.User;
import com.carolyn.service.UserService;
import com.carolyn.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @projectName: blog
 * @package: com.carolyn.controller
 * @className: AccountController
 * @author: Carolyn
 * @description: 登录接口
 * @date: 2023/3/2 12:18
 */
@RestController
public class AccountController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param loginDto
     * @param httpServletResponse
     * @return
     */
    @CrossOrigin
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse httpServletResponse){
        //根据用户名查找用户
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>().eq("username",loginDto.getUsername());
        User user =userService.getOne(queryWrapper);
        Assert.notNull(user,"用户不存在");
        //比对密码
        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码错误！");
        }
        //根据id生成jwt
        String jwt = jwtUtils.generateToken(user.getId());
        //将jwt放在header上
        httpServletResponse.setHeader("Authorization",jwt);
        httpServletResponse.setHeader("Access-Control-Expose-Headers","Authorization");
        //用户可以另一个接口
        return Result.success(MapUtil.builder().put("id",user.getId())
                .put("username",user.getUsername())
                .put("avatar",user.getAvatar())
                .put("email",user.getEmail())
                .map()
        );
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }
}
