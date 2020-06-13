package com.qfedu.wjt.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

//增强控制器,全局异常处理类
@ControllerAdvice
@ResponseBody
public class CommonException {
    //针对于那个异常处理的异常处理器
    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult constraintViolationException(ConstraintViolationException ex) {
        //验证不通过的信息
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        String message = null;
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
            System.out.println(message);
        }
        return new JsonResult(0,message);
    }
}
