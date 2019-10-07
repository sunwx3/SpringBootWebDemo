package com.sunwx.springboot.exception;

import com.sunwx.springboot.vo.ResEnv;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.slf4j.LoggerFactory.getLogger;

@Order(999)
@ControllerAdvice
public class OtherExceptionHandler {
    Logger logger = getLogger(OtherExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResEnv<Object> processValidationError(Exception e) {
        logger.error("请求时出错", e);

        return ResEnv.fail("请求时出错");
    }
}
