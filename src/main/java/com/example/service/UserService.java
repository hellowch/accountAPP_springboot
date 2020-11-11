package com.example.service;

import com.example.entity.Result;
import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mapper.UserMapper;
import com.example.util.JWTUtils;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 注册
     * @param user
     * @return
     */
    public Result rgister(User user){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            User userByName = userMapper.findUserByName(user.getUsername());
            if(userByName!=null){
                //如果查询到 说明存在
                result.setMsg("用户名存在");
            }else {
                userMapper.register(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登录
     */
    public Result login(User user){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);

        try {
            Long userId = userMapper.login(user);
            //指定一个map记录数据传入jwt,生产token
            Map<String,String> payload = new HashMap<>();
            payload.put("id", String.valueOf(userId));
            payload.put("username",user.getUsername());
            String token = JWTUtils.getToken(payload);


            if(userId==null){
                result.setMsg("用户名或密码错误");
            }
//            else if (redisUtil.hHasKey("token",String.valueOf(userId))){
//                result.setMsg("用户已登录");
//            }
            else {
                redisUtil.hset("token", String.valueOf(userId),token,604800);
                result.setMsg("登录成功");
                result.setSuccess(true);
                result.setDetail(userMapper.avatar(user));
                result.setToken(token);
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
