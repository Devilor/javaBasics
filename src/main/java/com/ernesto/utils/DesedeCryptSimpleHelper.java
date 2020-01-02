package com.ernesto.utils;

import org.apache.commons.lang.StringUtils;

import java.nio.charset.Charset;
import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;

import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author Ernesto
 * @date 2019/12/30
 */
public class DesedeCryptSimpleHelper {

    private String secretKey = "dZsvNNm68ggq/lvfZMurkasHQ1KiJu8Q";
    //dZsvNNm68ggq/lvfZMurkasHQ1KiJu8Q-测试

    private final String algorithm = "DESede";

    /**
     * 数据加密
     *
     * @param infoContent
     *
     * @return
     *
     * @throws Exception
     */
    public String encrypt(String infoContent) throws Exception {
        try {
            if (StringUtils.isNotBlank(infoContent)) {
                byte[] curBytes = infoContent.getBytes(Charset.forName("UTF-8"));
                byte[] cryptBytes = encrypt(curBytes, "");
                byte[] base64Bytes = Base64Util.encode(cryptBytes);

                return new String(base64Bytes, Charset.forName("UTF-8"));
            }

        } catch (Exception e) {
            throw new Exception("加密失败！", e);
        }

        return "";
    }

    /**
     * 数据解密
     *
     * @param infoContent
     *
     * @return
     *
     * @throws Exception
     */
    public String decrypt(String infoContent) throws Exception {
        try {
            if (StringUtils.isNotBlank(infoContent)) {
                byte[] curBytes = infoContent.getBytes(Charset.forName("UTF-8"));
                byte[] base64Bytes = Base64Util.decode(curBytes);
                byte[] cryptBytes = decrypt(base64Bytes, "");

                return new String(cryptBytes, Charset.forName("UTF-8"));
            }
        } catch (Exception e) {
            throw new Exception("解密失败", e);
        }

        return "";
    }

    /**
     * 加密
     *
     * @param data
     * @param channel
     *
     * @return
     *
     * @throws Exception
     */
    public byte[] encrypt(byte[] data, String channel) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        byte[] keyBytes = Base64Util.decode(getSecretKey(channel).getBytes(Charset.forName("UTF-8")));
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, algorithm));

        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data
     * @param channel
     *
     * @return
     *
     * @throws Exception
     */
    public byte[] decrypt(byte[] data, String channel) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        byte[] keyBytes = Base64Util.decode(getSecretKey(channel).getBytes(Charset.forName("UTF-8")));
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, algorithm));

        return cipher.doFinal(data);
    }

    private String getSecretKey(String channel) {
        return secretKey;
    }

    /**
     * md5加签
     *
     * @param data
     * @param encoding
     *
     * @return
     *
     * @throws UnsupportedEncodingException
     */
    public String md5(String data, Charset encoding) throws UnsupportedEncodingException {
        return DigestUtils.md5Hex(data.getBytes(encoding));
    }
}
