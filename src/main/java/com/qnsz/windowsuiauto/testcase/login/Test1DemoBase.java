package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeClass;

/**
 * @author 潘丛林
 * @date 2023/8/9 16:02
 */
public class Test1DemoBase {

    public AppiumDriver appiumDriverOne;
    public AppiumDriver appiumDriverTwo;

    @BeforeClass
    public void init() throws Exception {
        General.showDesktop();
        appiumDriverOne = General.getComputerOne();

        appiumDriverTwo = General.getComputerTwo();

    }

}
