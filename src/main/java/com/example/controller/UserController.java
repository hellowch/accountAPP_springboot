package com.example.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.JWTUtils;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Result;

import javax.servlet.http.HttpServletRequest;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public Result register(@RequestBody User user){
        System.out.println(user);
        return userService.rgister(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {

        String token = request.getHeader("token"); //从头部信息中获取token
        DecodedJWT verify = JWTUtils.verify(token);
        String id = String.valueOf(verify.getClaim("id").asString());  //从token中获取id信息
        System.out.println(id);
        redisUtil.hdel("token",id);  //通过id在redis的哈希表中删除对应token
        return "退出成功";
    }

}
