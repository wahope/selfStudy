package com.selfStudy.common;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
/**
* @Description:  TODO
* @Author:
* @CreateDate:  2018/10/14 18:09
* @Version:  1.0
*/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候，如果是null的对象，key也会消失
public class ServerRespose<T> implements Serializable {
    //状态
    private int status;
    //消息
    private String msg;
    //返回数据
    private T data;

    private ServerRespose(int status){
        this.status=status;
    }
    private ServerRespose(int status, T data){
        this.status=status;
        this.data=data;
    }
    private ServerRespose(int status , String msg){
        this.status=status;
        this.msg=msg;
    }
    private ServerRespose(int status, String msg, T data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }

    @JsonIgnore
    //使之不在json序列化到结果当中
    public boolean isSuccess(){
        //如果当前的状态=0，则返回成功
        return this.status == 200;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
    //不传参时返回一个code=1
    public static <T> ServerRespose<T> CreateBySuccess(){
        return  new ServerRespose<T>(200);
    }

    public static <T> ServerRespose<T> CreateBySuccessMessage(String msg){
        return  new ServerRespose<T>(200,msg);
    }
    public static <T> ServerRespose<T> CreateBySuccess(T data){
        return  new ServerRespose<T>(200,data);
    }
    public static <T> ServerRespose<T> CreateBySuccess(String msg, T data){
        return  new ServerRespose<T>(200,msg,data);
    }
    public static <T> ServerRespose<T> CreateBySuccessCodeMessage(int Code,String SuccessMessage){
        return  new ServerRespose<T>(Code,SuccessMessage);
    }
    public static <T> ServerRespose<T> CreateByError(){
        return  new ServerRespose<T>(0);
    }

    public static <T> ServerRespose<T> CreateByErrorMessage(String ErrorMessage){
        return  new ServerRespose<T>(0,ErrorMessage);
    }
    public static <T> ServerRespose<T> CreateByErrorCodeMessage(int Code,String ErrorMessage){
        return  new ServerRespose<T>(Code,ErrorMessage);
    }
}
