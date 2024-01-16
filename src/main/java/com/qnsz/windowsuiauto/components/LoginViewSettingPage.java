package com.qnsz.windowsuiauto.components;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * @author 潘丛林
 * @date 2023/8/14 10:55
 */
public class LoginViewSettingPage {

    // 主界面-窗口标题
    public static WebElement title(AppiumDriver driver) {
        return General.getComponent(driver, "topWidget", "label");
    }

    // 主界面-关闭按钮
    public static WebElement btnClose(AppiumDriver driver) {
        return General.getComponent(driver, "topWidget", "btnClose");
    }

    // 主界面-服务器设置
    public static WebElement btnServerSetting(AppiumDriver driver) {
        return General.getComponent(driver, "btnServerSetting");
    }

    // 主界面-代理设置
    public static WebElement btnProxySetting(AppiumDriver driver) {
        return General.getComponent(driver, "btnProxySetting");
    }

    // 主界面-关于我们
    public static WebElement proxySettingPageBtnAboutSetting(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "btnAboutSetting");
    }

    // 服务器设置-服务器地址描述
    public static WebElement serverSettingPageServerAddressDescription(AppiumDriver driver) {
        return General.getComponent(driver, "SDServerSettingPage", "label");
    }

    // 服务器设置-服务器输入框
    public static WebElement serverSettingPageLineEditAddr(AppiumDriver driver) {
        return General.getComponent(driver, "SDServerSettingPage", "lineEditAddr");
    }

    // 服务器设置-http端口描述
    public static WebElement serverSettingPageBgWidgetHttpPortDescription(AppiumDriver driver) {
        return General.getComponent(driver, "SDServerSettingPage", "label_2");
    }

    // 服务器设置-http端口输入框
    public static WebElement serverSettingPageLineEditPort(AppiumDriver driver) {
        return General.getComponent(driver, "SDServerSettingPage", "lineEditPort");
    }

    // 服务器设置-保存按钮
    public static WebElement serverSettingPageBtnSave(AppiumDriver driver) {
        return General.getComponent(driver, "SDServerSettingPage", "btnSave");
    }

    // 服务器设置-保存按钮描述信息
    public static WebElement serverSettingPageSaveButtonDescription(AppiumDriver driver) {
        return General.getComponent(driver, "SDServerSettingPage", "label_3");
    }

    // 代理设置-使用网络代理复选框
    public static WebElement proxySettingPageBtnCheckBox(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "btnCheckBox");
    }

    // 代理设置-服务器地址描述
    public static WebElement proxySettingPageServerAddressDescription(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "label");
    }

    // 代理设置-服务器地址输入框
    public static WebElement proxySettingPageLineEditAddr(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "lineEditAddr");
    }

    // 代理设置-https端口描述
    public static WebElement proxySettingPageHttpPortDescription(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "label_2");
    }

    // 代理设置-https端口输入框
    public static WebElement proxySettingPageLineEditPort(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "lineEditPort");
    }

    // 代理设置-保存按钮
    public static WebElement proxySettingPageBtnSave(AppiumDriver driver) {
        return General.getComponent(driver, "SDProxySettingPage", "btnSave");
    }

    // 关于我们-会点点文本
    public static WebElement aboutSettingPagePageTitle(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "label");
    }

    // 关于我们-版本号
    public static WebElement proxySettingPageLabVersionCode(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "labVersionCode");
    }

    // 关于我们-上传日志按钮
    public static WebElement proxySettingPageBtnUpload(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "btnUpload");
    }

    // 关于我们-服务协议
    public static WebElement proxySettingPageBtnServiceAgreement(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "btnServiceAgreement");
    }

    // 关于我们-隐私政策
    public static WebElement proxySettingPageBtnPrivacyPolicy(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "btnPrivacyPolicy");
    }

    // 关于我们-意见反馈邮箱
    public static WebElement proxySettingPageFeedbackMailbox(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "label_4");
    }

    // 关于我们-版权信息
    public static WebElement proxySettingPageCopyrightInformation(AppiumDriver driver) {
        return General.getComponent(driver, "SDAboutSettingPage", "label_5");
    }

}
























