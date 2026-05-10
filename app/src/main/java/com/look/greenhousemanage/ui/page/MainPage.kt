package com.look.greenhousemanage.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.look.greenhousemanage.data.enviFactorDataList
import com.look.greenhousemanage.data.funcSelectInfoList
import com.look.greenhousemanage.ui.unit.EnviFactorCard
import com.look.greenhousemanage.ui.unit.FuncSelectCard

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MainPage(Modifier.padding(top = 10.dp))
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainPage(
    modifier: Modifier = Modifier
) {
    val factorCardRatio = 1.5f // 环境因素卡片比例
    val funcCardRatio = 1.6f // 环境因素卡片比例

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            // 题目显示
            Column(
                modifier = Modifier.padding(top = 50.dp, bottom = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "智慧农业大棚管理系统",
                    color = Color.Blue,
                    fontSize = 33.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.padding(vertical = 10.dp))

                Text(
                    "科技赋能农业，智能引领未来",
                    color = Color.Blue,
                    fontSize = 20.sp
                )
            }
        }

        item {
            // 环境因素横栏
            LazyRow() {
                enviFactorDataList.forEach { factorData ->
                    item {
                        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                        EnviFactorCard(
                            ratio = factorCardRatio,
                            factorName = factorData.factorName,
                            facterValue = factorData.factorValue,
                            valueUnit = factorData.valueUnit,
                            sourceId = factorData.sourceId
                        )
                    }
                }
            }
            Spacer(Modifier.padding(vertical = 10.dp))
        }


        items(funcSelectInfoList.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (item in rowItems) {
                    FuncSelectCard(
                        ratio =  funcCardRatio,
                        funcName = item.funcName,
                        description = item.description,
                        sourceId = item.sourceId
                        )
                    Spacer(Modifier.padding(horizontal = 6.dp))
                }
            }
        }
    }
}