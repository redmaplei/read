package com.wys.read.web.rest;

import com.wys.read.domain.User;
import com.wys.read.utils.DfaDetection;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wys
 * @Description: 登录
 * @Date: Created in 9:58 2018/10/6
 * @Modified By:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    /**
     * 登录
     * @param usr 用户名
     * @param passwd 登录密码
     * @return
     */
    @GetMapping(value = "/login")
    public ResponseEntity<String> userLogin(String usr, String passwd) {

        String result = "";
        //password = "0cc175b9c0f1b6a831c399e269772661";
        UsernamePasswordToken token = new UsernamePasswordToken(usr, passwd);
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
//        return result;
    }

    /**
     * 登出
     * @param username 用户名
     * @return
     */
    @GetMapping(value = "/logout")
    public String userLogout(String username) {

        String result = "";

        Subject subject = SecurityUtils.getSubject();
        try {
            if (subject == null) {
                return result;
            }
            subject.logout();
            result = "logoutsuccess";
        }catch (Exception e) {
            result = "logout error";
        }


        return result;
    }

    /**
     * 获得登录的用户信息
     * @return
     */
    @GetMapping(value = "/getlogininfo")
    public String getlogininfo() {

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getUsername()+user.getPassword();

    }

    @Autowired
    DfaDetection dfaDetection;

    /**
     * dfa算法
     */
    @GetMapping(value = "dfa")
    public void dfa() {
        dfaDetection.detection();
    }

}
