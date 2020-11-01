package com.example.controller;


import com.example.entity.Inaccount;
import com.example.entity.Outaccount;
import com.example.entity.Result;
import com.example.service.InaccountService;
import com.example.service.OutaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
    public Result getOutaccountLike(String value){
        return outaccountService.getOutaccountLike(value);
    }

    /**
     * 记录列表
     */
    @PostMapping("/outaccountAll")
    public List<Inaccount> outaccountAll(){
        List<Inaccount> list = outaccountService.outaccountAll();
        return list;
    }

    /**
     * 删除记录
     */
    @RequestMapping("/outaccountDelete")
    public void outaccountDelete(Integer id){
        outaccountService.outaccountDelete(id);
    }

    /**
     * 添加记录
     */
    @RequestMapping("/outaccountNew")
    public void outaccountNew(Outaccount outaccount){
        outaccountService.outaccountNew(outaccount);
    }

    /**
     * 修改记录
     */
    @RequestMapping("/outaccountUpdate")
    public void outaccountUpdate(Outaccount outaccount){
        System.out.println(outaccount);
        outaccountService.outaccountUpdate(outaccount);
    }

}
