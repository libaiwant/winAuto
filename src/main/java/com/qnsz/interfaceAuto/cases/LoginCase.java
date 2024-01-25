package com.qnsz.interfaceAuto.cases;

import com.qnsz.interfaceAuto.constants.Constants;
import com.qnsz.interfaceAuto.utils.HttpUtils;
import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

public class LoginCase {
    @Test
    public  void  testLogin(String params){
        String url= Constants.LOGIN_URL;
        String method=Constants.METHOD;
//        String params= "{\n" +
//                "    \"uuid\": \""+username+"\",\n" +
//                "    \"password\": \""+new Md5Util().encode16(password)+"\",\n" +
//                "    \"accessRequired\": true,\n" +
//                "    \"verCode\": \"天生我才必有用,下一句是什么\"\n" +
//                "}";
        String body= HttpUtils.Call(method,url,params);
    }


}
