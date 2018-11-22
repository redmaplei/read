package com.wys.read.web.rest;

import com.wys.read.domain.User;
import com.wys.read.exception.ReadCodeEnum;
import com.wys.read.utils.DfaDetection;
import com.wys.read.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wys
 * @Description: 登录
 * @Date: Created in 9:58 2018/10/6
 * @Modified By:
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    /**
     * 登录  前端没完成
     * @param usr 用户名
     * @param passwd 登录密码
     * @return
     */
    @GetMapping(value = "/login")
    public Result<Void> userLogin(@RequestParam String usr, @RequestParam String passwd) {

        Result.ResultBuilder<Void> result = Result.builder();

        if (usr == "" || passwd == "") {
            result.code(ReadCodeEnum.LOGIN_INFO_NULL.getCode())
                    .msg(ReadCodeEnum.LOGIN_INFO_NULL.getMsg());
            return result.build();
        }

        //password = "0cc175b9c0f1b6a831c399e269772661";
        UsernamePasswordToken token = new UsernamePasswordToken(usr, passwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            result.code(ReadCodeEnum.LOGIN_SUCCESS.getCode())
                    .msg(ReadCodeEnum.LOGIN_SUCCESS.getMsg());
        }catch (Exception e) {
            log.error("{}", e.getMessage());
            result.code(ReadCodeEnum.LOGIN_INFO_ERROR.getCode())
                    .msg(ReadCodeEnum.LOGIN_INFO_ERROR.getMsg());
        }

        return result.build();
    }

    /**
     * 登出
     * @param username 用户名
     * @return
     */
    @GetMapping(value = "/logout")
    public Result<Void> userLogout(String username) {

        Result.ResultBuilder<Void> result = Result.builder();

        if (username == "") {
            return result.code(ReadCodeEnum.LOGOUT_USERNAME_NULL.getCode())
                    .msg(ReadCodeEnum.LOGOUT_USERNAME_NULL.getMsg())
                    .build();
        }

        Subject subject = SecurityUtils.getSubject();
        try {
            if (subject == null) {
                return result.code(ReadCodeEnum.LOGOUT_USERNAME_NULL.getCode())
                        .msg(ReadCodeEnum.LOGOUT_USERNAME_NULL.getMsg())
                        .build();
            }
            subject.logout();
            result.code(ReadCodeEnum.LOGOUT_SUCCESS.getCode())
                    .msg(ReadCodeEnum.LOGOUT_SUCCESS.getMsg());
        }catch (Exception e) {
            result.code(ReadCodeEnum.LOGOUT_FALUT.getCode())
                    .msg(ReadCodeEnum.LOGOUT_FALUT.getMsg());
        }

        return result.build();
    }

    /**
     * 获得登录的用户信息
     * @return
     */
    @GetMapping(value = "/getuserinfo")
    public Result<String> getUserinfo() {

        Result.ResultBuilder<String> result = Result.builder();

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return result.code(ReadCodeEnum.GET_SUCCESS.getCode())
                .msg(ReadCodeEnum.GET_SUCCESS.getMsg())
                .data(user.getUsername() + user.getPassword())
                .build();
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
