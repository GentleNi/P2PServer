package com.p2p.entity;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class BaseResponse<T> {
    private String type;
    private int responseCode;
    private T data;

    public BaseResponse(){}

    public BaseResponse(String type, int responseCode, T data) {
        this.type = type;
        this.responseCode = responseCode;
        this.data = data;
    }

    public static  <T> BaseResponse<T> createResponse(String type,int code, T data){
        return new BaseResponse<T>(type, code,data);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
