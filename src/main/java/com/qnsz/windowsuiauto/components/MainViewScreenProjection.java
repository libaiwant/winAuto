package com.qnsz.windowsuiauto.components;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class MainViewScreenProjection {
    //    获取投屏页文案 :请输入投屏码
    public static String projectionName(AppiumDriver driver) throws Exception {
        try {
            return driver.findElementByXPath("//*[contains(@AutomationId,'startProjection.label_5')]").getAttribute("Name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取下方文案："请确保和设备大屏保持在同一网络"
    public static String projectionArgot(AppiumDriver driver) throws Exception {
        try {
            return driver.findElementByXPath("//*[contains(@AutomationId,'startProjection.label_3')]").getAttribute("Name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
//    投屏码页删除按钮
public static WebElement btnProjectionClose(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'SDBaseDialog.rootView.topWidget.btnClose')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//投屏码页问号按钮
public static WebElement labTips(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'startProjection.labTips')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//获取投屏码页输入框第一位
public static WebElement lineEdit(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'startProjection.lineEdit')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return  null;
}
//获取投屏码页wifi文案
public static String labNetworkState(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'startProjection.labNetworkState')]").getAttribute("Name");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//确定投屏按钮
public static WebElement btnStartProjection(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'btnStartProjection')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//选择投屏内容弹窗-退出页面按钮
public static WebElement CloseButton(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'SDSelectShareScreenWidget.BackgroundWidget.CloseButton')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//选择投屏内容文案：选择投屏内容
public static String labTitleShare(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'SDSelectShareScreenWidget.BackgroundWidget.labTitle')]").getAttribute("Name");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//选择桌面1按钮
public static WebElement labOne(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByName("桌面1");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//选择桌面2按钮
public static WebElement labTwo(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByName("桌面2");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//流畅度优先按钮
public static WebElement cbxFluencyFirst(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'cbxFluencyFirst')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
//btnStartShareScreen开启投屏按钮
public static WebElement btnStartShareScreen(AppiumDriver driver) throws Exception {
    try {
        return driver.findElementByXPath("//*[contains(@AutomationId,'btnStartShareScreen')]");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}
}