package com.example.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.entity.Inaccount;
import com.example.entity.Memo;
import com.example.entity.Result;
import com.example.mapper.MemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 便签内容
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-12-25
 */
@Service
public class MemoService {

    @Autowired
    MemoMapper memoMapper;

    /**
     *输出便签列表
     */
    public List<Memo> memoAll(Integer user_id){
        return memoMapper.memoAll(user_id);
    }


    /**
     *添加便签
     */
    public Result memoNew(Memo memo){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            memoMapper.memoNew(memo);
            result.setMsg("添加成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     *修改列表
     */
    public Result memoUpdate(Memo memo){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            memoMapper.memoUpdate(memo);
            result.setMsg("添加成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    /**
     *删除列表
     */
    public Result memoDelete(Integer id){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            memoMapper.memoDelete(id);
            result.setMsg("删除成功");
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


}
