package com.example.controller;

import com.example.utils.JsonResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理、数据预处理等
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 校验异常统一处理
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public JsonResult<String> validExceptionHandler(BindException e) {
        JsonResult<String> json = new JsonResult<>();
        LOG.warn("参数校验失败：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        json.setCode(404);
        json.setData(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        json.setMsg(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return json;
    }
}