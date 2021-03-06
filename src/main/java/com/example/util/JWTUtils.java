package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static String SECRET = "token!QWERTY";

    /**
     * 生产token
     */
    public static String getToken(Map<String, String> map) {

        //创建jwtBuilder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); //默认7天过期

        String token = builder.withExpiresAt(instance.getTime())//指定令牌的过期时间
                .sign(Algorithm.HMAC256(SECRET));//签名

        return token;
    }

    /**
     * 验证token
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        return decodedJWT;
    }

    /**
     * 查询token中的user_id
     * @return
     */
    public static Integer user_id(String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        Integer user_id = Integer.valueOf(verify.getClaim("id").asString());  //从token中获取id信息
        return user_id;
    }

//    /**
//     * 获取token中的 payload
//     */
//    public static DecodedJWT getToken(String token) {
//        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
//        return decodedJWT;
//    }
}

