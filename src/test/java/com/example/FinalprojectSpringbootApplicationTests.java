package com.example;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.User;
import com.example.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class FinalprojectSpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    //        springboot集成redis测试
    @Test
    public void redisTemplate() {
        User user = new User((long) 2,"wch","123456","11");
        redisTemplate.opsForValue().set("user2",user);
        System.out.println(redisTemplate.opsForValue().get("user2"));
    }

    @Test
    public void redisUtil(){
        redisUtil.del("key");
        redisUtil.sSet("key",1,2,3,4,5,6,7);
        System.out.println(redisUtil.sGet("key"));
        if (redisUtil.sHasKey("key",6) == true){
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }
    }


    //jwt令牌的获取
    @Test
    public void jwt01(){
        HashMap<String,Object> map = new HashMap<>();

        Calendar instance = Calendar.getInstance(); //用Calendar类设置过期时间
        instance.add(Calendar.SECOND,600);  //60秒后

        String token = JWT.create()
                .withHeader(map)   //头部
                .withClaim("userId",21)    //传递信息
                .withClaim("username","wch")
                .withExpiresAt(instance.getTime())     //令牌过期时间
                .sign(Algorithm.HMAC256("woc666"));    //签名

        System.out.println(token);
    }

    //jwt令牌的验证
    @Test
    public void jwt02() {

        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("woc666")).build(); //赋予加密的算法和签名
        //验证传来的token
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ0NjE0OTgsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoid2NoIn0.4CCrIN6SR1VvhLqj56VaJXyvzrFRrX8TBbMc5ElIZUA");
        System.out.println(verify.getClaim("userId").asLong());
        System.out.println(verify.getClaim("username").asString());

    }

    @Test
    public void wch222() {
//        redisUtil.set("name","wch");
////        System.out.println(redisUtil.get("name"));
        redisUtil.hdel("token",String.valueOf(1));
        System.out.println(redisUtil.hget("token",String.valueOf(1)));

    }

}
