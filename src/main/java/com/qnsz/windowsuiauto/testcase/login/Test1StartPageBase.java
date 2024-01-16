package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;

/**
 * @author 潘丛林
 * @date 2023/8/14 10:08

 */
public class Test1StartPageBase {

    public AppiumDriver appiumDriverOne;
    public AppiumDriver appiumDriverTwo;


    @BeforeTest
    public void init() throws Exception {
        General.showDesktop();
        appiumDriverOne = General.getComputerOne();

//        appiumDriverTwo = General.getComputerTwo();
//        WebElement accountComputerOne = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditAccount')]");
//        accountComputerOne.click();
//        for (int i = 0; i < 11; i++) {
//            accountComputerOne.sendKeys(Keys.BACK_SPACE);
//        }
//        accountComputerOne.sendKeys("80100234881");
//        WebElement passwordComputerOne = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditPassword')]");
//        passwordComputerOne.click();
//        passwordComputerOne.sendKeys("123456Aa");
//        WebElement loginBtnComputerOne = appiumDriverTwo.findElementByName("登录");
//        loginBtnComputerOne.click();

    }



}
