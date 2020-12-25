package com.example.controller;

import com.example.entity.Inaccount;
import com.example.entity.Memo;
import com.example.service.MemoService;
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
 * 便签内容
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-12-25
 */
@RestController
@RequestMapping("/memo")
public class MemoController {

    @Autowired
    MemoService memoService;

    static Logger logger = Logger.getLogger(String.valueOf(MemoController.class));

    /**
     * 便签内容列表
     */
    @RequestMapping("/memoAll")
    public List<Memo> memoAll(HttpServletRequest request){
        String token = request.getHeader("token"); //从头部信息中获取token
        List<Memo> list = memoService.memoAll(JWTUtils.user_id(token));
        return list;
    }
}
