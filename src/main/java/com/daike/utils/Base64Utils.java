package com.daike.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 基于 Java JDK8 java.util.Base64 的加密/解密工具类
 * 线程不安全
 *
 * @author Ren, Jianyong
 * @date 2019/12/30
 */
public class Base64Utils {
    //加密器
    private static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();
    //解密器
    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();
    //当前系统默认的字符集编码
    private static final String DEFAULT_ECODING = System.getProperty("sun.jnu.encoding");

    /**
     * 加密
     *
     * @param msg         需要加密的信息 String 类型
     * @param charsetName 加密时指定的字符集编码 String 类型
     *
     * @return 加密后的密文 String 类型 (注意默认返回为"")
     *
     * @throws UnsupportedEncodingException
     */
    public static String encodeToString(String msg, String charsetName) throws UnsupportedEncodingException {
        if (!isEmpty(msg) && !isEmpty(charsetName)) {
            byte[] result = BASE64_ENCODER.encode(convertStringToByte(msg, charsetName));
            return new String(result);
        }
        return "";
    }

    /**
     * 加密
     *
     * @param msg         需要加密的信息 String 类型
     * @param charsetName 加密时指定的字符集编码 String 类型
     *
     * @return 加密后的密文 byte[] 类型 (注意默认返回为byte[0])
     *
     * @throws UnsupportedEncodingException
     */
    public static byte[] encodeToByte(String msg, String charsetName) throws UnsupportedEncodingException {
        if (!isEmpty(msg) && !isEmpty(charsetName)) {
            return BASE64_ENCODER.encode(convertStringToByte(msg, charsetName));
        }
        return new byte[0];
    }

    /**
     * 加密（使用系统默认的字符集编码）
     *
     * @param msg 需要加密的信息 String 类型
     *
     * @return 加密后的密文 String 类型 (注意默认返回为"")
     *
     * @throws UnsupportedEncodingException
     */
    public static String encodeToString(String msg) throws UnsupportedEncodingException {
        return encodeToString(msg, DEFAULT_ECODING);
    }

    /**
     * 加密（使用系统默认的字符集编码）
     *
     * @param msg 需要加密的信息 String 类型
     *
     * @return 加密后的密文 byte[] 类型 (注意默认返回为byte[0])
     *
     * @throws UnsupportedEncodingException
     */
    public static byte[] encodeToByte(String msg) throws UnsupportedEncodingException {
        return BASE64_ENCODER.encode(convertStringToByte(msg, DEFAULT_ECODING));
    }

    /**
     * 加密
     *
     * @param msg 需要加密的信息 byte[] 类型
     *
     * @return 加密后的密文 String 类型 (注意默认返回为"")
     */
    public static String encodeToString(byte[] msg) {
        if (null != msg) {
            byte[] result = BASE64_ENCODER.encode(msg);
            return new String(result);
        }
        return "";
    }

    /**
     * 加密
     *
     * @param msg 需要加密的信息 byte[] 类型
     *
     * @return 加密后的密文 byte[] 类型 (注意默认返回为byte[0])
     */
    public static byte[] encodeToByte(byte[] msg) {
        if (null != msg) {
            return BASE64_ENCODER.encode(msg);
        }
        return new byte[0];
    }

    /**
     * 类内部工具方法：将 String 类型 按照制定的 Charset 转换成 byte[] 类型
     *
     * @param msg         需要转化的 String 数据
     * @param charsetName 转换制定的字符集编码
     *
     * @return 转化后的 byte[]
     *
     * @throws UnsupportedEncodingException
     */
    private static byte[] convertStringToByte(String msg, String charsetName) throws UnsupportedEncodingException {
        if (!isEmpty(msg) && !isEmpty(charsetName)) {
            return msg.getBytes(charsetName);
        }
        return new byte[0];
    }

    /**
     * 类内部工具方法：将 String 类型 按照系统默认 Charset 转换成 byte[] 类型
     *
     * @param msg
     *
     * @return 转化后的 byte[]
     */
    private static byte[] convertStringToByte(String msg) {
        if (!isEmpty(msg)) {
            return msg.getBytes();
        }
        return new byte[0];
    }

    /**
     * 解密
     *
     * @param msg 待解密的密文 String 类型
     *
     * @return 解密后的明文 String 类型
     */
    public static String decodeBase64(String msg) {
        return new String(decodeBase64ToByte(msg));
    }

    /**
     * 解密
     *
     * @param msg 待解密的密文 String 类型
     *
     * @return 解密后的明文 byte[] 类型
     */
    public static byte[] decodeBase64ToByte(String msg) {
        return BASE64_DECODER.decode(msg);
    }

    /**
     * 类内部使用：判断字符串是否为空
     *
     * @param msg 带判断变量 String 类型
     *
     * @return 是否为空：是 true 否 false Boolean 类型
     */
    private static Boolean isEmpty(String msg) {
        return (null == msg || msg.equals(""));
    }
}
