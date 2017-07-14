package com.kinggloomy.site.core;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Created by Administrator on 2017/7/11.
 */
public class HMACEncode {
    private static final String key = Config.HMAC_KEY;


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

    private static HMACEncode instance =null;

    private static HMACEncode getInstance(){
        if (instance == null&& key.length()==16)
            instance = new HMACEncode();
        return instance;
    }
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
