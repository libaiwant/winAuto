package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.components.MainView;
import com.qnsz.windowsuiauto.components.ReservedConference;
import com.qnsz.windowsuiauto.utils.General;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 李锡军
 * @date 2023/8/23 14:41
 */
public class ReservedConferenceTest extends ReservedConferenceTestBase{
    @Description("预约会议-单页面校验")
    @Test(description = "预约会议-单页面校验")
    public void test1PageVerification() throws Exception {
        //        进入首页获取用户名
        appiumDriverOne.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainView.btnPersonal(appiumDriverOne).click();
        WebElement labName = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'bgWidget.labName')]");
        String accountName = labName.getAttribute("Name");
        labName.click();
//        在首页
        Allure.step("步骤一、校验预约会议按钮是否能够点击");
        assertTrue(MainView.btnScheduleTab(appiumDriverOne).isEnabled(), "预约会议按钮应该能够点击");
        Allure.step("步骤二、进入预约会议页面");
        MainView.btnScheduleTab(appiumDriverOne).click();
        Thread.sleep(1000);
//        校验预约会议页面是否存在
        try {
            WebElement createPage = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'bookMeetingPage')]");
            assertTrue(true);
        } catch (NoSuchElementException e) {
            Assert.fail("预约会议页面应该存在");
        }
        Allure.step("步骤三、查看默认会议主题");
        WebElement editName = ReservedConference.lineEditAppointmentSubject(appiumDriverOne);
        String editNameAttribute = editName.getAttribute("Value.Value");
        System.out.println(accountName+editNameAttribute);
        assertEquals("预期和实际状态一致", General.checkState(editName, accountName + "预约的会议", editNameAttribute), "默认会议主题错误");
        Allure.step("步骤四、查看开始时间");
        String dateTime = ReservedConference.btnDateTime(appiumDriverOne).getAttribute("Name");
//        将日期里面的周几转换成英文
        String dateTimeChange = dateTime.replace("周一", "Mon")
                .replace("周二", "Tue")
                .replace("周三", "Wed")
                .replace("周四", "Thu")
                .replace("周五", "Fri")
                .replace("周六", "Sat")
                .replace("周日", "Sun");
        assertTrue(General.checkDateFormat(dateTimeChange),"日期格式不正确"+dateTime);
        Allure.step("步骤五、查看默认会议时长");
        String defaultTime = ReservedConference.btnTime(appiumDriverOne).getAttribute("Name");
        assertEquals("1小时",defaultTime,"会议默认时长应该是1小时");
        Allure.step("步骤六、查看会议号");
        String defaultMeetingNumber = ReservedConference.comboBoxAppointmentMeetingCode(appiumDriverOne).getAttribute("Name");
        assertEquals("随机会议号",defaultMeetingNumber,"默认会议号应该是随机会议号");
        Allure.step("步骤七、查看描述输入框");
        General.saveScreenshotToDisk(appiumDriverOne,"截图校验描述输入框暗文显示");
        Allure.step("步骤八、查看更多设置");
//        校验

    }
}
