package com.sunwx.springboot.exception;

import com.sunwx.springboot.vo.ResEnv;
import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.slf4j.LoggerFactory.getLogger;

@Order(1)
@ControllerAdvice
public class BizExceptionHandler {
    Logger logger = getLogger(BizExceptionHandler.class);

    @ExceptionHandler({BizException.class, AuthException.class, IllegalArgumentException.class, IllegalStateException.class})
    @ResponseBody
    public ResEnv<Object> processValidationError(Exception e) {
        logger.error("请求时出错", e);

        return ResEnv.fail(e != null ? e.getMessage() : "请求时出错");
    }
}
