package com.sunwx.springboot.utils;

import com.sunwx.springboot.exception.BizException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;

import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

public class SysUtils {
    static Logger logger = getLogger(SysUtils.class);

    public static String uid() {
        String uid = UUID.randomUUID().toString();
        return uid.replaceAll("-", "");
    }

    public static void copyProperties(Object desc, Object src, String... properties) {
        try {
            if (ArrayUtils.isNotEmpty(properties)) {
                for (String property : properties) {
                    Object obj = PropertyUtils.getProperty(src, property);
                    PropertyUtils.setProperty(desc, property, obj);
                }
            } else {
                BeanUtils.copyProperties(desc, src);
            }
        } catch (Exception e) {
            logger.error("复制对象属性时出错", e);
            throw new BizException("复制对象属性时出错");
        }
    }
}
