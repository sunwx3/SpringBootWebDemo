package com.sunwx.springboot.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

//import com.asiainfo.monitor.service.user.UserService;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    Logger logger = getLogger(AuthInterceptor.class);
    private ObjectMapper objectMapper = new ObjectMapper();

//    @Resource
//    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        try {
//            String ticket = CtxUtils.getTicket(request);
//
//            if (StringUtils.isBlank(ticket))
//                throw new AuthException("用户登录凭据为空");
//
//            User user = userService.getByTicket(ticket);
//            if (user == null)
//                throw new AuthException("用户未登录或已过期");
//        } catch (BizException | AuthException e) {
//            returnJson(request, response, new ResEnv<>(Constants.RES_CODE_UNAUTH, e.getMessage()));
//            return false;
//        } catch (Exception e) {
//            logger.error("验证用户登录时出错", e);
//            returnJson(request, response, new ResEnv<>(Constants.RES_CODE_UNAUTH, "验证用户登录时出错"));
//            return false;
//        }
        return super.preHandle(request, response, handler);
    }

    public void returnJson(HttpServletRequest request, HttpServletResponse response, Object obj) throws IOException {
        if (obj == null)
            return;

        response.setContentType("application/json; charset=UTF-8");
        String json = objectMapper.writeValueAsString(obj);

        String callback = request.getParameter("callback");
        if (StringUtils.isNotBlank(callback)) {
            json = String.format("%s(%s)", callback, json);
        }

        response.getWriter().write(json);
    }
}

