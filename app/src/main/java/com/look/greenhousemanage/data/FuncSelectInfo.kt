package com.look.greenhousemanage.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.tooling.preview.Preview


data class FuncSelectInfo(
    val funcName: String,
    val description: String,
    @DrawableRes val sourceId: Int
)

val funcSelectInfoList = listOf(
    FuncSelectInfo(
        "实时监测", "24小时全天候监测大棚环境参数，包括温度、湿度、光照、土壤湿度等关键指标",
        com.look.greenhousemanage.R.drawable.monitoring
    ),
    FuncSelectInfo(
        "智能分析", "基于大数据和人工智能技术，自动分析环境数据，提供科学的种植建议",
        com.look.greenhousemanage.R.drawable.analysising
    ),
    FuncSelectInfo(
        "智能控制", "远程控制大棚设备，实现自动化管理，提高生产效率",
        com.look.greenhousemanage.R.drawable.setting
    ),
    FuncSelectInfo(
        "数据可视化", "直观展示各项参数变化曲线，帮助用户了解作物生长环境",
        com.look.greenhousemanage.R.drawable.dataing
    ),
    FuncSelectInfo(
        "家庭农场", "适合小型家庭农场使用，操作简单，维护成本低",
        com.look.greenhousemanage.R.drawable.farm
    ),
    FuncSelectInfo(
        "规模种植", "适用于大型农业企业，实现标准化、规模化管理",
        com.look.greenhousemanage.R.drawable.managing
    ),
    FuncSelectInfo(
        "科研实验", "为农业科研提供精准的环境数据支持",
        com.look.greenhousemanage.R.drawable.research
    ),
)