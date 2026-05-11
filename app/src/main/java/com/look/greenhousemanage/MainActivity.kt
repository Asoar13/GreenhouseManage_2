package com.look.greenhousemanage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.look.greenhousemanage.data.navItems
import com.look.greenhousemanage.ui.page.MainPage
import com.look.greenhousemanage.ui.page.ManagePage
import com.look.greenhousemanage.ui.page.MonitorPage
import com.look.greenhousemanage.ui.theme.GreenhouseManageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen() {
    GreenhouseManageTheme {
        var selectedIndex by remember { mutableIntStateOf(0) }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
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
                            label = {
                                Text(
                                    text = item.btnName,
                                    style = MaterialTheme.typography.labelSmall
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                }
            }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                when (selectedIndex) {
                    0 -> MainPage()
                    1 -> MonitorPage()
                    2 -> ManagePage()
                    3 -> AiAnalysisPage()
                }
            }
        }
    }
}

@Composable
fun AiAnalysisPage(modifier: Modifier = Modifier) {
    // 临时占位页面
    Column(modifier = modifier.fillMaxSize()) {
        com.look.greenhousemanage.ui.unit.PageTopAppBar(
            title = "AI 智能分析",
            subtitle = "基于大数据提供科学种植建议"
        )
        HorizontalDivider(
            color = MaterialTheme.colorScheme.outlineVariant,
            thickness = 1.dp
        )
        // AI分析页面内容待实现
    }
}