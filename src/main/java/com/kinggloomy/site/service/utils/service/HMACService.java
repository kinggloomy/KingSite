package com.kinggloomy.site.service.utils.service;

/**
 * Created by Administrator on 2017/5/3.
 */
public interface HMACService {
    String encryptBase64(byte[] str) throws Exception;

    byte[] decryptBase64(String key) throws Exception;

    byte[] encryptHMAC(byte[] data, String key);

    String encryptHMAC(String data, String key);

}
