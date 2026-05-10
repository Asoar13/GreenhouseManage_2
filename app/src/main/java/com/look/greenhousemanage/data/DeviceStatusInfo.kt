package com.look.greenhousemanage.data

import androidx.annotation.DrawableRes

data class DeviceStatusInfo(
    val deviceName: String,
    val status: Boolean,
    val mode: String,
    @DrawableRes val resourceId: Int
)

val deviceStatusInfoList = listOf(
    DeviceStatusInfo(
        "照明装置", false, "手动",
        com.look.greenhousemanage.R.drawable.device_light
    ),
    DeviceStatusInfo(
        "通风装置", true, "手动",
        com.look.greenhousemanage.R.drawable.device_fan
    ),
    DeviceStatusInfo(
        "遮阳装置", true, "智能",
        com.look.greenhousemanage.R.drawable.device_shade
    ),
)