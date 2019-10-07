package com.sunwx.springboot.utils;

import org.apache.commons.lang.StringUtils;


public class EmojiFilter {

    /**
     * [0xE001,0xE05A]
     * [0xE101,0xE15A]
     * [0xE201,0xE253]
     * [0xE301,0xE34D]
     * [0xE401,0xE44C]
     * [0xE501,0xE537]
     *
     * @param code
     * @return
     */
    private static boolean isEmojiCharacter(char code) {
        return (code == 0x0) ||
                (code == 0x9) ||
                (code == 0xA) ||
                (code == 0xD) ||
                ((code >= 0x20) && (code <= 0xD7FF)) ||
                ((code >= 0xE000) && (code <= 0xFFFD)) ||
                ((code >= 0x10000) && (code <= 0x10FFFF));
    }

    /**
     * 检测是否有emoji字符
     *
     * @param source
     * @return 一旦含有就抛出
     */
    private static boolean containsEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return false;
        }

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                //do nothing，判断到了这里表明，确认有表情字符
                return true;
            }
        }
        return false;
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {

        if (!containsEmoji(source)) {
            return source;//如果不包含，直接返回
        }
        //到这里铁定包含
        StringBuilder buf = null;

        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }

                buf.append(codePoint);
            } else {
            }
        }

        if (buf == null) {
            return source;//如果没有找到 emoji表情，则返回源字符串
        } else {
            if (buf.length() == len) {//这里的意义在于尽可能少的toString，因为会重新生成字符串
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

    /**
     * 转换html
     * @param str
     * @return
     */
    public static String escapeHtml(String str) {
        return  str.replaceAll("&", "&amp;").replaceAll("<", "&lt;");
    }

  /*  public static void main(String[] args) {
        String title = "{\uD83D\uDE02把脸凑过来 让你知道一个巴掌也能拍的响}，{}";
        System.out.println(filterEmoji(title));
    }*/
}
