package com.look.greenhousemanage.data

import androidx.annotation.DrawableRes
import androidx.core.R

data class EnviFactorData(
    val factorName: String,
    val factorValue: Float,
    val valueUnit: String,
    @DrawableRes val sourceId: Int,
    val status: String,
    val maxValue: Float,
    val minValue: Float,
    val suggestion: String
)

val enviFactorDataList = listOf(
    EnviFactorData(
        "空气温度", 20f, "℃",
        com.look.greenhousemanage.R.drawable.air_tmp,
        status = "正常", 40f, 0f, "合适 15~25 区间"
    ),
    EnviFactorData(
        "空气湿度", 80f, "%",
        com.look.greenhousemanage.R.drawable.air_humi,
        status = "正常", 100f, 0f, "合适 40~50 区间"
    ),
    EnviFactorData(
        "土壤温度", 15f, "℃",
        com.look.greenhousemanage.R.drawable.soil_tmp,
        status = "正常", 40f, 0f, "合适 15~25 区间"
    ),
    EnviFactorData(
        "土壤湿度", 80f, "%",
        com.look.greenhousemanage.R.drawable.soil_himi,
        status = "正常", 100f, 0f, "合适 45~55 区间"
    ),
    EnviFactorData(
        "光照强度", 550f, "lux",
        com.look.greenhousemanage.R.drawable.light,
        status = "正常", 2000f, 0f, "合适 800~1500 区间"
    ),
    EnviFactorData(
        "二氧化碳", 200f, "ppm",
        com.look.greenhousemanage.R.drawable.co2,
        status = "正常", 800f, 0f, "合适 400~500 区间"
    ),
)