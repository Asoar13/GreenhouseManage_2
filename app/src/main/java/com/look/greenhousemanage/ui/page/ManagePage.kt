package com.look.greenhousemanage.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.look.greenhousemanage.data.deviceStatusInfoList
import com.look.greenhousemanage.ui.unit.CtrlDeviceModeCard
import com.look.greenhousemanage.ui.unit.DeviceInfoCard
import com.look.greenhousemanage.ui.unit.PageTitle

@Preview(showBackground = true)
@Composable
fun ManagePreview() {
    ManagePage(Modifier.padding(top = 10.dp))
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ManagePage(
    modifier: Modifier = Modifier
) {
    val deviceCardRatio = 2.1f

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 标题
        item {
            PageTitle(
                mainTitle = "设备控制中心",
                mianColor = Color(0xF01742E8),
                description = "管理和控制大棚内的各种智能设备",
                descColor = Color(0xF01742E8),
                lineHeight = 2.dp,
                lineColor = Color(0xBE566AF5)
            )
        }

        // 模式控制器
        item { CtrlDeviceModeCard(2.3f) }

        // 装置开关
        items(deviceStatusInfoList.chunked(2)) { itemRow ->
            Row(
                modifier = Modifier.fillMaxWidth(0.9f).padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                itemRow.forEach { item ->
                    DeviceInfoCard(
                        deviceCardRatio,
                        deviceName = item.deviceName,
                        status = item.status,
                        mode = item.mode,
                        resourceId = item.resourceId,
                    )
                }
            }
        }
    }
}