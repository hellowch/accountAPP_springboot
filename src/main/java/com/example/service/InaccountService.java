package com.example.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.Inaccount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Outaccount;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.mapper.InaccountMapper;
import com.example.util.JWTUtils;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 收入信息表 服务类
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Service
public class InaccountService {

    @Autowired
    InaccountMapper inaccountMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     *模糊查询
     */
    public Result getInaccountLike(Inaccount inaccount){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            inaccountMapper.getInaccountLike(inaccount);
            result.setMsg("查询成功");
            result.setSuccess(true);
            result.setDetail(inaccountMapper.getInaccountLike(inaccount));
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询全部记录
     */
    public List<Inaccount> inaccountAll(Integer user_id){
        return inaccountMapper.inaccountAll(user_id);
    }

    /**
     * 删除记录
     */
    public String inaccountDelete(Integer id,Integer user_id){
        if (inaccountMapper.idSelectUser(id) == user_id){
            inaccountMapper.inaccountDelete(id);
            return "删除成功";
        }else {
            return "这是别人的账单哦！";
        }
    }

    /**
     * 添加记录
     */
    public String inaccountNew(Inaccount inaccount){
        inaccountMapper.inaccountNew(inaccount);
        return "添加成功！";
    }

    /**
     * 修改记录
     */
    public String inaccountUpdate(Inaccount inaccount,Integer user_id){
        if (inaccountMapper.idSelectUser(inaccount.getId()) == user_id){
            inaccountMapper.inaccountUpdate(inaccount);
            return "修改成功！";
        }else {
            return "这是别人的消费记录哦！";
        }
    }
}
