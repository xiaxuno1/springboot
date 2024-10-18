package com.springboot.learning.demo_05_tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class Demo05TliasApplicationTests {

    /**
     * 生成jwt
     * **/
    @Test
    void testGenJWT(){
//        生成自定义内容
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"laotie857") //签名，和加密算法
                .setClaims(claims)  //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000)) //设置token的有效期为1小时
                .compact(); //
        System.out.println(jwt);
    }
    /**
     * 解析jwt
     * **/
    //@Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("laotie857") //签名
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzI0NzUzOTA3LCJ1c2VybmFtZSI6IlRvbSJ9.MLaDwSCnkx6ULA9XNvhdxit2iPepYEjv11Jm5UBX13s")
                .getBody();
        System.out.println(claims); //{id=1, exp=1724753907, username=Tom}
    }
}
