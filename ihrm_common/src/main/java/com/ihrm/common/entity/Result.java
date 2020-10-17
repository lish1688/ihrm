package com.ihrm.common.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lish
 * @date 2020/9/19 19:38
 */
@Data
@NoArgsConstructor
public class Result {
    private boolean success;
    private Integer code;
    private String messge;
    private Object data;//返回数据

    public Result(ResultCode code) {
        this.success = code.successs;
        this.code = code.code;
        this.messge = code.messge;
    }

    public Result(ResultCode code,Object data) {
        this.success = code.successs;
        this.code = code.code;
        this.messge = code.messge;
        this.data = data;
    }

    public Result(Integer code,String messge,boolean successs) {
        this.success = successs;
        this.code = code;
        this.messge = messge;
    }

    public static Result SUCCESS(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result ERROR(){
        return new Result(ResultCode.SERVER_ERROR);
    }

    public static Result FAIL(){
        return new Result(ResultCode.FAIL);
    }
}
