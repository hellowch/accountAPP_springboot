package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.common.lang.Result;

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


//    @RequiresAuthentication
//    @GetMapping("/{id}")
//    public Result test(@PathVariable("id") Long id) {
//        User user = userService.getById(1L);
//        return Result.succ(user);
//    }

    //需要登录访问的注解
    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.succ(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user) {
        //@Validated用于校验User中的@NotBlank
        return Result.succ(user);
    }

    @PostMapping("/save11")
    public String save1() {
        //@Validated用于校验User中的@NotBlank
        return "okkk";
    }
}
