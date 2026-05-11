package com.look.greenhousemanage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.look.greenhousemanage.ui.theme.GreenhouseManageTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.look.greenhousemanage.data.navItems
import com.look.greenhousemanage.ui.page.MainPage
import com.look.greenhousemanage.ui.page.ManagePage
import com.look.greenhousemanage.ui.page.MonitorPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    GreenhouseManageTheme {

        // 对状态做记录和追踪
        var selectedIndex by remember { mutableIntStateOf(0) }

        Scaffold(
            contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
            // 整体样式
            modifier = Modifier.fillMaxSize(),
            // 底部导航栏
            bottomBar = {
                NavigationBar {
                    navItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.btnName
                                )
                            },
                            label = { Text(item.btnName) }
                        )
                    }
                }
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            when (selectedIndex) {
                0 -> MainPage(modifier)
                1 -> MonitorPage(modifier)
                2 -> ManagePage(modifier)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SuperPreview() {
    MainScreen()
}