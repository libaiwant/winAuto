package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;

/**
 * @author 潘丛林
 * @version 1.0
 * @date 2023/8/9 16:02
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * 项目名称:  WindowsUIAuto
 * 文件名称:
 * 软件包名称：com.qnsz.windowsuiauto.testcase.login
 */
public class Test1Base {

    public AppiumDriver appiumDriverOne;
    public AppiumDriver appiumDriverTwo;

    @BeforeTest
    public void init() throws Exception {
        General.showDesktop();
        appiumDriverOne = General.getComputerOne();

        appiumDriverTwo = General.getComputerTwo();

    }

}
