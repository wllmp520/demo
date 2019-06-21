package com.example.demo.error;

import com.example.demo.exception.BusinessException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: demo
 * @description: 统一业务异常处理类
 * @author: wllmp520
 * @create: 2019-06-21 09:33
 */
@ControllerAdvice(basePackages = {"com.example.demo",})
public class GlobalDefalutExceptionHanlder {
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
        public ErrorInfo defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        ErrorInfo errorInfo=new ErrorInfo();
        errorInfo.setMeassage(e.getMessage());
        errorInfo.setUrl(request.getRequestURI());
        errorInfo.setCode(errorInfo.SUCCESS);
        return  errorInfo;
    }
}