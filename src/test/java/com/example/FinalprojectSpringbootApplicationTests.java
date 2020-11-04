package com.example;

import com.example.entity.User;
import com.example.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

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
        User user = new User((long) 2,"wch","123456");
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


}
