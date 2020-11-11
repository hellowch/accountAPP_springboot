package com.example.controller;


import com.example.entity.Outaccount;
import com.example.entity.Result;
import com.example.service.OutaccountService;
import com.example.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

/**
 * <p>
 * 支出信息表 前端控制器
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@RestController
@RequestMapping("/outaccount")
public class OutaccountController {
    @Autowired
    OutaccountService outaccountService;

    static Logger logger = Logger.getLogger(String.valueOf(InaccountController.class));

    /**
     * 模糊查询
     */
    @PostMapping("/getOutaccountLike")
    public Result getOutaccountLike(Outaccount outaccount, HttpServletRequest request){
        System.out.println(outaccount);
        String token = request.getHeader("token"); //从头部信息中获取token
        outaccount.setUser_id(JWTUtils.user_id(token));
        return outaccountService.getOutaccountLike(outaccount);
    }

    /**
     * 记录列表
     */
    @PostMapping("/outaccountAll")
    public List<Outaccount> outaccountAll(HttpServletRequest request){

        String token = request.getHeader("token"); //从头部信息中获取token
        List<Outaccount> list = outaccountService.outaccountAll(JWTUtils.user_id(token));
        return list;
    }

    /**
     * 删除记录
     */
    @RequestMapping("/outaccountDelete")
    public Result outaccountDelete(Integer id,HttpServletRequest request){
        String token = request.getHeader("token"); //从头部信息中获取token
        return outaccountService.outaccountDelete(id,JWTUtils.user_id(token));
    }

    /**
     * 添加记录
     */
    @RequestMapping("/outaccountNew")
    public Result outaccountNew(Outaccount outaccount,HttpServletRequest request){
        String token = request.getHeader("token");
        outaccount.setUser_id(JWTUtils.user_id(token));
        return outaccountService.outaccountNew(outaccount);
    }

    /**
     * 修改记录
     */
    @RequestMapping("/outaccountUpdate")
    public Result outaccountUpdate(Outaccount outaccount,HttpServletRequest request){
        System.out.println(outaccount);
        String token = request.getHeader("token");
        return outaccountService.outaccountUpdate(outaccount,JWTUtils.user_id(token));
    }

}
