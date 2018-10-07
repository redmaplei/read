package com.wys.read.web.rest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 9:58 2018/10/6
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @GetMapping(value = "/login")
    public ResponseEntity<String> userLogin(String username, String password) {

        String result = "";
        //password = "0cc175b9c0f1b6a831c399e269772661";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            result = "success";
        }catch (Exception e) {
            e.printStackTrace();
            result = "error";
        }

        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<String> userLogout(String username) {

        String result = "";

        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping(value = "/test")
    public String test() {

        return "test";
    }

}
