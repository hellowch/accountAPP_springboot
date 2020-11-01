package com.example.service;

import com.example.entity.Inaccount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Outaccount;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.mapper.InaccountMapper;
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
    public List<Inaccount> inaccountAll(){
        return inaccountMapper.inaccountAll();
    }

    /**
     * 删除记录
     */
    public void inaccountDelete(Integer id){
        inaccountMapper.inaccountDelete(id);
    }

    /**
     * 添加记录
     */
    public void inaccountNew(Inaccount inaccount){
        inaccountMapper.inaccountNew(inaccount);
    }

    /**
     * 修改记录
     */
    public void inaccountUpdate(Inaccount inaccount){
        inaccountMapper.inaccountUpdate(inaccount);
    }
}
