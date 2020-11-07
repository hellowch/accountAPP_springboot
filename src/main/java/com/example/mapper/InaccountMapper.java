package com.example.mapper;

import com.example.entity.Inaccount;
import com.example.entity.Outaccount;
import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 收入信息表 Mapper 接口
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Mapper
@Repository
public interface InaccountMapper {

    /**
     *模糊查询
     */
    List<Inaccount> getInaccountLike(Inaccount inaccount);

    /**
     * 查询全部记录
     */
    List<Inaccount> inaccountAll(Integer user_id);

    /**
     * 删除记录
     */
    void inaccountDelete(Integer id);

    /**
     * 添加记录
     */
    void inaccountNew(Inaccount inaccount);

    /**
     * 修改记录
     */
    void inaccountUpdate(Inaccount inaccount);

    /**
     * 根据id查询user_id
     */
    Integer idSelectUser(Integer id);
}
