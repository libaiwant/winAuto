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
public class LoginView {

    // 账号登录-账号描述
    public static WebElement accountDescription(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "label_8");
    }

    // 账号登录-账号输入框
    public static WebElement lineEditAccount(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "lineEditAccount");

    }

    // 账号登录-一键清空账号
    public static WebElement btnLoginClearPhone(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "btnLoginClearPhone");

    }

    // 账号登录-历史账号
    public static WebElement btnHistoryPhoneDropdown(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "btnHistoryPhoneDropdown");

    }

    // 账号登录-密码描述
    public static WebElement passwordDescription(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "label_9");

    }

    // 账号登录-密码输入框
    public static WebElement lineEditPassword(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "lineEditPassword");

    }

    // 账号登录-密码输入框-密文明文切换
    public static WebElement checkBoxPwdMode(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "checkBoxPwdMode");

    }

    // 账号登录-登录按钮
    public static WebElement btnLogin(AppiumDriver driver) {
        try {
            return driver.findElementByName("登录");
        } catch (NoSuchElementException | NoSuchWindowException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 账号登录-忘记密码按钮
    public static WebElement btnForgetPassword(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "btnForgetPassword");

    }

    // 账号登录-自动登录复选框
    public static WebElement checkBoxAutoLogin(AppiumDriver driver) {
        return General.getComponent(driver, "loginWidget", "checkBoxAutoLogin");

    }

    // 主页面-账号登录按钮
    public static WebElement btnAccountLogin(AppiumDriver driver) {
        return General.getComponent(driver, "logineMethodWidget", "btnAccountLogin");

    }

    // 主页面-游客入会按钮
    public static WebElement btnVisitorAdmisson(AppiumDriver driver) {
        return General.getComponent(driver, "logineMethodWidget", "btnVisitorAdmisson");

    }

    // 主页面-扫码登陆按钮
    public static WebElement btnSwitchLogin(AppiumDriver driver) {
        return General.getComponent(driver, "loginBgWidget", "btnSwitchLogin");

    }

    // 主页面-发起投屏按钮
    public static WebElement btnProjection(AppiumDriver driver) {
        return General.getComponent(driver, "loginBgWidget", "btnProjection");

    }

    // 主页面-版权信息
    public static WebElement copyrightInformation(AppiumDriver driver) {
        return General.getComponent(driver, "loginBgWidget", "label_5");

    }

    // 主页面-左上角标题
    public static WebElement title(AppiumDriver driver) {
        return General.getComponent(driver, "SDLoginView", "label_2");

    }

    // 扫码登录-标题
    public static WebElement labQrTitle(AppiumDriver driver) {
        return General.getComponent(driver, "QrcodeWidget", "labQrTitle");

    }

    // 扫码登录-描述
    public static WebElement qrDescription(AppiumDriver driver) {
        return General.getComponent(driver, "QrcodeWidget", "label_6");

    }

    // 扫码登录-自动登录按钮
    public static WebElement rbtnQrAutoLogin(AppiumDriver driver) {
        return General.getComponent(driver, "QrcodeWidget", "rbtnQrAutoLogin");

    }

    // 游客入会-会议号描述
    public static WebElement descriptionOfMeetingNumber(AppiumDriver driver) {
        return General.getComponent(driver, "visitorJoinMeetingWidget", "label_10");

    }

    // 游客入会-会议号输入框
    public static WebElement lineEditVisitorAccount(AppiumDriver driver) {
        return General.getComponent(driver, "visitorJoinMeetingWidget", "lineEditVisitorAccount");

    }

    // 游客入会-您的昵称
    public static WebElement nickNameDescription(AppiumDriver driver) {
        return General.getComponent(driver, "visitorJoinMeetingWidget", "label_11");

    }

    // 游客入会-您的昵称输入框
    public static WebElement lineEditVisitorName(AppiumDriver driver) {
        return General.getComponent(driver, "visitorJoinMeetingWidget", "lineEditVisitorName");

    }

    // 游客入会-入会时关闭摄像头
    public static WebElement checkBoxJoinMeetingCloseCamera(AppiumDriver driver) {
        return General.getComponent(driver, "visitorJoinMeetingWidget", "checkBoxJoinMeetingCloseCamera");

    }

    // 游客入会-入会时静音
    public static WebElement checkBoxJoinMeetingMute(AppiumDriver driver) {
        return General.getComponent(driver, "visitorJoinMeetingWidget", "checkBoxJoinMeetingMute");

    }

    // 主界面-设置
    public static WebElement btnSetting(AppiumDriver driver) {
        return General.getComponent(driver, "SDLoginView", "btnSetting");

    }

    // 主界面-最小化按钮
    public static WebElement btnMinimum(AppiumDriver driver) {
        return General.getComponent(driver, "SDLoginView", "btnMinimum");

    }

    // 主界面-关闭按钮
    public static WebElement btnClose(AppiumDriver driver) {
        return General.getComponent(driver, "SDLoginView", "btnClose");

    }

    // 主界面-全部页面
    public static WebElement LoginView(AppiumDriver driver) {
        return General.getComponent(driver, "SDLoginView");

    }

}
