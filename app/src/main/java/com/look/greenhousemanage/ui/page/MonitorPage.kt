package com.look.greenhousemanage.ui.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.look.greenhousemanage.data.enviFactorDataList
import com.look.greenhousemanage.ui.unit.EnviFactorCardDetail
import com.look.greenhousemanage.ui.unit.PageTopAppBar

@Composable
fun MonitorPage(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        // 顶部导航栏
        PageTopAppBar(
            title = "环境监测中心",
            subtitle = "实时监测大棚环境参数，确保作物最佳生长条件"
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
            items(enviFactorDataList) { item ->
                EnviFactorCardDetail(
                    factorName = item.factorName,
                    facterValue = item.factorValue,
                    valueUnit = item.valueUnit,
                    sourceId = item.sourceId,
                    status = item.status,
                    maxValue = item.maxValue,
                    minValue = item.minValue,
                    suggestion = item.suggestion
                )
            }
        }
    }
}