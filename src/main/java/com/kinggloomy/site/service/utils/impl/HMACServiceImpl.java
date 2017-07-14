package com.kinggloomy.site.service.utils.impl;

/**
 * Created by Harlan King on 2017/4/21.
 */

import com.kinggloomy.site.service.utils.service.HMACService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by xiang.li on 2015/2/27.
 */
@Service("hmacService")
public class HMACServiceImpl implements HMACService {
    /**
     * 定义加密方式
     * HMAC算法可选以下多种算法
     * <pre>
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     * </pre>
     */
    private final static String KEY_MAC = "HmacSHA256";

    /**
     * 全局数组
     */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};


    /**
     * BASE64 加密
     *
     * @param str 需要加密的字符串
     * @return 字符串
     * @throws Exception
     */
    @Override
    public String encryptBase64(byte[] str) throws Exception {
        return Base64.getEncoder().encodeToString(str);
    }

    /**
     * BASE64 解密
     *
     * @param key 需要解密的字符串
     * @return 字节数组
     * @throws Exception
     */
    @Override
    public byte[] decryptBase64(String key) throws Exception {
        return Base64.getDecoder().decode(key);
    }


    /**
     * HMAC加密
     *
     * @param data 需要加密的字节数组
     * @param key  密钥
     * @return 字节数组
     */
    @Override
    public byte[] encryptHMAC(byte[] data, String key) {
        SecretKey secretKey;
        byte[] bytes = null;
        try {
            secretKey = new SecretKeySpec(decryptBase64(key), KEY_MAC);
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * HMAC加密
     *
     * @param data 需要加密的字符串
     * @param key  密钥
     * @return 字符串
     */
    @Override
    public String encryptHMAC(String data, String key) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        byte[] bytes = encryptHMAC(data.getBytes(), key);
        return byteArrayToHexString(bytes);
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    private static String byteToHexString(byte b) {
        int ret = b;
        //System.out.println("ret = " + ret);
        if (ret < 0) {
            ret += 256;
        }
        int m = ret / 16;
        int n = ret % 16;
        return hexDigits[m] + hexDigits[n];
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();
    }


}