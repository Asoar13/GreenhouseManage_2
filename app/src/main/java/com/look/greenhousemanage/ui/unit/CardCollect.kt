package com.look.greenhousemanage.ui.unit

import android.annotation.SuppressLint
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.look.greenhousemanage.R

@Preview
@Composable
fun CardPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF4EE7E7)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EnviFactorCard(
            2.0f,
            "二氧化碳", 80f,
            "%",
            R.drawable.co2
        )
        FuncSelectCard(
            2.0f,
            "智能分析",
            "基于大数据和人工智能技术，自动分析环境数据，提供科学的种植建议",
            R.drawable.analysising
        )
        EnviFactorCardDetail(
            2.0f,
            "二氧化碳", 60f,
            "%",
            R.drawable.co2,
            "正常",
            100f,
            0f,
            "适合 20~30 区间"
        )
        DeviceInfoCard(
            2.0f,
            "光照装置",
            true,
            "手动",
            R.drawable.device_light
        )
        CtrlDeviceModeCard(2.0f)
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun EnviFactorCard(
    ratio: Float,
    factorName: String,
    facterValue: Float,
    valueUnit: String,
    @DrawableRes sourceId: Int
) {
    Card(
        modifier = Modifier
            .size((105 * ratio).dp, (60 * ratio).dp)
            .border(
                (1 * ratio).dp,
                color = Color(0.349f, 0.349f, 0.851f, 1.0f),
                shape = RoundedCornerShape(20)
            )
            .clip(RoundedCornerShape(20)),
        colors = CardDefaults.cardColors(containerColor = Color(0.349f, 0.349f, 0.851f, 0.8f)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding((5 * ratio).dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 数值显示
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    String.format("%.0f", facterValue),
                    fontSize = (22 * ratio).sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    valueUnit,
                    fontSize = (18 * ratio).sp,
                    color = Color.White,
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                // 图片显示
                Image(
                    painter = painterResource(sourceId),
                    contentDescription = factorName,
                    modifier = Modifier
                        .size((15 * ratio).dp)
                        .clip(RoundedCornerShape(100)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.padding(horizontal = (2 * ratio).dp))
                // 文字显示
                Text(factorName, fontSize = (14 * ratio).sp, color = Color.White)
            }
        }
    }
}

@Composable
fun FuncSelectCard(
    ratio: Float,
    funcName: String,
    description: String,
    @DrawableRes sourceId: Int
) {
    Card(
        modifier = Modifier
            .size((105 * ratio).dp, (90 * ratio).dp),
        elevation = CardDefaults.cardElevation(defaultElevation = (2 * ratio).dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
        shape = RoundedCornerShape(16)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding((5 * ratio).dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 图片显示
            Image(
                painter = painterResource(sourceId),
                contentDescription = funcName,
                modifier = Modifier
                    .size((30 * ratio).dp)
                    .clip(RoundedCornerShape(30)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.padding(vertical = (1 * ratio).dp))

            // 名字显示
            Text(
                text = funcName,
                fontSize = (12 * ratio).sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.padding(vertical = (0.5 * ratio).dp))

            // 描述显示
            Text(
                text = description,
                fontSize = (7 * ratio).sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun EnviFactorCardDetail(
    ratio: Float,
    factorName: String,
    facterValue: Float,
    valueUnit: String,
    @DrawableRes sourceId: Int,
    status: String,
    maxValue: Float,
    minValue: Float,
    suggestion: String
) {
    Row(modifier = Modifier.size((160 * ratio).dp, (63 * ratio).dp)) {
        val connorDp = (10 * ratio).dp

        // 信息卡
        Card(
            modifier = Modifier
                .size((125 * ratio).dp, (65 * ratio).dp),
            elevation = CardDefaults.cardElevation(defaultElevation = (4 * ratio).dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(topStart = connorDp, bottomStart = connorDp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = (5 * ratio).dp, horizontal = (9 * ratio).dp),
                verticalArrangement = Arrangement.Center,
            ) {
                // 顶部信息
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // 图片与解释文字的显示
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(sourceId),
                            contentDescription = factorName,
                            modifier = Modifier
                                .size((15 * ratio).dp)
                                .clip(RoundedCornerShape(100)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.padding(horizontal = (2 * ratio).dp))
                        // 文字显示
                        Text(factorName, fontSize = (10 * ratio).sp, color = Color.Black)
                    }

                    // 状态显示
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xA4E0F159)),
                        shape = RoundedCornerShape(40)
                    ) {
                        Text(
                            text = status,
                            modifier = Modifier.padding(horizontal = (4 * ratio).dp),
                            color = Color(0xFF8BC34A)
                        )
                    }
                }

                // 数值显示
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val color = Color(0xE13F80F3)
                    Text(
                        String.format("%.0f", facterValue),
                        fontSize = (19 * ratio).sp,
                        color = color,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        valueUnit,
                        fontSize = (18 * ratio).sp,
                        color = color,
                    )
                }

                // 进度条
                LinearProgressIndicator(
                    progress = { (facterValue - minValue) / (maxValue - minValue) },
                    modifier = Modifier.size(width = (105 * ratio).dp, height = (6 * ratio).dp),
                    color = Color(0xFF869A06),
                    trackColor = Color(0x7CC7C4C4),
                    gapSize = (1 * ratio).dp
                )

                // 提示字
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val color = Color(0xCE212020)
                    val size = (7 * ratio).sp
                    val textList = listOf(
                        String.format("%.0f", minValue),
                        suggestion,
                        String.format("%.0f", maxValue)
                    )
                    textList.forEach { textContent ->
                        Text(
                            text = textContent,
                            fontSize = size,
                            color = color
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding((1.5 * ratio).dp))

        // 图像唤出按键卡
        Card(
            modifier = Modifier.fillMaxHeight(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(topEnd = connorDp, bottomEnd = connorDp),
            elevation = CardDefaults.cardElevation(defaultElevation = (4 * ratio).dp)
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                        contentDescription = "进入曲线图"
                    )

                    Image(
                        painter = painterResource(R.drawable.curve_image),
                        contentDescription = "曲线图标",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size((60 * ratio).dp, (40 * ratio).dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DeviceInfoCard(
    ratio: Float,
    deviceName: String,
    status: Boolean,
    mode: String,
    @DrawableRes resourceId: Int,

    ) {
    val state = if (status) "开启" else "关闭"
    val transColor = if (status) 1f else 0.7f
    val elevation = if (status) 3 else 0

    Card(
        modifier = Modifier
            .size((80 * ratio).dp, (70 * ratio).dp)
            .alpha(transColor),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
        shape = RoundedCornerShape(25),
        elevation = CardDefaults.cardElevation(defaultElevation = (elevation * ratio).dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding((5 * ratio).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // 顶部栏
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = deviceName,
                    fontSize = (10 * ratio).sp,
                    color = Color(0xDA020202),
                    fontWeight = FontWeight.Bold
                )
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF8BC34A)),
                    shape = RoundedCornerShape(40),
                ) {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = (4 * ratio).dp,
                            vertical = (0.5 * ratio).dp
                        ),
                        text = mode,
                        fontSize = (7 * ratio).sp,
                        color = Color(0xFFFFFFFF)
                    )
                }
            }

            // 图像
            Image(
                painter = painterResource(resourceId),
                contentDescription = deviceName,
                modifier = Modifier
                    .size((30 * ratio).dp)
                    .clip(RoundedCornerShape(100)),
                contentScale = ContentScale.Crop,
            )

            // 状态
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0x9FE0EA7C)),
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    modifier = Modifier.padding(
                        horizontal = (5 * ratio).dp,
                        vertical = (1 * ratio).dp
                    ),
                    text = state,
                    fontSize = (7 * ratio).sp,
                    color = Color(0xFF4CAF50)
                )
            }
        }
    }
}

@Composable
fun CtrlDeviceModeCard(
    ratio: Float
) {
    val buttonCornerDp = (6 * ratio).dp

    Card(
        modifier = Modifier.size((170 * ratio).dp, (50 * ratio).dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(15),
        elevation = CardDefaults.cardElevation(defaultElevation = (2 * ratio).dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding((5 * ratio).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // 顶部栏
            Row(
                modifier = Modifier.fillMaxWidth(0.95f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(end = (2 * ratio).dp),
                    text = "控制模式选择",
                    color = Color(0xFF000000),
                    fontSize = (8 * ratio).sp,
                    fontWeight = FontWeight.Bold
                )
                Box(
                    modifier = Modifier
                        .height((1.5 * ratio).dp)
                        .background(
                            color = Color.Blue,
                            shape = RoundedCornerShape(100)
                        )
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 选择按键
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SelectButton(
                        selected = true,
                        onClick = {},
                        ratio = ratio,
                        icon = Icons.Default.BackHand,
                        text = "手动控制",
                        roundCornerShape = RoundedCornerShape(
                            topStart = buttonCornerDp,
                            bottomStart = buttonCornerDp
                        ),
                        selectedColor = Color(0xCB673AB7),
                        unSelectedColor = Color(0xFFFFFFFF)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = (1 * ratio).dp))
                    SelectButton(
                        selected = false,
                        onClick = {},
                        ratio = ratio,
                        icon = Icons.Default.Person,
                        text = "智能控制",
                        roundCornerShape = RoundedCornerShape(
                            topEnd = buttonCornerDp,
                            bottomEnd = buttonCornerDp
                        ),
                        selectedColor = Color(0xCB673AB7),
                        unSelectedColor = Color(0xFFFFFFFF)
                    )
                }

                // 解释框
                Card(
                    modifier = Modifier.size((50 * ratio).dp, (20 * ratio).dp),
                    shape = RoundedCornerShape(15),
                    colors = CardDefaults.cardColors(containerColor = Color(0x60FF5722)),
                    border = BorderStroke((0.5 * ratio).dp, Color(0x90FF5722))
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "手动控制" + ":",
                            color = Color(0xFFB6421F),
                            fontSize = (7 * ratio).sp,
                            fontWeight = FontWeight.Bold
                            )
                        Text(text = "期间将禁止自动控制",
                            color = Color(0xFFB6421F),
                            fontSize = (5 * ratio).sp,
                        )
                    }
                }
            }
        }
    }
}