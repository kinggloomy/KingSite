package com.kinggloomy.site.core;

/**
 * 自定义请求状态码
 * @author sycf-zhyl
 * @date 2015/7/15.
 */
public enum ResultStatus {
    /**
     * http 访问码
     */
    SUCCESS(2000, "成功"),
    ERROR(-4000, "错误"),
    /**
     * 服务器信息
     */
    SERVICE_EXCEPTION(-9999,"服务器异常");



    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
