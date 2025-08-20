package com.example.laboratory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/static")
@Tag(name = "静态数据接口", description = "返回固定数据的API接口")
public class StaticDataController {

    @Operation(summary = "实验室介绍", description = "返回实验室介绍信息")
    @GetMapping("/lab-intro")
    public String getLabIntroduction() {
        return "先空着，后续发";
    }

    @Operation(summary = "方向介绍", description = "返回各个开发方向的详细介绍")
    @GetMapping("/direction-intro")
    public String getDirectionIntroduction() {
        return "嵌入式开发简介：嵌入式开发主要是为特定硬件平台开发专用软件，通常用于微控制器、单片机、IoT设备等。\n" +
               "后台开发简介：后台开发主要负责服务器端的逻辑处理、数据库管理和业务功能的实现，是整个系统的\"大脑\"。\n" +
               "前端开发简介：前端开发主要关注用户界面的设计和实现，通过HTML、CSS、JavaScript等技术将视觉设计转化为交互体验。\n" +
               "安卓开发简介：安卓开发专注于为Android操作系统平台创建移动应用，覆盖智能手机、平板等设备。";
    }

    @Operation(summary = "方向数据", description = "返回各个方向的详细学习内容和技能要求")
    @GetMapping("/direction-data")
    public String getDirectionData() {
        return "嵌入式（Embedded Systems）：\n" +
               "基础知识： 学习嵌入式系统的基本原理、硬件结构和编程语言（如C、C++）。学习硬件： 掌握单片机、传感器、嵌入式系统的设计和开发。RTOS学习： 熟悉实时操作系统（RTOS）的使用和应用。\n" +
               "项目实践： 参与嵌入式项目，如智能家居、物联网设备等，实践应用技能。\n\n" +
               "后台开发（Backend Development）：\n" +
               "编程语言： 学习后台开发常用的编程语言，如Java、Python、Node.js等。数据库： 掌握数据库设计和管理，如MySQL、MongoDB等。\n" +
               "框架技术： 学习后台开发框架，如Spring、Django等。\n" +
               "微服务架构： 了解微服务架构和RESTful API设计。\n" +
               "安全和性能优化： 学习如何保障系统安全性和性能优化。\n\n" +
               "前端开发（Frontend Development）：\n" +
               "HTML/CSS/JavaScript： 掌握前端基础技术，构建网页布局和交互效果。框架和库： 学习流行的前端框架和库，如React、Vue.js等。\n" +
               "响应式设计： 了解响应式网页设计和移动端适配。\n" +
               "版本控制： 掌握Git等版本控制工具的使用。\n" +
               "跨平台开发： 学习跨平台开发技术，如React Native、Flutter等。\n\n" +
               "安卓开发（Android Development）：\n" +
               "Java/Kotlin： 掌握Java或Kotlin编程语言。\n" +
               "Android SDK： 学习Android开发工具和框架。\n" +
               "布局和界面设计： 了解Android布局和用户界面设计。\n" +
               "数据存储： 学习Android数据存储技术，如SQLite、Room等。\n" +
               "发布和优化： 学习应用发布流程和性能优化技巧。";
    }

    @Operation(summary = "奖项介绍", description = "返回实验室获得的奖项和荣誉")
    @GetMapping("/awards")
    public List<String> getAwards() {
        return Arrays.asList(
                "全国仿真创新设计大赛国一",
                "全国大学生计算机设计大赛西北赛区二等奖",
                "数学建模大赛校赛一等奖",
                "互联网➕校赛二等奖",
                "24年TI杯电子设计竞赛省一",
                "蓝桥杯c/c++省一",
                "嵌入式系统专题邀请赛(英特尔杯)三等奖等"
        );
    }
}