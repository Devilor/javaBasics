package com.ernesto.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 基于 apache-commons-codec 的加密/解密工具类
 * 线程安全
 *
 * @author Renjianyong
 * @date 2019/12/30
 */
public class EncodeUtils {
    private final static Base64 BASE_64 = new Base64();

    /**
     * 解密
     *
     * @param msg 待解密密文 String 类型
     *
     * @return 解密后的明文 String 类型
     */
    public static String decode(String msg) {
        return new String(BASE_64.decode(msg));
    }

    /**
     * 解密
     *
     * @param msg 待解密密文 byte[] 类型
     *
     * @return 解密后的明文 String 类型
     */
    public static String decode(byte[] msg) {
        return new String(BASE_64.decode(msg));
    }

    /**
     * 加密
     *
     * @param msg 待加密的信息 String 类型
     *
     * @return 加密后的密文 String 类型
     */
    public static String encode(String msg) {
        return BASE_64.encodeToString(msg.getBytes());
    }

    /**
     * 加密
     *
     * @param msg         待加密的信息 String 类型
     * @param charsetName 对密文进行字符集制定，如果需要的话
     *
     * @return
     *
     * @throws UnsupportedEncodingException
     */
    public static String encode(String msg, String charsetName) throws UnsupportedEncodingException {
        return BASE_64.encodeToString(msg.getBytes(charsetName));
    }
}
