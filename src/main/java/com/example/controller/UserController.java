package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Result;

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
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.rgister(user);
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        redisUtil.del("username");
        return "退出成功";
    }


}
