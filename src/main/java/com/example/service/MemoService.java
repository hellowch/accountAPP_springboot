package com.example.service;

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


}
