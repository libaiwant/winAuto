package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.components.MainView;
import com.qnsz.windowsuiauto.components.MainViewCreateMeeting;
import com.qnsz.windowsuiauto.utils.General;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateMeetingTest extends CreateMeetingTestBase {
    @Description("进入创建会议页面-校验单页面")
    @Test(description = "创建会议页面-校验单页面")
    public void PageVerification() throws Exception{
        Thread.sleep(1000);
//        进入首页获取用户名
        MainView.btnPersonal(appiumDriverOne).click();
        WebElement labName = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'bgWidget.labName')]");
        String accountName = labName.getAttribute("Name");
        labName.click();
        Allure.step("步骤一、进入创建会议页面");
        //点击创建会议按钮
        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
        btnMeeting.click();
//        校验创建会议页面元素
        Allure.step("1、校验默认会议主题");
//        获取会议主题的默认名字
        WebElement editName = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'historyMeetingListWidget.lineEditMeetingSubject')]");
        String editNameAttribute = editName.getAttribute("Value.Value");
        assertEquals("预期和实际状态一致", General.checkState(editName, accountName + "的会议", editNameAttribute), "默认会议主题错误");

        Allure.step("2、校验退出创建会议X按钮是否能够点击");
//        获取按钮的点击状态
        WebElement btnClose = MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne);
        assertTrue(btnClose.isEnabled(), "X按钮应该可用");
        Allure.step("3、校验默认会议号是否是个人会议号");
//        获取会议号选择框里的文本
        WebElement labMeetingNameCreate = MainViewCreateMeeting.labMeetingNameCreateMeeting(appiumDriverOne);
        assertEquals("成功", General.copyVerification(labMeetingNameCreate, "个人会议号"), "默认会议号应该是个人会议号");
        Allure.step("4、校验左侧会议号文案是否是 会议号");
        WebElement meetingNumber = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'SDCreateMeetingDialog.widget.label_7')]");
        assertEquals("成功", General.copyVerification(meetingNumber, "会议号"), "文案应该是会议号");
        Allure.step("5、 校验麦克风是否能够点击");
        assertTrue(MainViewCreateMeeting.btnMicCreateMeeting(appiumDriverOne).isEnabled(), "麦克风按钮应该能够点击");
        Allure.step("6、 校验麦克风默认开关状态");
        WebElement btnMicCreateMeeting = MainViewCreateMeeting.btnMicCreateMeeting(appiumDriverOne);
        String micState = btnMicCreateMeeting.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnMicCreateMeeting, micState, "0"), "麦克风默认状态应该是关闭的");
        Allure.step("7、 校验摄像头是否能够点击");
        assertTrue(MainViewCreateMeeting.btnCameraCreateMeeting(appiumDriverOne).isEnabled(), "摄像头按钮应该能够点击");
        Allure.step("8、 校验摄像头默认开关状态");
        WebElement btnCameraCreateMeeting = MainViewCreateMeeting.btnCameraCreateMeeting(appiumDriverOne);
        String camState = btnCameraCreateMeeting.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnCameraCreateMeeting, camState, "0"), "摄像头默认状态应该是关闭的");
        Allure.step("9、校验默认页面开始会议按钮是否能够点击");
        WebElement btnJoin = MainViewCreateMeeting.btnJoin(appiumDriverOne);
        assertTrue(btnJoin.isEnabled(), "开始会议按钮应该能够点击");
    }
    @Description("创建会议-更换会议主题")
    @Test(description = "创建会议-更换会议主题",dependsOnMethods = "PageVerification")
    public void ChangeMeetingTheme() throws Exception {

//        编辑会议主题
        Allure.step("步骤二、编辑会议主题");
        WebElement lineEditCreateMeeting = MainViewCreateMeeting.lineEditCreateMeeting(appiumDriverOne);
        lineEditCreateMeeting.click();
        for (int i = 0; i < 30; i++) {
            lineEditCreateMeeting.sendKeys(Keys.ARROW_RIGHT);
        }
        for (int i = 0; i < 30; i++) {
            lineEditCreateMeeting.sendKeys(Keys.BACK_SPACE);
        }
        String meetingTitle = "ceshizhuti";
        lineEditCreateMeeting.sendKeys(meetingTitle + Keys.SPACE);
        WebElement editNameAgain = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'historyMeetingListWidget.lineEditMeetingSubject')]");
        String editNameAttributeAgain = editNameAgain.getAttribute("Value.Value");
        assertEquals("预期和实际状态一致", General.checkState(editNameAgain, editNameAttributeAgain, "测试主题"), "编辑会议主题失败");
        Allure.step("步骤三、进入会议内查看会议主题");
        WebElement btnjoin = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
        btnjoin.click();
//       关闭邀请弹窗
        Thread.sleep(4000);
        WebElement deterMineBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        deterMineBtn.click();
        Thread.sleep(1000);
        WebElement meet = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'MeetingSubjectLab')]");
        String meetingName = meet.getAttribute("Name");
        assertEquals("预期和实际状态一致", General.checkState(meet, General.extractChineseCharacters(meetingName), editNameAttributeAgain), "会议内主题和会议外不一致");
//结束会议返回到首页
        appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'EndMeetingButton')]").click();
        appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'CloseRoomButton')]").click();
    }

    @Description("创建会议多次点击创建会议页-关闭按钮")
    @Test(description = "创建会议点击创建会议页-关闭按钮",dependsOnMethods = "ChangeMeetingTheme")
    public void MultipleopeningAndclosing() throws Exception {
        Allure.step("步骤一、打开创建会议页面");
        //        打开会议按钮
        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
        btnMeeting.click();
        try {
            WebElement createPage = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'SDCreateMeetingDialog')]");
            assertTrue(true, "创建会议页面没有出现");
        } catch (NoSuchElementException e) {
            Assert.fail("页面应该存在");
        }
        Allure.step("步骤二、关闭创建会议页面");
//        关闭会议按钮
        WebElement btnCloseCreateMeeting = MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne);
        btnCloseCreateMeeting.click();
        try {
            WebElement createPage = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'SDCreateMeetingDialog')]");
            Assert.fail("页面应该不存在");
        } catch (NoSuchElementException e) {
            assertTrue(true, "页面应该不存在");
        }
//        重新打开
        Allure.step("步骤三、重新打开创建会议界面");
//        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
        btnMeeting.click();
        Thread.sleep(2000);
        try {
            WebElement createPage = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'SDCreateMeetingDialog')]");
            assertTrue(true, "创建会议页面没有出现");
        } catch (NoSuchElementException e) {
            Assert.fail("页面应该存在");
        }
        Allure.step("步骤四、关闭创建会议页面");
        WebElement btnCloseCreateMeetingAgain = MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne);
        btnCloseCreateMeetingAgain.click();
        try {
            WebElement createPage = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'SDCreateMeetingDialog')]");
            Assert.fail("页面应该不存在");
        } catch (NoSuchElementException e) {
            assertTrue(true, "创建会议页面应该不存在");
        }
    }

    @Description("测试机1创建会议-开关麦克风")
    @Test(description = "开关麦克风",dependsOnMethods = "MultipleopeningAndclosing")
    public void BtnMicrophoneList() throws Exception {
        //定位到创建会议按钮
        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
        btnMeeting.click();

        //        查看麦克风默认状态
        Allure.step("查看麦克风默认状态");
        WebElement btnMicCreateMeeting = MainViewCreateMeeting.btnMicCreateMeeting(appiumDriverOne);
        String state = btnMicCreateMeeting.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnMicCreateMeeting, state, "0"), "麦克风默认状态应该是关闭的");
        Allure.step("查看麦克风图标");
        General.saveScreenshotToDisk(appiumDriverOne, "查看麦克风关闭时图标状态");
        //        打开麦克风
        if (state.equals("0")) {
            btnMicCreateMeeting.click();
        }
        Thread.sleep(300);
        Allure.step("校验是否已打开麦克风");
        String stateON = btnMicCreateMeeting.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnMicCreateMeeting, stateON, "1"), "麦克风状态应该是开启的");
        Allure.step("查看麦克风开启后图标");
        General.saveScreenshotToDisk(appiumDriverOne, "查看麦克风开启时图标状态");
        Allure.step("再次关闭麦克风");
        if (stateON.equals("1")) {
            btnMicCreateMeeting.click();
        }
        WebElement btnMicCreate = MainViewCreateMeeting.btnMicCreateMeeting(appiumDriverOne);
        String stateAgain = btnMicCreate.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnMicCreateMeeting, stateAgain, "0"), "麦克风状态应该是关闭的");
//        Allure.step("退出创建会议页面");
//        Thread.sleep(1000);
//        MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne).click();
    }

    @Description("测试机1创建会议-切换麦克风")
    @Test(description = "切换麦克风",dependsOnMethods = "BtnMicrophoneList")
    public void BMicrophoneHandoff() throws Exception {
        //定位到创建会议按钮
        //        WebElement btnMeeting = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnNewMeetingTab')]");
//        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
//        btnMeeting.click();

        Allure.step("切换麦克风设备");
        //点击麦克风设备复选框
        WebElement btnMicListCreateMeeting = MainViewCreateMeeting.btnMicListCreateMeeting(appiumDriverOne);
        btnMicListCreateMeeting.click();
        Allure.step("校验麦克风设备列表左上文案");
        WebElement labDeviceName = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'labDeviceName')]");
        String ldName = labDeviceName.getAttribute("Name");
        assertEquals(ldName, "麦克风", "提示文案一致");
        /*找到设备列表id:listWidget,查询列表下设备，*/
        WebElement listWidget = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'listWidget')]");
        List<WebElement> childElements = listWidget.findElements(By.xpath("//*[contains(@AutomationId,'')]"));
        if (!childElements.isEmpty()) {//设备不为空
            //选择设备
            WebElement firstChildElement = childElements.get(2);
            firstChildElement.click();
        } else {
            System.out.println("未找到列表子元素");
        }
        Allure.step("校验切换麦克风设备成功");
        WebElement contentLab = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'ContentLab')]");
        String contentLabName = contentLab.getAttribute("Name");
        System.out.println("------------" + contentLabName);
        String startSubstring = contentLabName.substring(0, 4);  // 截取开头字符
        String endSubstring = contentLabName.substring(contentLabName.length() - 7);// 截取结尾字符
        assertEquals(startSubstring + endSubstring, "正在使用作为您的麦克风", "切换麦克风成功，提示文案一致");

//        Allure.step("退出创建会议页面");
//        MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne).click();
    }

    @Description("测试机1创建会议-开关摄像头")
    @Test(description = "开关摄像头",dependsOnMethods = "BMicrophoneHandoff")
    public void CameraphoneList() throws Exception {
        //定位到创建会议按钮
        //        WebElement btnMeeting = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnNewMeetingTab')]");
//        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
//        btnMeeting.click();
        //        查看摄像头默认状态
        Allure.step("查看摄像头默认状态");
        WebElement btnCameraCreateMeeting = MainViewCreateMeeting.btnCameraCreateMeeting(appiumDriverOne);
        String camerState = btnCameraCreateMeeting.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnCameraCreateMeeting, camerState, "0"), "摄像头默认状态关闭");

        Allure.step("校验摄像头关闭的预览画面");
        General.saveScreenshotToDisk(appiumDriverOne, "摄像头关闭的预览画面");
        Allure.step("打开摄像头");
        if (camerState.equals("0")) {
            btnCameraCreateMeeting.click();
        }
        Allure.step("查看摄像头开启后预览画面");
        General.saveScreenshotToDisk(appiumDriverOne, "查看摄像头开启时预览画面");
        Thread.sleep(300);
        Allure.step("校验是否已打开摄像头");
        String cameraON = btnCameraCreateMeeting.getAttribute("Toggle.ToggleState");
        assertEquals("预期和实际状态一致", General.checkState(btnCameraCreateMeeting, cameraON, "1"), "摄像头已开启");
        Allure.step("再次关闭摄像头");
        if (cameraON.equals("1")) {
            btnCameraCreateMeeting.click();
        }
        Allure.step("校验摄像头再次关闭后预览画面");
        General.saveScreenshotToDisk(appiumDriverOne, "校验摄像头再次关闭后预览画面");
//        Allure.step("退出创建会议页面");
//        MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne).click();
    }

    @Description("测试机1创建会议-切换摄像头")
    @Test(description = "切换摄像头",dependsOnMethods = "CameraphoneList")
    public void CameraphoneHandoff() throws Exception {
        //定位到创建会议按钮
        //        WebElement btnMeeting = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnNewMeetingTab')]");
//        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
//        btnMeeting.click();
        Allure.step("切换摄像头设备");
        //点击麦克风设备复选框
        WebElement btnCameraListCreateMeeting = MainViewCreateMeeting.btnCameraListCreateMeeting(appiumDriverOne);
        btnCameraListCreateMeeting.click();
        Allure.step("校验摄像头设备列表左上文案");
        WebElement videoName = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'labDeviceName')]");
        String vName = videoName.getAttribute("Name");
        assertEquals(vName, "摄像头", "提示文案一致");

        /*找到设备列表id:listWidget,查询列表下设备，*/
        WebElement listWidgetTwo = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'listWidget')]");
        List<WebElement> childElementsTwo = listWidgetTwo.findElements(By.xpath("//*[contains(@AutomationId,'')]"));
        if (!childElementsTwo.isEmpty()) {//需要有两个摄像头设备
            //选择设备
            WebElement firstChildElementTwo = childElementsTwo.get(1);
            firstChildElementTwo.click();
        } else {
            System.out.println("未找到列表子元素");
        }
        Allure.step("校验切换摄像头设备成功");
        WebElement contentLabVideo = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'ContentLab')]");
        String contentLabVideoName = contentLabVideo.getAttribute("Name");
        System.out.println("------------" + contentLabVideoName);
        String startSubstringVideo = contentLabVideoName.substring(0, 4);  // 截取开头字符
        String endSubstringVideo = contentLabVideoName.substring(contentLabVideoName.length() - 7);// 截取结尾字符
        assertEquals(startSubstringVideo + endSubstringVideo, "正在使用作为您的摄像头", "切换摄像头成功，提示文案一致");
        Allure.step("校验摄像头开启的预览画面");
        General.saveScreenshotToDisk(appiumDriverOne, "摄像头开启的预览画面");
        Allure.step("退出创建会议页面");
        MainViewCreateMeeting.btnCloseCreateMeeting(appiumDriverOne).click();
    }

    @Description("创建个人会议号")
    @Test(description = "创建个人会议号",dependsOnMethods = "CameraphoneHandoff")
    public void CreatePersionMeetingNumber() throws Exception {
        //        打开会议按钮
        WebElement btnMeeting = MainView.btnNewMeetingTab(appiumDriverOne);
        btnMeeting.click();
        //使用个人会议号进入会议
        Thread.sleep(1000);
        WebElement btnjoin = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnJoin')]");
        btnjoin.click();
//        Allure.step();
        Thread.sleep(5000);
//        截图查看会议内页面
        General.saveScreenshotToDisk(appiumDriverOne, "校验个人会议号创建会议");

        Thread.sleep(2000);

        WebElement deterMineBtn = appiumDriverOne.findElementByXPath("//*[contains(@AutomationId,'btnDetermine')]");
        deterMineBtn.click();

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
