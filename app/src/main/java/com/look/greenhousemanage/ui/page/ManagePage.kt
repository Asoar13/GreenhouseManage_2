package com.look.greenhousemanage.ui.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.look.greenhousemanage.data.deviceStatusInfoList
import com.look.greenhousemanage.ui.unit.CtrlDeviceModeCard
import com.look.greenhousemanage.ui.unit.DeviceInfoCard
import com.look.greenhousemanage.ui.unit.PageTopAppBar

@Composable
fun ManagePage(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        // 顶部导航栏
        PageTopAppBar(
            title = "设备控制中心",
            subtitle = "管理和控制大棚内的各种智能设备"
        )

        // 分隔线
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 1.dp
        )

        // 内容区域
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                CtrlDeviceModeCard(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            items(deviceStatusInfoList.chunked(2)) { itemRow ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    for (item in itemRow) {
                        DeviceInfoCard(
                            modifier = Modifier.weight(1f),
                            deviceName = item.deviceName,
                            status = item.status,
                            mode = item.mode,
                            resourceId = item.resourceId
                        )
                    }
                    // 如果有奇数个设备，添加占位
                    if (itemRow.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}