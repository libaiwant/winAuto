package com.qnsz.windowsuiauto.components;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

/**
 * @author 李锡军
 * @date 2023/8/23 14:50
 * 预约会议页面元素封装
 */
public class ReservedConference {
//    预约会议页面-返回按钮
public static WebElement btnAppointmentBack(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'btnAppointmentBack')]");
}

//    预约会议页面-会议主题输入框
public static WebElement lineEditAppointmentSubject(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'lineEditAppointmentSubject')]");
}
//
//    预约会议页面-开始时间选择框
public static WebElement btnDateTime(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'appointmentMeetingContentsWidget.btnDateTime')]");
}
//预约会议页面-会议时长选择框
public static WebElement btnTime(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'btnTime')]");
}
//预约会议页面-会议号选择框
public static WebElement comboBoxAppointmentMeetingCode(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'comboBoxAppointmentMeetingCode')]");
}
//预约会议页面-描述输入框
public static WebElement textEditAppointmentMeetingDetail(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'textEditAppointmentMeetingDetail')]");
}
//预约会议页面-更多设置按钮
public static WebElement btnSetupExpand(AppiumDriver driver) throws Exception {
    return  driver.findElementByXPath("//*[contains(@AutomationId,'btnSetupExpand')]");
}
//更多设置-入会密码勾选框
public static WebElement checkBoxPassword(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'checkBoxPassword')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-入会范围：所有人按钮
public static WebElement rbtnAllPeople(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'rbtnAllPeople')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-入会范围：仅企业内人员按钮
public static WebElement rbtnCompanyPersonnel(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'rbtnCompanyPersonnel')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-入会范围：仅会议邀请人员按钮
public static WebElement rbtnInvitees(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'rbtnInvitees')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-成员入会设置：允许成员在主持人入会前加入按钮
public static WebElement checkBoxAllowEarlyJoinMeeting(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'checkBoxAllowEarlyJoinMeeting')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-成员入会设置：允许成员在主持人入会前加入按钮
public static WebElement checkBoxAutoAllMute(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'checkBoxAutoAllMute')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-会议提醒：提醒所有成员按钮
public static WebElement rbtnAutoCalling(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'rbtnAutoCalling')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//更多设置-会议提醒：不提醒按钮
public static WebElement rbtnNotCalling(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'rbtnNotCalling')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//.提交预约按钮
public static WebElement btnCommitAppointment(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnCommitAppointment')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
//添加参会人员按钮
public static WebElement btnAddParticipants(AppiumDriver driver) throws Exception {
    try {
        return  driver.findElementByXPath("//*[contains(@AutomationId,'btnAddParticipants')]");
    } catch (NoSuchElementException | NoSuchWindowException e) {
        e.printStackTrace();
        return null;
    }
}
}
