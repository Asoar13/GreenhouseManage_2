package com.look.greenhousemanage.ui.page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.look.greenhousemanage.data.enviFactorDataList
import com.look.greenhousemanage.data.funcSelectInfoList
import com.look.greenhousemanage.ui.unit.EnviFactorCard
import com.look.greenhousemanage.ui.unit.FuncSelectCard
import com.look.greenhousemanage.ui.unit.PageTopAppBar

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPage(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        // 顶部导航栏
        PageTopAppBar(
            title = "智慧农业大棚",
            subtitle = "科技赋能农业，智能引领未来"
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
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // 环境监测卡片横栏
            item {
                Text(
                    text = "环境概览",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(enviFactorDataList) { factorData ->
                        EnviFactorCard(
                            factorName = factorData.factorName,
                            facterValue = factorData.factorValue,
                            valueUnit = factorData.valueUnit,
                            sourceId = factorData.sourceId
                        )
                    }
                }
            }

            // 功能选择区域
            item {
                Text(
                    text = "功能服务",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }

            // 功能卡片网格
            items(funcSelectInfoList.chunked(2)) { rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    for (item in rowItems) {
                        FuncSelectCard(
                            modifier = Modifier.weight(1f),
                            funcName = item.funcName,
                            description = item.description,
                            sourceId = item.sourceId
                        )
                    }
                    // 如果只有一个项，添加占位
                    if (rowItems.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}