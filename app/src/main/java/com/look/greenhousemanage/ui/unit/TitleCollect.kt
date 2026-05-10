package com.look.greenhousemanage.ui.unit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TitlePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PageTitle(
            mainTitle = "环境监测中心",
            mianColor = Color(0xF01742E8),
            description = "实时监测大棚环境参数，确保作物最佳生长条件",
            descColor = Color(0xF01742E8),
            lineHeight = 2.dp,
            lineColor = Color(0xBE566AF5)
        )
    }
}

@Composable
fun PageTitle(
    mainTitle: String,
    mianColor: Color,
    description: String,
    descColor: Color,
    lineHeight: Dp,
    lineColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = mainTitle,
            fontSize = 30.sp,
            color = mianColor,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(bottom = 5.dp, start = 5.dp, end = 5.dp),
            text = description,
            fontSize = 16.sp,
            color = descColor,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.97f)
                .height(lineHeight)
                .background(
                    color = lineColor,
                    shape = RoundedCornerShape(50)
                )
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
    }
}