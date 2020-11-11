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
    public Result outaccountDelete(Integer id,Integer user_id){

        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if (outaccountMapper.idSelectUser(id) == user_id){
                outaccountMapper.outaccountDelete(id);
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
    public Result outaccountNew(Outaccount outaccount){

        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            outaccountMapper.outaccountNew(outaccount);
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
    public Result outaccountUpdate(Outaccount outaccount,Integer user_id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if (outaccountMapper.idSelectUser(outaccount.getId()) == user_id){
                outaccountMapper.outaccountUpdate(outaccount);
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
}
