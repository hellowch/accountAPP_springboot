package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Inaccount;
import com.example.entity.Memo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 便签内容
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-12-25
 */
@Mapper
@Repository
public interface MemoMapper extends BaseMapper<Memo> {

    /**
     *便签列表
     */
    List<Memo> memoAll(Integer user_id);

    /**
     *添加便签
     */
    void memoNew(Memo memo);

    /**
     *修改列表
     */


    /**
     *删除列表
     */

}
