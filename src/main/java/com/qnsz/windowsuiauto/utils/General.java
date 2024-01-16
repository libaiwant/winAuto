package com.qnsz.windowsuiauto.utils;


import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.awt.Point;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 潘丛林
 * @version 1.0
 * @date 2023/8/9 10:00
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 * 项目名称:  WindowsUIAuto
 * 文件名称:
 * 软件包名称：com.qnsz.windowsuiauto.utils
 */

public class General {
    // 显示桌面
    public static void showDesktop() throws Exception {
        try {
            Robot robot = new Robot();

            // 按下 Win + D 键组合
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);

            // 释放按键
            robot.keyRelease(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_WINDOWS);

            // 等待一小段时间以确保显示桌面
            Thread.sleep(500);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 获取测试机1的appium实例
    public static AppiumDriver getComputerOne() throws Exception {

        DesiredCapabilities appiumCapabilities = new DesiredCapabilities();
        appiumCapabilities.setCapability("app", General.getConfig("hdd_app_path"));
        appiumCapabilities.setCapability("platformName", "Windows");
        appiumCapabilities.setCapability("deviceName", "WindowsPC");
        appiumCapabilities.setCapability("automationName", "Windows");
        return new AppiumDriver(new URL(General.getConfig("first_driver_path")), appiumCapabilities);

    }

    // 获取测试机2的appium实例
    public static AppiumDriver getComputerTwo() throws Exception {

        DesiredCapabilities appiumCapabilities = new DesiredCapabilities();
        appiumCapabilities.setCapability("app", General.getConfig("hdd_app_path"));
        appiumCapabilities.setCapability("platformName", "Windows");
        appiumCapabilities.setCapability("deviceName", "WindowsPC");
        appiumCapabilities.setCapability("automationName", "Windows");
        return new AppiumDriver(new URL(General.getConfig("sencond_driver_path")), appiumCapabilities);

    }

    // 读取配置文件
    public static String getConfig(String options) throws Exception {

        String returnValue = null;
        try {
            // 读取配置文件
            InputStream inputStream = General.class.getClassLoader().getResourceAsStream("config.yaml");
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);

            // 获取配置项appiumServerURL
            returnValue = String.valueOf(config.get(options));

            // 关闭输入流
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    //  输入屏幕坐标，鼠标左键点击
    public static void click(int x, int y) throws Exception {
        try {
            Robot robot = new Robot();

            // 获取当前鼠标位置
            Point currentMousePos = MouseInfo.getPointerInfo().getLocation();
            int offsetX = x - currentMousePos.x;
            int offsetY = y - currentMousePos.y;

            // 移动鼠标到目标位置
            robot.mouseMove(currentMousePos.x + offsetX, currentMousePos.y + offsetY);

            // 按下鼠标左键
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

            // 释放鼠标左键
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }




    public static String copyVerificationAttributes(WebElement obj, String expectedOutcome, String attributes) {
        if (obj == null) {
            return "获取元素失败";
        } else {
            String name;
            try {
                name = obj.getAttribute(attributes);
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                e.printStackTrace();
                return "获取元素失败";
            }
            if (name.equals(expectedOutcome)) {
                return "成功";
            }
            return "文案不一致";
        }
    }

    //  保存当前屏幕状态到本地
    public static void saveScreenshotToDisk(AppiumDriver driver, String name) {
        try {
            // 获取屏幕截图
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 设置保存路径
            String savePath ="D:\\Pic";

            // 生成日期格式的文件名
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String fileName = dateFormat.format(new Date()) + ".png";

            // 保存截图文件
            File saveFile = new File(savePath, name + fileName);
            FileUtils.copyFile(screenshotFile, saveFile);

            System.out.println("Screenshot saved at: " + saveFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save screenshot.");
        }
    }


    // 根据automationid获取组件
    public static WebElement getComponent(AppiumDriver driver, String firstAutomationId, String secondAutomationIdTwo) {
        try {
            String xpath = "//*[contains(@AutomationId,'" + firstAutomationId +
                    "') and contains(@AutomationId,'" + secondAutomationIdTwo +
                    "')]";
            return driver.findElementByXPath(xpath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 根据automationid获取组件
    public static WebElement getComponent(AppiumDriver driver, String firstAutomationId) {
        try {
            String xpath = "//*[contains(@AutomationId,'" + firstAutomationId + "')]";
            return driver.findElementByXPath(xpath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //    校验两个元素的状态
    public static String checkState(WebElement obj, String actual, String expectedOutcome) {
        if (obj == null) {
            return "获取元素为空";
        } else {
            if (actual.equals(expectedOutcome)) {
                return "预期和实际状态一致";
            }
            return "结果不一致";
        }
    }

    //    获取字符串里的中文
    public static String extractChineseCharacters(String input) {
        String regex = "[\\u4e00-\\u9fa5]+"; // 匹配中文字符的正则表达式
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group());
        }

        return result.toString();
    }

    public static String copyVerification(WebElement obj, String expectedOutcome) {
        if (obj == null) {
            return "获取元素失败";
        } else {
            if (obj.getAttribute("Name").equals(expectedOutcome)) {
                return "成功";
            }
            return "文案不一致";
        }
    }

    //    查看是否能够找到某元素
    public static boolean isWebElementPresent(WebDriver driver, WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static boolean isElementPresent(WebDriver driver, By by) throws Exception {
        try {
            WebElement element = driver.findElement(by);
            return element != null;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    //校验日期格式
    public static boolean checkDateFormat(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d EEE HH:mm", Locale.ENGLISH);
            LocalDateTime.parse(dateString, formatter);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }



}
