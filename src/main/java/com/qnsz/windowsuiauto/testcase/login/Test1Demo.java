package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.utils.General;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author 潘丛林
 * @date 2023/8/9 11:17
 */
public class Test1Demo extends Test1DemoBase {


    @Description("打开测试机1、2的会点点")
    @Test(description = "打开会点点")
    public void test1() throws Exception {
        Allure.step("步骤一：点击账号输入框");
//        assertTrue(LoginView.lineEditAccount(appiumDriverOne), "应该存在账号输入框");
        WebElement accountComputerOne = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditAccount') and contains(@AutomationId,'loginBgWidget')]");
        accountComputerOne.click();
//        General.saveScreenshotToDisk(appiumDriverOne);
        Allure.step("步骤二：删除账号");
        for (int i = 0; i < 11; i++) {
            accountComputerOne.sendKeys(Keys.BACK_SPACE);
        }
        General.saveScreenshotToDisk(appiumDriverOne, "删除账号步骤");
        Allure.step("步骤三：输入账号");
        accountComputerOne.sendKeys("80100234980");

//        assertTrue(LoginView.lineEditAccount(appiumDriverOne), "应该存在密码输入框");
//        General.saveScreenshotToDisk(appiumDriverOne);
        Allure.step("步骤四：点击密码输入框");
        WebElement passwordComputerOne = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditPassword')]");
        passwordComputerOne.click();
//        General.saveScreenshotToDisk(appiumDriverOne);
        Allure.step("步骤五：输入密码");
        passwordComputerOne.sendKeys("123456Aa");
//        assertTrue(LoginView.btnLogin(appiumDriverOne), "应该存在登录按钮");
//        General.saveScreenshotToDisk(appiumDriverOne);
        Allure.step("步骤六：点击登录按钮");
        WebElement loginBtnComputerOne = appiumDriverOne.findElementByName("登录");
        loginBtnComputerOne.click();
//        General.saveScreenshotToDisk(appiumDriverOne);

    }

    @Description("测试机2打开会点点")
    @Test(description = "打开会点点")
    public void test11() throws Exception {
//        assertTrue(LoginView.lineEditAccount(appiumDriverTwo), "应该存在账号输入框");
        Allure.step("步骤一：点击账号输入框");
        WebElement accountComputerTwo = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditAccount')]");
        accountComputerTwo.click();
        Allure.step("步骤二：删除账号");
        for (int i = 0; i < 11; i++) {
            accountComputerTwo.sendKeys(Keys.BACK_SPACE);
        }
        Allure.step("步骤三：输入账号");
        accountComputerTwo.sendKeys("80100234881");
//        assertTrue(LoginView.lineEditPassword(appiumDriverTwo), "应该存在密码输入框");
        Allure.step("步骤四：点击密码输入框");
        WebElement passwordComputerTwo = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditPassword')]");
        passwordComputerTwo.click();
        Allure.step("步骤五：输入密码");
        passwordComputerTwo.sendKeys("123456Aa");
//        assertTrue(LoginView.btnLogin(appiumDriverTwo), "应该存在登录按钮");
        Allure.step("步骤六：点击登录按钮");
        WebElement loginBtnComputerTwo = appiumDriverTwo.findElementByName("登录");
        loginBtnComputerTwo.click();
    }

    @Description("测试机1创建个人会议室")
    @Test(description = "创建个人会议室")
    public void test2() throws Exception {
        Allure.step("步骤一：点击创建会议");
        Thread.sleep(2000);
        WebElement createRoomBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnNewMeetingTab')]");
        createRoomBtn.click();
        Allure.step("步骤二：点击开始会议");
        WebElement startBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
        startBtn.click();
        Thread.sleep(5000);
        Allure.step("步骤三：关闭主持邀请参会者弹窗");
        WebElement deterMineBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        deterMineBtn.click();

    }

    @Description("测试机2加入个人会议室")
    @Test(description = "参会者权限加入个人会议室")
    public void test3() throws Exception {
        Allure.step("步骤一：主界面点击加入会议");
        Thread.sleep(2000);
        WebElement joinRoomBtn = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'btnJoinMeetingTab')]");
        joinRoomBtn.click();
        Allure.step("步骤二：输入会议号");
        WebElement meettingNumber = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'lineEditMeetingRoomCode')]");
        meettingNumber.click();
        meettingNumber.sendKeys("80100234980");
        Allure.step("步骤三：加入会议弹窗点击加入会议");
        WebElement joinMeettingBtn = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
        joinMeettingBtn.click();

    }

    @Description("测试机1退出会议，通过完整会议号加入会议室")
    @Test(description = "主持人权限加入个人会议室")
    public void test4() throws Exception {
        Allure.step("步骤一：主持人点击结束会议");
        WebElement closeRoomBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'EndMeetingButton')]");
        closeRoomBtn.click();
        Allure.step("步骤二：结束会议弹窗，点击离开会议");
        WebElement leaveRoomBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'LeaveRoomButton')]");
        leaveRoomBtn.click();
        Allure.step("步骤三：主界面主持人点击加入会议");
        WebElement joinRoomBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnJoinMeetingTab')]");
        joinRoomBtn.click();
        Allure.step("步骤四：输入会议号");
        WebElement meettingNumber = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'lineEditMeetingRoomCode')]");
        meettingNumber.click();
        meettingNumber.sendKeys("80100234980");
        Allure.step("步骤五：加入会议弹窗点击加入会议");
        WebElement joinMeettingBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
        joinMeettingBtn.click();
        Thread.sleep(5000);
        Allure.step("步骤六：关闭主持人邀请参会者弹窗");
        WebElement deterMineBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        deterMineBtn.click();
    }

    @Description("测试机1校验左下角通知")
    @Test(description = "参会者退出会议室")
    public void test5() throws Exception {
        Allure.step("步骤一：参会者点击离开会议");
        WebElement closeRoomBtn = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'EndMeetingButton')]");
        closeRoomBtn.click();
        Allure.step("步骤二：结束会议弹窗，点击离开会议");
        WebElement leaveRoomBtn = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'LeaveRoomButton')]");
        leaveRoomBtn.click();

    }

    @Description("测试机1邀请测试机2")
    @Test(description = "主持人邀请参会者")
    public void test6() throws Exception {

        Allure.step("步骤一：点击邀请按钮");
        WebElement inviteButton = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'InviteButton')]");
        inviteButton.click();
        Allure.step("步骤二：邀请弹窗，点击通讯录邀请");
        WebElement closeRoomBtn2 = appiumDriverOne.findElementByName("       通讯录邀请");
        closeRoomBtn2.click();
        Thread.sleep(2000);
        Allure.step("步骤三：选中要邀请的人");
        WebElement frequentContactsListView = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'frequentContactsListView')]");
        List<WebElement> elements = frequentContactsListView.findElements(By.xpath("//*[contains(@AutomationId,'')]"));
        for (int i = 0; i < elements.size(); i++) {
            if (i < 1) {
                // 跳过前两个元素
                continue;
            }
            General.click(elements.get(i).getLocation().x + 15, elements.get(i).getLocation().y + 20);
        }
        Allure.step("步骤四：邀请弹窗，点击确定");
        WebElement btnDetermine = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        btnDetermine.click();
    }

    @Description("测试机2接受邀请，进入会议")
    @Test(description = "参会者接受邀请")
    public void test7() throws Exception {
        Allure.step("步骤一：参会者接受邀请");
        Thread.sleep(1000);
        WebElement btnEnter = appiumDriverTwo.findElementByXPath("//*[contains(@AutomationId,'btnEnter')]");
        btnEnter.click();

    }

//    设置的关闭按钮
//    服务器设置
//    账号登录
//    手机号登录
//    自动登录
//    游客入会
//    关闭按钮


}
