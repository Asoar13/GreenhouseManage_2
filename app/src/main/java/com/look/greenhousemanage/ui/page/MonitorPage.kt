package com.look.greenhousemanage.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.look.greenhousemanage.data.enviFactorDataList
import com.look.greenhousemanage.ui.unit.EnviFactorCardDetail
import com.look.greenhousemanage.ui.unit.PageTitle

@Preview(showBackground = true)
@Composable
fun MonitorPreview() {
    MonitorPage(Modifier.padding(10.dp))
}

@Composable
fun MonitorPage(
    modifier: Modifier = Modifier
) {
    val enviFactorCardRatio = 2.3f

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            PageTitle(
                mainTitle = "环境监测中心",
                mianColor = Color(0xF01742E8),
                description = "实时监测大棚环境参数，确保作物最佳生长条件",
                descColor = Color(0xF01742E8),
                lineHeight = 2.dp,
                lineColor = Color(0xBE566AF5)
            )
        }

        items(enviFactorDataList) { item ->
            EnviFactorCardDetail(
                ratio = enviFactorCardRatio,
                factorName = item.factorName,
                facterValue = item.factorValue,
                valueUnit = item.valueUnit,
                sourceId = item.sourceId,
                status = item.status,
                maxValue = item.maxValue,
                minValue = item.minValue,
                suggestion = item.suggestion
            )

            Spacer(modifier = Modifier.padding(vertical = 7.dp))
        }
    }
}