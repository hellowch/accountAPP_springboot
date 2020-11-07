package com.example.service;

import com.example.entity.Inaccount;
import com.example.entity.Outaccount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Result;
import com.example.mapper.InaccountMapper;
import com.example.mapper.OutaccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 支出信息表 服务类
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Service
public class OutaccountService {

    @Autowired
    OutaccountMapper outaccountMapper;

    /**
     *模糊查询
     */
    public Result getOutaccountLike(Outaccount outaccount){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            outaccountMapper.getOutaccountLike(outaccount);
            result.setMsg("查询成功");
            result.setSuccess(true);
            result.setDetail(outaccountMapper.getOutaccountLike(outaccount));
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询全部记录
     */
    public List<Outaccount> outaccountAll(Integer user_id){
        return outaccountMapper.outaccountAll(user_id);
    }

    /**
     * 删除记录
     */
    public String outaccountDelete(Integer id,Integer user_id){

        if (outaccountMapper.idSelectUser(id) == user_id){
            outaccountMapper.outaccountDelete(id);
            return "删除成功";
        }else {
            return "这是别人的账单哦！";
        }
    }

    /**
     * 添加记录
     */
    public String outaccountNew(Outaccount outaccount){
        outaccountMapper.outaccountNew(outaccount);
        return "添加成功！";
    }

    /**
     * 修改记录
     */
    public String outaccountUpdate(Outaccount outaccount,Integer user_id){

        if (outaccountMapper.idSelectUser(outaccount.getId()) == user_id){
            outaccountMapper.outaccountUpdate(outaccount);
            return "修改成功！";
        }else {
            return "这是别人的消费记录哦！";
        }
    }
}
