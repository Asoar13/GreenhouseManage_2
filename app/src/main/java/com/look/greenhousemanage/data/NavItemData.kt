package com.look.greenhousemanage.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val btnName: String,
    val icon: ImageVector
)

val navItems = listOf(
    NavItem("首页", Icons.Default.Home),
    NavItem("环境监测", Icons.Default.Search),
    NavItem("设备管理", Icons.Default.Settings),
    NavItem("AI分析", Icons.Default.Person)
)