package com.look.greenhousemanage.ui.unit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SelectButton(
            selected = false,
            onClick = {},
            ratio = 3.0f,
            icon = Icons.Default.BackHand,
            text = "手动控制",
            roundCornerShape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
            selectedColor = Color(0xCB673AB7),
            unSelectedColor = Color(0xFFFFFFFF)
        )
    }
}

@Composable
fun SelectButton(
    selected: Boolean = true,
    onClick: () -> Unit = {},
    ratio: Float = 1.0f,
    icon: ImageVector,
    text: String,
    roundCornerShape: RoundedCornerShape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
    selectedColor: Color = Color.Green,
    unSelectedColor: Color = Color.White,
) {
    val containerColor = if(selected) selectedColor else unSelectedColor
    val contentColor = if(selected) unSelectedColor else selectedColor
    val elevation = if(selected) (4 * ratio).dp else (1 * ratio).dp
    val newRatio = if(selected) ratio * 0.95f else ratio

    Button(
        onClick = onClick,
        modifier = Modifier.size((50 * newRatio).dp, (15 * newRatio).dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            disabledContainerColor = unSelectedColor
        ),
        shape = roundCornerShape,
        contentPadding = PaddingValues((2 * newRatio).dp, (1 * newRatio).dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = elevation)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size((8 * newRatio).dp),
                tint = contentColor
            )
            Text(
                text = text,
                fontSize = (8 * newRatio).sp,
                color = contentColor,
            )
        }
    }
}