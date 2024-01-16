package com.qnsz.windowsuiauto.components;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

/**
 * @author 潘丛林
 * @date 2023/8/11 11:20
 */
public class MainView extends General {

    //  加入会议按钮
    public static WebElement btnJoinMeetingTab(AppiumDriver driver) {
        return General.getComponent(driver, "btnJoinMeetingTab");

    }

    //  创建会议按钮
    public static WebElement btnNewMeetingTab(AppiumDriver driver) {
        return General.getComponent(driver, "btnNewMeetingTab");

    }

    //  预约会议按钮
    public static WebElement btnScheduleTab(AppiumDriver driver) {
        return General.getComponent(driver, "btnScheduleTab");

    }

    //  获取发起投屏按钮
    public static WebElement btnProjectionTab(AppiumDriver driver) {
        return General.getComponent(driver, "btnProjectionTab");

    }

    //  获取设置按钮
    public static WebElement btnSetting(AppiumDriver driver) {
        return General.getComponent(driver, "btnSetting");

    }

    //  获取左侧tab栏会议按钮
    public static WebElement btnMeeting(AppiumDriver driver) {
        return General.getComponent(driver, "btnMeeting");

    }

    //  获取左侧tab栏通讯录按钮
    public static WebElement btnContacts(AppiumDriver driver) {
        return General.getComponent(driver, "btnContacts");

    }

    // 日程列表当前时间时间
    public static String labTime(AppiumDriver driver) {
        try {
            return driver.findElementByXPath("//*[contains(@AutomationId,'labTime')]").getAttribute("Name");
        } catch (NoSuchElementException | NoSuchWindowException e) {
            e.printStackTrace();
            return null;
        }
    }

    //  获取日程列表当前日期
    public static String labDay(AppiumDriver driver) {
        try {
            return driver.findElementByXPath("//*[contains(@AutomationId,'labDay')]").getAttribute("Name");
        } catch (NoSuchElementException | NoSuchWindowException e) {
            e.printStackTrace();
            return null;
        }

    }

    //  获取日程列表当前周
    public static String labWeek(AppiumDriver driver) {
        try {
            return driver.findElementByXPath("//*[contains(@AutomationId,'labWeek')]").getAttribute("Name");
        } catch (NoSuchElementException | NoSuchWindowException e) {
            e.printStackTrace();
            return null;
        }
    }

    //  获取左侧tab栏头像按钮
    public static WebElement btnPersonal(AppiumDriver driver) {
        return General.getComponent(driver, "btnPersonal");

    }

    //  获取日程列表更多日程按钮
    public static WebElement btnMoreSchedule(AppiumDriver driver) {
        return General.getComponent(driver, "btnMoreSchedule");

    }

    //  最大化按钮
    public static WebElement btnMaximum(AppiumDriver driver) {
        return General.getComponent(driver, "btnMaximum");

    }

    //  最小化按钮
    public static WebElement btnMinimum(AppiumDriver driver) {
        return General.getComponent(driver, "btnMinimum");

    }

    //  退出应用按钮
    public static WebElement btnClose(AppiumDriver driver) {
        return General.getComponent(driver, "SDHomeView", "btnClose");

    }

    //  主界面
    public static WebElement SDHomeView(AppiumDriver driver) {
        return General.getComponent(driver, "meetingPage");

    }


    //  关闭二次确认弹窗 确认按钮
    public static WebElement cancelButton(AppiumDriver driver) {
        return General.getComponent(driver, "CancelButton", "BackgroundWidget");

    }


}
