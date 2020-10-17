package com.ihrm.common.entity;

/**
 * @author lish
 * @date 2020/9/19 19:38
 */
public enum  ResultCode {
    SUCCESS(true,10000,"操作成功！"),
    //系统错误返回码
    FAIL(false,10001,"操作失败！"),
    UNAUTHENTCATED(false,10002,"您还未登录"),
    UNAUTHORISE(false,10003,"权限不足"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙！");

    //操作是否成功
    boolean successs;
    //操作代码
    int code;
    //提示信息
    String messge;
    ResultCode(boolean successs,int code,String messge){
        this.successs=successs;
        this.code=code;
        this.messge=messge;
    }

}
