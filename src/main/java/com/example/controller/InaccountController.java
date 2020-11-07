package com.example.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.Inaccount;
import com.example.entity.Outaccount;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.InaccountService;
import com.example.util.JWTUtils;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.Math.log;

/**
 * <p>
 * 收入信息表 前端控制器
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@RestController
@RequestMapping("/inaccount")
public class InaccountController {

    @Autowired
    InaccountService inaccountService;

    @Autowired
    private RedisUtil redisUtil;

    static Logger logger = Logger.getLogger(String.valueOf(InaccountController.class));

    /**
     * 模糊查询
     */
    @PostMapping("/getInaccountLike")
    public Result getInaccountLike(Inaccount inaccount,HttpServletRequest request){
        System.out.println(inaccount);
        String token = request.getHeader("token"); //从头部信息中获取token
        inaccount.setUser_id(JWTUtils.user_id(token));
        return inaccountService.getInaccountLike(inaccount);
    }

    /**
     * 记录列表
     */
    @PostMapping("/inaccountAll")
    public List<Inaccount> inaccountAll(HttpServletRequest request){
        String token = request.getHeader("token"); //从头部信息中获取token
        List<Inaccount> list = inaccountService.inaccountAll(JWTUtils.user_id(token));
        return list;
    }

    /**
     * 删除记录
     */
    @RequestMapping("/inaccountDelete")
    public String inaccountDelete(Integer id,HttpServletRequest request){
        String token = request.getHeader("token"); //从头部信息中获取token
        return inaccountService.inaccountDelete(id,JWTUtils.user_id(token));
    }


    /**
     * 添加记录
     */
    @RequestMapping("/inaccountNew")
    public String inaccountNew(Inaccount inaccount,HttpServletRequest request){
        String token = request.getHeader("token");
        inaccount.setUser_id(JWTUtils.user_id(token));
        System.out.println(inaccount);
        return inaccountService.inaccountNew(inaccount);
    }

    /**
     * 修改记录
     */
    @RequestMapping("/inaccountUpdate")
    public String inaccountUpdate(Inaccount inaccount,HttpServletRequest request){
        System.out.println(inaccount);
        String token = request.getHeader("token");
        return inaccountService.inaccountUpdate(inaccount,JWTUtils.user_id(token));
    }
}
