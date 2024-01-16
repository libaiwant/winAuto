package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;

/**
 * @author 李锡军
 * @date 2023/8/21 10:18
 */
public class InviteFrequentlyUsedContactsTestBase {
    public AppiumDriver appiumDriverOne;
    public AppiumDriver appiumDriverTwo;

    @BeforeClass
    public void init() throws Exception {
        General.showDesktop();
        appiumDriverOne = General.getComputerOne();
        appiumDriverTwo = General.getComputerTwo();

    }
}
