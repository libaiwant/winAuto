package com.qnsz.windowsuiauto.testcase.login;

import com.qnsz.windowsuiauto.components.LoginView;
import com.qnsz.windowsuiauto.components.LoginViewSettingPage;
import com.qnsz.windowsuiauto.components.MainView;
import com.qnsz.windowsuiauto.components.MainViewSettingPage;
import com.qnsz.windowsuiauto.utils.General;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author 潘丛林
 * @date 2023/8/14 10:08
 */
public class StartPage extends StartPageBase {

    @Description("多次点击起始页关闭按钮")
    @Test(description = "多次点击起始页关闭按钮")
    public void test1() throws Exception {
        WebElement btnClose = LoginView.btnClose(appiumDriverOne);
        btnClose.click();
        appiumDriverOne.quit();
        Thread.sleep(2000);
        appiumDriverOne = General.getComputerOne();
        Thread.sleep(1000);
        WebElement btnCloseAgain = LoginView.btnClose(appiumDriverOne);
        assertNotNull(btnCloseAgain, "起始页不应该存在");
        btnCloseAgain.click();
        WebElement loginView = LoginView.LoginView(appiumDriverOne);
        assertNull(loginView, "起始页不应该存在");

    }

    @Description("账号密码登录")
    @Test(description = "账号密码登录")
    public void test2() throws Exception {
        appiumDriverOne.quit();
        Thread.sleep(2000);
        appiumDriverOne = General.getComputerOne();
        Allure.step("步骤一：点击账号输入框");
        WebElement accountComputerOne = LoginView.lineEditAccount(appiumDriverOne);
        accountComputerOne.click();
        Allure.step("步骤二：删除账号");
        for (int i = 0; i < 11; i++) {
            accountComputerOne.sendKeys(Keys.BACK_SPACE);
        }
        Allure.step("步骤三：输入账号");
        accountComputerOne.sendKeys(General.getConfig("test_1_account"));
        Allure.step("步骤四：点击密码输入框");
        WebElement passwordComputerOne = LoginView.lineEditPassword(appiumDriverOne);
        passwordComputerOne.click();
        Allure.step("步骤五：输入密码");
        passwordComputerOne.sendKeys("123456Aa");
        Allure.step("步骤六：点击登录按钮");
        WebElement loginBtnComputerOne = LoginView.btnLogin(appiumDriverOne);
        loginBtnComputerOne.click();
        Thread.sleep(2000);
        WebElement btnJoinMeetingTab = MainView.btnJoinMeetingTab(appiumDriverOne);
        assertNotNull(btnJoinMeetingTab, "主界面应该存在");

        WebElement btnClose = MainView.btnClose(appiumDriverOne);
        btnClose.click();
        WebElement cancelButton = MainView.cancelButton(appiumDriverOne);
        cancelButton.click();

        appiumDriverOne.quit();
        appiumDriverOne = General.getComputerOne();



    }

    @Description("自动登录")
    @Test(description = "自动登录")
    public void test3() throws Exception {

        Allure.step("步骤一：点击账号输入框");
        WebElement accountComputerOne = LoginView.lineEditAccount(appiumDriverOne);
        accountComputerOne.click();
        Allure.step("步骤二：删除账号");
        for (int i = 0; i < 11; i++) {
            accountComputerOne.sendKeys(Keys.BACK_SPACE);
        }
        Allure.step("步骤三：输入账号");
        accountComputerOne.sendKeys(General.getConfig("test_1_account"));
        Allure.step("步骤四：点击密码输入框");
        WebElement passwordComputerOne = LoginView.lineEditPassword(appiumDriverOne);
        passwordComputerOne.click();
        Allure.step("步骤五：输入密码");
        passwordComputerOne.sendKeys("123456Aa");
        Allure.step("步骤六：勾选自动登录按钮");
        WebElement checkBoxAutoLogin = LoginView.checkBoxAutoLogin(appiumDriverOne);
        checkBoxAutoLogin.click();
        Allure.step("步骤七：点击登录按钮");
        WebElement loginBtnComputerOne = LoginView.btnLogin(appiumDriverOne);
        loginBtnComputerOne.click();
        Thread.sleep(2000);
        WebElement btnJoinMeetingTab = MainView.btnJoinMeetingTab(appiumDriverOne);
        assertNotNull(btnJoinMeetingTab, "主界面应该存在");

        WebElement btnClose = MainView.btnClose(appiumDriverOne);
        btnClose.click();
        WebElement cancelButton = MainView.cancelButton(appiumDriverOne);
        cancelButton.click();

        appiumDriverOne.quit();
        appiumDriverOne = General.getComputerOne();

        Thread.sleep(2000);
        WebElement btnJoinMeetingTabAgain = MainView.btnJoinMeetingTab(appiumDriverOne);
        assertNotNull(btnJoinMeetingTabAgain, "主界面应该存在");

        WebElement btnSetting = MainView.btnSetting(appiumDriverOne);
        btnSetting.click();
        WebElement btnLogout = MainViewSettingPage.btnLogout(appiumDriverOne);
        btnLogout.click();
        WebElement confirmButton = MainViewSettingPage.confirmButton(appiumDriverOne);
        confirmButton.click();

    }

    @Description("切换服务器")
    @Test(description = "切换服务器")
    public void test4() throws Exception {
        WebElement btnSetting = LoginView.btnSetting(appiumDriverOne);
        btnSetting.click();
        WebElement btnServerSetting = LoginViewSettingPage.btnServerSetting(appiumDriverOne);
        btnServerSetting.click();
        WebElement serverSettingPageLineEditAddr = LoginViewSettingPage.serverSettingPageLineEditAddr(appiumDriverOne);
        serverSettingPageLineEditAddr.click();

        for (int i = 0; i < 30; i++) {
            serverSettingPageLineEditAddr.sendKeys(Keys.ARROW_RIGHT);
        }


        for (int i = 0; i < 30; i++) {
            serverSettingPageLineEditAddr.sendKeys(Keys.BACK_SPACE);
        }


        serverSettingPageLineEditAddr.sendKeys("meeting.onlineinline.com");
        WebElement serverSettingPageBtnSave = LoginViewSettingPage.serverSettingPageBtnSave(appiumDriverOne);
        serverSettingPageBtnSave.click();

        WebElement lineEditAccount = LoginView.lineEditAccount(appiumDriverOne);
        String Value = lineEditAccount.getAttribute("Value.Value");
        Thread.sleep(2000);
        assertNull(Value, "账号应该是测试账号1");

        WebElement btnSettingAgain = LoginView.btnSetting(appiumDriverOne);
        btnSettingAgain.click();
        WebElement btnServerSettingAgain = LoginViewSettingPage.btnServerSetting(appiumDriverOne);
        btnServerSettingAgain.click();
        WebElement serverSettingPageLineEditAddrAgain = LoginViewSettingPage.serverSettingPageLineEditAddr(appiumDriverOne);
        serverSettingPageLineEditAddrAgain.click();

        for (int i = 0; i < 30; i++) {
            serverSettingPageLineEditAddrAgain.sendKeys(Keys.ARROW_RIGHT);
        }

        serverSettingPageLineEditAddrAgain.sendKeys(Keys.LEFT_SHIFT);

        for (int i = 0; i < 30; i++) {
            serverSettingPageLineEditAddrAgain.sendKeys(Keys.BACK_SPACE);
        }

        serverSettingPageLineEditAddrAgain.sendKeys("172.25.11.125");
        WebElement serverSettingPageBtnSaveAgain = LoginViewSettingPage.serverSettingPageBtnSave(appiumDriverOne);
        serverSettingPageBtnSaveAgain.click();
        Thread.sleep(2000);
        WebElement lineEditAccountAgagin = LoginView.lineEditAccount(appiumDriverOne);
        String ValueAgain = lineEditAccountAgagin.getAttribute("Value.Value");
        assertEquals(General.getConfig("test_1_account"), ValueAgain, "账号应该是测试账号1");
    }


    @Description("校验登录页元素")
    @Test(description = "校验登录页元素")
    public void test0() throws Exception {

        Allure.step("步骤一：校验登录页元素");
        // 登录描述
        WebElement accountDescription = LoginView.accountDescription(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(accountDescription, "账 号", "Name"), "账号的描述应该是：“账 号”");
        // 登录输入框
        WebElement lineEditAccount = LoginView.lineEditAccount(appiumDriverOne);
        assertTrue(lineEditAccount.isEnabled(), "登录输入框应该可用");
        // 一键清除账号按钮
        WebElement btnLoginClearPhone = LoginView.btnLoginClearPhone(appiumDriverOne);
        assertTrue(btnLoginClearPhone.isEnabled(), "一键清除账号按钮应该可用");
        // 历史账号按钮
        WebElement btnHistoryPhoneDropdown = LoginView.btnHistoryPhoneDropdown(appiumDriverOne);
        assertTrue(btnHistoryPhoneDropdown.isEnabled(), "历史账号按钮应该可用");
        // 密码描述
        WebElement passwordDescription = LoginView.passwordDescription(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(passwordDescription, "密 码", "Name"), "密码描述应该是“密 码”");
        // 密码输入框
        WebElement lineEditPassword = LoginView.lineEditPassword(appiumDriverOne);
        assertTrue(lineEditPassword.isEnabled(), "密码输入框应该可用");
        // 登录按钮
        WebElement btnLogin = LoginView.btnLogin(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(btnLogin, "登录", "Name"), "登录按钮的文案应该是”登录“");
        // 忘记密码按钮
        WebElement btnForgetPassword = LoginView.btnForgetPassword(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(btnForgetPassword, "忘记密码？", "Name"), "忘记密码按钮的文案是“忘记密码？”");
        // 自动登录复选框
        WebElement checkBoxAutoLogin = LoginView.checkBoxAutoLogin(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(checkBoxAutoLogin, "自动登录", "Name"), "自动登录复选框的文案是”自动登录“");
        // 账号登录按钮
//        WebElement btnAccountLogin = LoginView.btnAccountLogin(appiumDriverOne);
//        assertEquals("成功", General.copyVerificationAttributes(btnAccountLogin, "帐号登录", "Name"), "账号登录按钮的文案应该是“账号登录”");
        // 游客入会按钮
        WebElement btnVisitorAdmisson = LoginView.btnVisitorAdmisson(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(btnVisitorAdmisson, "游客入会", "Name"), "游客入会按钮的文案应该是”游客入会“");
        // 二维码登录按钮
        WebElement btnSwitchLogin = LoginView.btnSwitchLogin(appiumDriverOne);
        assertTrue(btnSwitchLogin.isEnabled(), "登录输入框应该可用");
        // 发起投屏按钮
        WebElement btnProjection = LoginView.btnProjection(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(btnProjection, "发起投屏", "Name"), "发起投屏按钮的文案应该是“发起投屏”");
        // 标题
        WebElement title = LoginView.title(appiumDriverOne);
        assertEquals("成功", General.copyVerificationAttributes(title, "会点点", "Name"), "标题的文案应该是“会点点”");
        // 设置按钮
        WebElement btnSetting = LoginView.btnSetting(appiumDriverOne);
        assertTrue(btnSetting.isEnabled(), "登录输入框应该可用");
        // 最小化按钮
        WebElement btnMinimum = LoginView.btnMinimum(appiumDriverOne);
        assertTrue(btnMinimum.isEnabled(), "登录输入框应该可用");
        // 关闭按钮
        WebElement btnClose = LoginView.btnClose(appiumDriverOne);
        assertTrue(btnClose.isEnabled(), "登录输入框应该可用");
    }

}
