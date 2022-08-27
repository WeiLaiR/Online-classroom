package com.wei.kt.exception;

import com.wei.kt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    @ExceptionHandler(KtException.class)
    @ResponseBody
    public Result error(KtException e){
        e.printStackTrace();
        return Result.fail().message(e.getMsg()).code(e.getCode());
    }

}
