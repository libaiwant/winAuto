package com.qnsz.windowsuiauto.components;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class MainViewCreateMeeting {
    //    创建会议页面-会议主题输入框按钮
    public static WebElement lineEditCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'historyMeetingListWidget.lineEditMeetingSubject')]");
    }
    //    创建会议页面-关闭页面按钮
    public static WebElement btnCloseCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'SDCreateMeetingDialog.widget.btnClose')]");
    }
    //    创建会议页面-会议号选择框按钮
    public static WebElement labMeetingNameCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'meetingCodeWidget.labMeetingName')]");
    }
    //    创建会议页面-麦克风按钮
    public static WebElement btnMicCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnMicrophone')]");
    }
    //创建会议页面-麦克风设备选择按钮
    public static WebElement btnMicListCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnMicrophoneList')]");
    }
    //创建会议页面-摄像头按钮
    public static WebElement btnCameraCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnCamera')]");
    }
    //创建会议页面-摄像头设备选择按钮
    public static WebElement btnCameraListCreateMeeting(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnCameraList')]");
    }
    //创建会议页面-开始会议按钮SDCreateMeetingDialog.widget.layoutWidget.btnJoin
    public static WebElement btnJoin(AppiumDriver driver) throws Exception {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
    }
}
