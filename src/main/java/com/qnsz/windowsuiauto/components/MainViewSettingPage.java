package com.qnsz.windowsuiauto.components;

import com.qnsz.windowsuiauto.utils.General;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * @author 潘丛林
 * @date 2023/8/18 14:54
 */
public class MainViewSettingPage {


    //  登出按钮
    public static WebElement btnLogout(AppiumDriver driver) {
        return General.getComponent(driver, "btnLogout");

    }

//    "SDMainWindow.SDBaseDialog.BackgroundWidget.ConfirmButton"

    //  登出按钮二次确认弹窗 确认按钮
    public static WebElement confirmButton(AppiumDriver driver) {
        return General.getComponent(driver, "BackgroundWidget", "ConfirmButton");

    }

}
