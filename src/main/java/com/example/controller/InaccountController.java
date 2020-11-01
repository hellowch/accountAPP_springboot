package com.example.controller;


import com.example.entity.Inaccount;
import com.example.entity.Outaccount;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.InaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    static Logger logger = Logger.getLogger(String.valueOf(InaccountController.class));

    /**
     * 模糊查询
     */
    @PostMapping("/getInaccountLike")
    public Result getInaccountLike(String value){
        return inaccountService.getInaccountLike(value);
    }

    /**
     * 记录列表
     */
    @PostMapping("/inaccountAll")
    public List<Inaccount> inaccountAll(){
        List<Inaccount> list = inaccountService.inaccountAll();
        return list;
    }

    /**
     * 删除记录
     */
    @RequestMapping("/inaccountDelete")
    public void inaccountDelete(Integer id){
        inaccountService.inaccountDelete(id);
    }


    /**
     * 添加记录
     */
    @RequestMapping("/inaccountNew")
    public void inaccountNew(Inaccount inaccount){
        inaccountService.inaccountNew(inaccount);
    }

    /**
     * 修改记录
     */
    @RequestMapping("/inaccountUpdate")
    public void inaccountUpdate(Inaccount inaccount){
        System.out.println(inaccount);
        inaccountService.inaccountUpdate(inaccount);
    }
}
