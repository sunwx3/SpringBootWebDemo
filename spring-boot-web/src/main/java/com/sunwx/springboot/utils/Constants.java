package com.sunwx.springboot.utils;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;

import java.lang.reflect.Method;
import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

public class Constants {
    private static Logger logger = getLogger(Constants.class);

    /**
     * 默认成功消息
     */
    public static final String DEF_SUCC_MSG = "操作成功";

    /**
     * 默认失败消息
     */
    public static final String DEF_FAIL_MSG = "操作失败";

    /**
     * 默认每页数量
     */
    public static final int DEF_PAGE_SIZE = 20;

    /**
     * 认证票据
     */
    public static final String TICKET = "ticket";

    /**
     * 默认虚拟根ID
     */
    public static final Long DEFAULT_ROOT_ID = 0L;

    /**
     * 默认虚拟根CODE
     */
    public static final String DEFAULT_ROOT_CODE = "ROOT";

    /**
     * session超时时间（秒）
     */
    public static final int SESSION_TIME_OUT = 30 * 60;

    /**
     * 返回代码：成功
     */
    public static final int RES_CODE_OK = 200;

    /**
     * 范围代码：不存在
     */
    public static final int RES_CODE_NOT_FOUND = 404;

    /**
     * 返回代码：失败
     */
    public static final int RES_CODE_ERROR = 503;

    /**
     * 返回代码：参数错误
     */
    public static final int RES_CODE_UNPROCESSABLE = 422;

    /**
     * 返回代码：未验证
     */
    public static final int RES_CODE_UNAUTH = 401;

    /**
     * 字典表缓存名称
     */
    public static final String DIC_CACHE_NAME = "dicCache";


    /**
     * 登录用户ticket和userId缓存名称
     */
    public static final String LOGIN_USER_CACHE_NAME = "loginUserCache";

    /**
     * 用户信息缓存名称
     */
    public static final String WRAPPED_USER_CACHE_NAME = "wrappedUserCache";

    /**
     * 用户角色缓存名称
     */
    public static final String USER_ROLES_CACHE_NAME = "userRolesCache";

    /**
     * 用户权限缓存名称
     */
    public static final String USER_PERMISSIONS_CACHE_NAME = "userPermissionsCache";

    /**
     * app最后登录设备信息
     */
    public static final String LAST_LOGIN_DEVICE_CACHE = "appLastLoginDeviceCache";

    /**
     * 邮件发送人id
     */
    public static final Integer MESSAGE_SEND_USER_ID = 1;


    public static final String ATTENDANCE_RESULT_NORMAL = "normal";
    public static final String ATTENDANCE_RESULT_LATEFORWORK = "lateForWork";
    public static final String ATTENDANCE_RESULT_LEAVEWORKEARYL = "leaveWorkEarly";
    public static final String ATTENDANCE_RESULT_ABSENTEEISMHALFDAY = "absenteeismHalfDay";
    public static final String ATTENDANCE_RESULT_ABSENTEEISMHOLEDAY = "absenteeismHoleDay";
    public static final String ATTENDANCE_RESULT_MORNINGNORECORD = "morningNoRecord";
    public static final String ATTENDANCE_RESULT_AFTERNOONNORECORD = "afternoonNoRecord";
    public static final String ATTENDANCE_RESULT_LESSTHANEIGHTHOURS = "lessThanEightHours";
    public static final String ATTENDANCE_RESULT_ABSENCEFROMDUTY = "absenceFromWork";
    /**
     * 所有枚举对象的 map
     */
    public static final Map<String, String> ATTENDANCE_RESULT;

    static {
        ATTENDANCE_RESULT = new HashMap<>();
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_NORMAL,"正常");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_LATEFORWORK,"迟到");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_LEAVEWORKEARYL,"早退");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_ABSENTEEISMHALFDAY,"旷工半天");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_ABSENTEEISMHOLEDAY,"旷工一天");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_MORNINGNORECORD,"上班未打卡");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_AFTERNOONNORECORD,"下班未打卡");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_LESSTHANEIGHTHOURS,"未满八小时");
        ATTENDANCE_RESULT.put(ATTENDANCE_RESULT_ABSENCEFROMDUTY,"缺勤");
    }

    public static final String DATE_TYPE_RC = "rc";
    public static final String DATE_TYPE_JB = "jb";
    public static final String DATE_TYPE_TX = "tx";
    public static final String DATE_TYPE_CGJQ = "cgjq";
    public static final String DATE_TYPE_DXJQ = "dxjq";


    public static final Map<String, String> DateType;

    static {
        DateType = new HashMap<>();
        DateType.put(DATE_TYPE_RC,"日常工作");
        DateType.put(DATE_TYPE_JB,"加班");
        DateType.put(DATE_TYPE_TX,"调休");
        DateType.put(DATE_TYPE_CGJQ,"请假");
        DateType.put(DATE_TYPE_DXJQ,"带薪假");
    }

    public static final String DAY_TYPE_GZR = "gzr";
    public static final String DAY_TYPE_PTJR = "ptjr";
    public static final String DAY_TYPE_FDJJR = "fdjjr";


    public static final Map<String, String> DayType;

    static {
        DayType = new HashMap<>();
        DayType.put(DAY_TYPE_GZR,"工作日");
        DayType.put(DAY_TYPE_PTJR,"普通假日");
        DayType.put(DAY_TYPE_FDJJR,"法定节假日");
    }


    /**
     * 所有枚举对象的 map
     */
    public static final Map<String, List<Enum>> ENUM_MAP;

    static {
        Map<String, List<Enum>> enums = new HashMap<>();
        Reflections reflections = new Reflections("com.physicalpoint.daily.enums", new SubTypesScanner(false));
        Set<Class<? extends Enum>> clazzs = reflections.getSubTypesOf(Enum.class);

        for (Class<? extends Enum> clazz : clazzs) {
            try {
                Method method = clazz.getMethod("values");
                Enum[] items = (Enum[]) method.invoke(null);
                enums.put(clazz.getSimpleName(), Arrays.asList(items));
            } catch (Exception e) {
                logger.error("初始化枚举清单时出错", e);
            }
        }

        ENUM_MAP = Collections.unmodifiableMap(enums);
    }
}

