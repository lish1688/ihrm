package com.ihrm.common.handler;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lish
 * @date 2020/10/3 13:10
 */
//公共异常类
@ControllerAdvice
public class BaseExcetionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result error(HttpServletRequest request , HttpServletResponse response,Exception e){
        Result result = new Result(ResultCode.SERVER_ERROR);
        return result;
    }
}
