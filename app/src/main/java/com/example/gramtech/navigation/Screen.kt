package com.example.gramtech.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook

import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Learn : Screen("learn")
    object LessonDetail : Screen("lesson_detail/{lessonId}") {
        fun createRoute(lessonId: String) = "lesson_detail/$lessonId"
    }
    object Schemes : Screen("schemes")
    object SchemeDetail : Screen("scheme_detail/{schemeId}") {
        fun createRoute(schemeId: String) = "scheme_detail/$schemeId"
    }
    object Tools : Screen("tools")
    object SellOnline : Screen("sell_online")
    object Stories : Screen("stories")
    object Profile : Screen("profile")
    object WebPortal : Screen("web_portal?url={url}&title={title}") {
        fun createRoute(url: String, title: String): String {
            val encodedUrl = java.net.URLEncoder.encode(url, java.nio.charset.StandardCharsets.UTF_8.name())
            val encodedTitle = java.net.URLEncoder.encode(title, java.nio.charset.StandardCharsets.UTF_8.name())
            return "web_portal?url=$encodedUrl&title=$encodedTitle"
        }
    }
}


sealed class BottomNavItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : BottomNavItem(
        route = Screen.Home.route,
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object Learn : BottomNavItem(
        route = Screen.Learn.route,
        title = "Learn",
        selectedIcon = Icons.AutoMirrored.Filled.MenuBook,
        unselectedIcon = Icons.AutoMirrored.Outlined.MenuBook
    )


    object Schemes : BottomNavItem(
        route = Screen.Schemes.route,
        title = "Schemes",
        selectedIcon = Icons.Filled.AccountBalance,
        unselectedIcon = Icons.Outlined.AccountBalance
    )

    object Tools : BottomNavItem(
        route = Screen.Tools.route,
        title = "Tools",
        selectedIcon = Icons.Filled.Calculate,
        unselectedIcon = Icons.Outlined.Calculate
    )

    object Profile : BottomNavItem(
        route = Screen.Profile.route,
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person
    )
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Learn,
    BottomNavItem.Schemes,
    BottomNavItem.Tools,
    BottomNavItem.Profile
)
