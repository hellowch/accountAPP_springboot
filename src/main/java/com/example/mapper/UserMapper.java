package com.example.mapper;

import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Mapper
@Repository
public interface UserMapper {


    /**
     *查看用户名是否已经存在
     * @param username
     * @return
     */
    @Select("select u.username,u.password from tb_user u where u.username=#{username}")
    User findUserByName(@Param("username") String username);


    @Select("SELECT * FROM tb_user WHERE id=#{id}")
    User findUserById(@Param("id") Long id);


    /**
     * 注册
     * @param user
     */
    @Insert("insert into tb_user values(#{id},#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void register(User user);


    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select u.id from tb_user u where u.username=#{username} and password=#{password}")
    Long login(User user);
}
