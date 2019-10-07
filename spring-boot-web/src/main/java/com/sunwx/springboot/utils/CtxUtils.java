package com.sunwx.springboot.utils;



import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CtxUtils {
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static WebApplicationContext getWebApplicationContext() {
        return WebApplicationContextUtils
                .getWebApplicationContext(getRequest().getServletContext());
    }

    public static String getTicket(HttpServletRequest request) {
        String key = Constants.TICKET;
        String ticket = request.getParameter(key);
        if (StringUtils.isNotBlank(ticket))
            return ticket;

        ticket = request.getHeader(key);
        if (StringUtils.isNotBlank(ticket))
            return ticket;

        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if (StringUtils.equals(cookie.getName(), key)) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }
        if (StringUtils.isNotBlank(ticket))
            return ticket;

        ticket = (String) request.getSession().getAttribute(key);
        if (StringUtils.isNotBlank(ticket))
            return ticket;
        else
            return null;
    }

    public static String getTicket() {
        return getTicket(getRequest());
    }

    public static String getRemoteAddr() {
        HttpServletRequest request = CtxUtils.getRequest();
        String addr = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(addr) || "unknown".equalsIgnoreCase(addr)) {
            addr = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(addr) || "unknown".equalsIgnoreCase(addr)) {
            addr = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(addr) || "unknown".equalsIgnoreCase(addr)) {
            addr = request.getRemoteAddr();
        }
        return addr;
    }
}
