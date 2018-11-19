package com.wys.read.exception;

/**
 * @Author: wys
 * @Description:
 * @Date: Created in 23:23 2018/11/19
 * @Modified By:
 */
public enum ReadErrorCodeEnum implements ErrorCode {

    SUCCESS(0, "成功"),
    MD_NULL(600, "md文件内容为空");

    Integer code;
    String msg;

    ReadErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ErrorCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
