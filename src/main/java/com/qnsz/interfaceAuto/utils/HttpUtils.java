package com.qnsz.interfaceAuto.utils;

import okhttp3.*;

import java.io.IOException;

public class HttpUtils {
    public static String get(String url, String params) {
//        1、创建okhttCclient
        OkHttpClient okHttpClient = new OkHttpClient();
//        2、创建request
        Request request = new Request.Builder().url(url+"?"+params).get().build();
//        3、使用clinet发送请求
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.code());
            System.out.println(response.headers());
            System.out.println(response.body().string());
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  static String post(String url, String params){
        //        1、创建okhttCclient
        OkHttpClient okHttpClient = new OkHttpClient();
//        2、创建requestBody（使用json格式传参）
//        MediaType JSON = MediaType.get("application/json; charset=utf-8");
//        String  jsonBoby="{\"userName\":\"administrator\"," +
//                "\"passWord\"：\"123456Aa\",\"imageId\":\"1\",\"imageCode\":\"2563\"}";
//        RequestBody requestBody = RequestBody.create(JSON, jsonBoby);
//        2、创建requestBody(使用表单传参)
        MediaType type = MediaType.parse("application/x-www-form-urlencode");
        RequestBody requestBody = RequestBody.create(type, params);
        //        2、创建request
        Request request = new Request.Builder().url(url).post(requestBody).build();
//        3、使用clinet发送请求
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.code());
            System.out.println(response.headers());
            System.out.println(response.body().string());
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public  static String  Call(String method,String url,String params){
        if ("get".equalsIgnoreCase(method)){
            return  get(url,params);
        }else if ("post".equalsIgnoreCase(method)){
            return  post(url,params);
        }
        return null;
    }
}
