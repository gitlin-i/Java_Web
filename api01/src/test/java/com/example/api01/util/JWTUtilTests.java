package com.example.api01.util;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Log4j2
public class JWTUtilTests {
    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate(){
        Map<String, Object> claimMap = Map.of("mid","ABCDe","email","aaa@bbb.ccc");

        String jwtStr = jwtUtil.generateToken(claimMap,1);
        log.info(jwtStr);
    }

    @Test
    public void testValidate(){
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtaWQiOiJBQkNEZSIsImVtYWlsIjoiYWFhQGJiYi5jY2MiLCJpYXQiOjE2NzIxMzI1MzcsImV4cCI6MTY3MjIxODkzN30.059zXtb11zj20WNzIDFDK8QbmjXoOsIpuSX4u3DWys4";
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);

        log.info("mid: " + claim.get("mid"));
        log.info("email: " + claim.get("email"));
        log.info(claim);
    }
}
