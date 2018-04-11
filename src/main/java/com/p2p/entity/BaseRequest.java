package com.p2p.entity;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class BaseRequest<T> {
    private String type;
    private int requestCode;
    private T data;

    public BaseRequest(){}

    public BaseRequest(String type, int requestCode, T data) {
        this.type = type;
        this.requestCode = requestCode;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

   public static  <T> BaseRequest<T> createRequest(String type,int code, T data){
        return new BaseRequest<T>(type, code,data);
   }
}
