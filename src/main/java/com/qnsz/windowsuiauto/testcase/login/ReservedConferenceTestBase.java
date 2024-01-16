package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

/**
 * @author 李锡军
 * @date 2023/8/23 14:41
 */
public class ReservedConferenceTestBase {
    public AppiumDriver appiumDriverOne;

    @BeforeClass
    public void init() throws Exception {
        General.showDesktop();
        appiumDriverOne = General.getComputerOne();

        //登录
        WebElement account = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditAccount')]");
        account.click();
        //删除输入框中内容
        for (int i = 0; i < 11; i++) {
            account.sendKeys(Keys.BACK_SPACE);
        }
        account.sendKeys(General.getConfig("test_1_account"));
        //        定位密码输入框
        WebElement password = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditPassword')]");
        password.click();
        password.sendKeys("123456Aa");
        //        点击登录按钮
        WebElement loginBtn = appiumDriverOne.findElementByName("登录");
        loginBtn.click();

    }

}
