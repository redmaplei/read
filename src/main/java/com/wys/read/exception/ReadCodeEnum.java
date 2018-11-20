package com.wys.read.exception;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 23:23 2018/11/19
 * @Modified By:
 */
public enum ReadCodeEnum implements ErrorCode {

    /**
     * 登录成功返回值
     */
    LOGIN_SUCCESS(200, "登录成功"),
    /**
     * 登录失败返回值
     */
    LOGIN_INFO_ERROR(550, "账号或密码错误"),
    /**
     * 账号或密码为空
     */
    LOGIN_INFO_NULL(555, "账号或密码为空"),

    /**
     * 注销成功
     */
    LOGOUT_SUCCESS(200, "注销成功"),
    /**
     * 账号为空
     */
    LOGOUT_USERNAME_NULL(560, "账号为空"),
    /**
     * 注销失败
     */
    LOGOUT_FALUT(565, "注销失败"),

    /**
     * 获取信息成功
     */
    GET_SUCCESS(200, "获取信息成功"),

    /**
     *
     */
    /**
     * 上传的md的内容为空
     */
    MD_NULL(600, "md文件内容为空");

    Integer code;
    String msg;

    ReadCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
