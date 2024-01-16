package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.components.MainView;
import com.qnsz.windowsuiauto.utils.General;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InviteFrequentlyUsedContactsTest extends InviteFrequentlyUsedContactsTestBase {
    @Description("打开测试机1")
    @Test(description = "主持人连接测试机1登录会点点")
    public void test1LoginHdd() throws Exception {
        Thread.sleep(1000);
        //打开会点点
        WebElement account = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditAccount')]");
        account.click();
        //删除输入框中内容
        for (int i = 0; i < 11; i++) {
            account.sendKeys(Keys.BACK_SPACE);
        }
        account.sendKeys("17630941000");
        WebElement password = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditPassword')]");
        password.click();
        password.sendKeys("123456Aa");
        WebElement loginBtn = appiumDriverOne.findElementByName("登录");
        loginBtn.click();
    }

    @Description("打开测试机2")
    @Test(description = "参会者连接测试机2登录会点点")
    public void test2LoginHdd2() throws InterruptedException {
        Thread.sleep(1000);
        WebElement account = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditAccount')]");
        account.click();
        //删除输入框中内容
        for (int i = 0; i < 11; i++) {
            account.sendKeys(Keys.BACK_SPACE);
        }
        account.sendKeys("17630941001");
        WebElement password = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditPassword')]");
        password.click();
        password.sendKeys("123456Aa");
        WebElement loginBtn = appiumDriverTwo.findElementByName("登录");
        loginBtn.click();
    }

    @Description("测试机1创建会议")
    @Test(description = "主持人创建会议")
    public void test3CreateRoom() throws InterruptedException {
        Thread.sleep(1000);
        //定位到创建会议按钮
        WebElement btnMeeting = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnNewMeetingTab')]");
        btnMeeting.click();
        //开始会议
        WebElement btnjoin = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
        btnjoin.click();
    }

    @Description("测试机1邀请全部常用联系人入会")
    @Test(description = "主持人邀请参会者")
    public void test4InvitePerson() throws Exception {
//        进入会议页面邀请常用联系人 备注：需要将测试机2添加到测试机1的常用联系人里面
        Thread.sleep(3000);
        WebElement check = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'checkBoxAllSelect')]");
        check.click();
//        点击确定
        WebElement btnDetermine = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        btnDetermine.click();
    }

    @Description("测试机2在邀请弹窗界面点击拒绝按钮")
    @Test(description = "参会者拒绝入会")
    public void test5RejectRoom() throws InterruptedException {
        Thread.sleep(2000);
        WebElement btnReject = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'btnReject')]");
        btnReject.click();
    }

    @Description("测试机1在会议内再次邀请全部常用联系人入会")
    @Test(description = "主持人再次邀请参会者入会")
    public void test6InvitePersonAgain() throws InterruptedException {
        //主持人点击邀请按钮，弹出分享邀请和通讯录邀请按钮
        Thread.sleep(2000);
        WebElement inviteButton = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'InviteButton')]");
        inviteButton.click();
//        主持人点击通讯录邀请弹出选择参会者弹窗
        WebElement inviteTxl = appiumDriverOne.findElementByName("       通讯录邀请");
        inviteTxl.click();
        Thread.sleep(3000);
//        主持人全选常用联系人
        WebElement check = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'checkBoxAllSelect')]");
        check.click();
//        点击确定
        WebElement btnDetermine = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        btnDetermine.click();

    }

    @Description("测试机2通过入会邀请弹窗入会")
    @Test(description = "参会者弹窗页面点击确定入会")
    public void test7JoinRoom() throws Exception {
//        参会者点击确定按钮入会
        Thread.sleep(2000);
        WebElement btnEnter = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'btnEnter')]");
        btnEnter.click();
        Thread.sleep(2000);
//        主持人端校验是否成功入会
        Allure.step("主持人校验参会者是否成功入会", () -> {
            WebElement element = appiumDriverOne.findElement(By.xpath("//*[contains(@AutomationId,'videoWidget_2.SDVideoMaskWidget.maskBgWidget.BottomWidget.NameLab')]"));
            String joinName = element.getAttribute("Name");
//            WebElement quit = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'EndMeetingButton')]");
            boolean bool = General.isWebElementPresent(appiumDriverOne, element);

            Assertions.assertAll(
                    () -> Assertions.assertTrue(bool, "参会者成功入会")
//                    () ->Assertions.assertEquals(bool,true,"进入会议能够获取到该元素"),
            );

        });

        Thread.sleep(2000);

        WebElement closeButton = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'CloseButton')]");
        closeButton.click();

        Thread.sleep(2000);

        WebElement closeRoomButton = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'CloseRoomButton')]");
        closeRoomButton.click();

        Thread.sleep(2000);

        WebElement btnClose = MainView.btnClose(appiumDriverOne);
        btnClose.click();

        Thread.sleep(2000);

        WebElement cancelButton = MainView.cancelButton(appiumDriverOne);
        cancelButton.click();

        appiumDriverOne.quit();

    }
}
