package com.qnsz.windowsuiauto.components;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class MainViewJoinMeeting {
    //加入会议页面-会议号输入框按钮
    public static WebElement lineEditJoinMeeting(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'lineEditMeetingRoomCode')]");
    }
    //    加入会议页面-会议号输入框右侧下拉按钮
    public static WebElement btnMeetingCodeDropdown(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'btnMeetingCodeDropdown')]");
    }
    //    加入会议页面-会议号输入框右侧下拉页面-清空按钮
    public static WebElement btnClearAllMeetongCodeHistory(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'btnClearAllMeetongCodeHistory')]");
    }
    //    加入会议页面-删除页面按钮
    public static WebElement btnCloseJoinMeeting(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'SDJoinMeetingDialog.widget.btnClose')]");
    }
    //    加入会议页面-麦克风按钮
    public static WebElement btnMicrophoneJoinMeeting(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'SDJoinMeetingDialog')] and contains(@AutomationId,'btnMicrophone')]");
    }
    //    加入会议页面-获取麦克风状态
//public static String micToggleStateJoinMeeting(AppiumDriver driver) throws Exception {
//    WebElement btnMic = driver.findElementByXPath("//*[contains(@AutomationId,'micControlWidget.btnMicrophone')]");
//    String micState = btnMic.getAttribute("Toggle.ToggleState");
//    return micState;
//}
//    加入会议页面-麦克风设备选择按钮
    public static WebElement btnMicrophoneList(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'btnMicrophoneList')]");
    }

    //    加入会议页面-摄像头按钮
    public static WebElement btnCameraJoinMeeting(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'SDJoinMeetingDialog')] and contains(@AutomationId,'btnCamera')]");
    }
    //    加入会议页面-加入按钮
    public static WebElement btnJoinMeeting(AppiumDriver driver) throws Exception {
        return driver.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
    }
}
