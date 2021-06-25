package com.daike.utils;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

/**
 * 基于 apache-commons-codec 的 Base64 加密 / 解密工具类（线程安全的）
 *
 * @author Ernesto
 * @date 2019/12/30
 */
public class Base64Util {
    /**
     * 加密
     *
     * @param data 待加密信息 String 类型
     *
     * @return 加密后的密文 String 类型
     */
    public static String encode(String data) {
        return encode(data, Charset.forName("UTF-8"));
    }

    /**
     * 加密
     *
     * @param data     待加密信息 String 类型
     * @param encoding 加密指定的字符集编码 Charset 类型 （推荐使用，不应该使用默认的字符集这样程序就和操作系统绑定在一起了）
     *
     * @return 加密后的密文 String 类型
     */
    public static String encode(String data, Charset encoding) {
        byte[] binaryData = data.getBytes(encoding);
        byte[] base64 = encode(binaryData);
        return new String(base64, encoding);
    }

    /**
     * 加密
     *
     * @param data 待加密的信息 byte[] 类型
     *
     * @return 加密后的密文 byte[] 类型
     */
    public static byte[] encode(byte[] data) {
        return Base64.encodeBase64(data, true);
    }

    /**
     * 解密
     *
     * @param base64 待解密的信息 String 类型
     *
     * @return
     */
    public static String decode(String base64) {
        return decode(base64, Charset.forName("UTF-8"));
    }

    /** */
    /**
     * <p>
     * BASE64字符串解码为二进制数据
     * </p>
     *
     * @param base64
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] decode2Byte(String base64) throws Exception {
        return Base64.decodeBase64(base64.getBytes());
    }

    /**
     * <p>
     * 二进制数据编码为BASE64字符串
     * </p>
     *
     * @param bytes
     *
     * @return
     *
     * @throws Exception
     */
    public static String decode2String(byte[] bytes) throws Exception {
        return new String(Base64.encodeBase64(bytes));
    }

    /**
     * 解密
     *
     * @param base64   待解密的信息 String 类型
     * @param encoding 解密使用指定的字符集编码 Charset 类型
     *
     * @return 解密后的明文 String 类型
     */
    public static String decode(String base64, Charset encoding) {
        byte[] binaryData = base64.getBytes(encoding);
        byte[] data = decode(binaryData);
        return new String(data, encoding);
    }

    /**
     * 解密
     *
     * @param base64 待解密的信息 byte[] 二进制类型
     *
     * @return 解密后的明文 byte[] 二进制类型
     */
    public static byte[] decode(byte[] base64) {
        return Base64.decodeBase64(base64);
    }
}
