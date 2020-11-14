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
    public Result inaccountDelete(Integer id,Integer user_id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if (inaccountMapper.idSelectUser(id) == user_id){
                inaccountMapper.inaccountDelete(id);
                result.setMsg("删除成功");
                result.setSuccess(true);
            }else {
                result.setMsg("删除失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 添加记录
     */
    public Result inaccountNew(Inaccount inaccount){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            inaccountMapper.inaccountNew(inaccount);
            result.setMsg("添加成功");
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改记录
     */
    public Result inaccountUpdate(Inaccount inaccount,Integer user_id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if (inaccountMapper.idSelectUser(inaccount.getId()) == user_id){
                inaccountMapper.inaccountUpdate(inaccount);
                result.setMsg("修改成功");
                result.setSuccess(true);
            }else {
                result.setMsg("修改失败");
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据type统计不同类型的总金额
     */
    public Result inaccountCount(Integer user_id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            result.setDetail(inaccountMapper.inaccountCount(user_id));
            result.setMsg("查询成功");
            result.setSuccess(true);
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
