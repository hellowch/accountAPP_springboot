package com.example.mapper;

import com.example.entity.Inaccount;
import com.example.entity.Outaccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 支出信息表 Mapper 接口
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Mapper
@Repository
public interface OutaccountMapper {
    /**
     *模糊查询
     */
    List<Inaccount> getOutaccountLike(Outaccount outaccount);

    /**
     * 查询全部记录
     */
    List<Inaccount> outaccountAll();

    /**
     * 删除记录
     */
    void outaccountDelete(Integer id);

    /**
     * 添加记录
     */
    void outaccountNew(Outaccount outaccount);

    /**
     * 修改记录
     */
    void outaccountUpdate(Outaccount outaccount);

}
