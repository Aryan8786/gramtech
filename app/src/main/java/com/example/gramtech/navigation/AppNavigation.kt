package com.example.gramtech.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gramtech.components.GramTechBottomBar
import com.example.gramtech.components.GramTechTopBar
import com.example.gramtech.data.SampleData
import com.example.gramtech.screens.HomeScreen
import com.example.gramtech.screens.LearnScreen
import com.example.gramtech.screens.LessonDetailScreen
import com.example.gramtech.screens.ProfileScreen
import com.example.gramtech.screens.SchemeDetailScreen
import com.example.gramtech.screens.SchemesScreen
import com.example.gramtech.screens.SellOnlineScreen
import com.example.gramtech.screens.SplashScreen
import com.example.gramtech.screens.StoriesScreen
import com.example.gramtech.screens.ToolsScreen
import com.example.gramtech.screens.WebPortalScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Check which screens show TopBar and BottomBar
    val isSplashScreen = currentRoute == Screen.Splash.route
    val isDetailScreen = currentRoute?.startsWith("lesson_detail") == true ||
            currentRoute?.startsWith("scheme_detail") == true ||
            currentRoute?.startsWith("web_portal") == true ||
            currentRoute == Screen.Stories.route


    val shouldShowBottomBar = !isSplashScreen && !isDetailScreen

    Scaffold(
        topBar = {
            if (!isSplashScreen && !isDetailScreen) {
                when (currentRoute) {
                    Screen.Home.route -> GramTechTopBar(
                        title = "GramTech",
                        subtitle = "Technology for Rural Startups"
                    )
                    Screen.Learn.route -> GramTechTopBar(
                        title = "Learn & Grow",
                        subtitle = "Digital Literacy Lessons"
                    )
                    Screen.Schemes.route -> GramTechTopBar(
                        title = "Government Schemes",
                        subtitle = "Business Support Directory"
                    )
                    Screen.Tools.route -> GramTechTopBar(
                        title = "Business Tools",
                        subtitle = "Financial Calculators"
                    )
                    Screen.SellOnline.route -> GramTechTopBar(
                        title = "Sell Online",
                        subtitle = "E-Commerce Guide & Showcase",
                        showBackButton = true,
                        onBackClick = { navController.popBackStack() }
                    )
                    Screen.Profile.route -> GramTechTopBar(
                        title = "About GramTech",
                        subtitle = "College CEP Project"
                    )
                }
            }
        },
        bottomBar = {
            if (shouldShowBottomBar) {
                GramTechBottomBar(
                    currentRoute = currentRoute,
                    onNavigateToRoute = { targetRoute ->
                        navController.navigate(targetRoute) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(
                    onTimeout = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Splash.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToLearn = { navController.navigate(Screen.Learn.route) },
                    onNavigateToSchemes = { navController.navigate(Screen.Schemes.route) },
                    onNavigateToTools = { navController.navigate(Screen.Tools.route) },
                    onNavigateToSellOnline = { navController.navigate(Screen.SellOnline.route) },
                    onNavigateToStories = { navController.navigate(Screen.Stories.route) }
                )
            }

            composable(Screen.Learn.route) {
                LearnScreen(
                    onLessonClick = { lessonId ->
                        navController.navigate(Screen.LessonDetail.createRoute(lessonId))
                    }
                )
            }

            composable(
                route = Screen.LessonDetail.route,
                arguments = listOf(navArgument("lessonId") { type = NavType.StringType })
            ) { backStackEntry ->
                val lessonId = backStackEntry.arguments?.getString("lessonId")
                val lesson = SampleData.lessons.find { it.id == lessonId }
                LessonDetailScreen(
                    lesson = lesson,
                    onBackClick = { navController.popBackStack() }
                )
            }

            composable(Screen.Schemes.route) {
                SchemesScreen(
                    onSchemeClick = { schemeId ->
                        navController.navigate(Screen.SchemeDetail.createRoute(schemeId))
                    },
                    onOpenWebPortal = { portalUrl, portalTitle ->
                        navController.navigate(Screen.WebPortal.createRoute(portalUrl, portalTitle))
                    }
                )
            }

            composable(
                route = Screen.SchemeDetail.route,
                arguments = listOf(navArgument("schemeId") { type = NavType.StringType })
            ) { backStackEntry ->
                val schemeId = backStackEntry.arguments?.getString("schemeId")
                val scheme = SampleData.schemes.find { it.id == schemeId }
                SchemeDetailScreen(
                    scheme = scheme,
                    onBackClick = { navController.popBackStack() },
                    onOpenWebPortal = { portalUrl, portalTitle ->
                        navController.navigate(Screen.WebPortal.createRoute(portalUrl, portalTitle))
                    }
                )
            }

            composable(
                route = Screen.WebPortal.route,
                arguments = listOf(
                    navArgument("url") {
                        type = NavType.StringType
                        defaultValue = ""
                    },
                    navArgument("title") {
                        type = NavType.StringType
                        defaultValue = "Web Portal"
                    }
                )
            ) { backStackEntry ->
                val rawUrl = backStackEntry.arguments?.getString("url") ?: ""
                val rawTitle = backStackEntry.arguments?.getString("title") ?: "Web Portal"
                val url = try {
                    java.net.URLDecoder.decode(rawUrl, java.nio.charset.StandardCharsets.UTF_8.name())
                } catch (_: Exception) { rawUrl }
                val title = try {
                    java.net.URLDecoder.decode(rawTitle, java.nio.charset.StandardCharsets.UTF_8.name())
                } catch (_: Exception) { rawTitle }

                WebPortalScreen(
                    url = url,
                    title = title,
                    onBackClick = { navController.popBackStack() }
                )
            }


            composable(Screen.Tools.route) {
                ToolsScreen()
            }

            composable(Screen.SellOnline.route) {
                SellOnlineScreen()
            }

            composable(Screen.Stories.route) {
                StoriesScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen(
                    onNavigateToStories = { navController.navigate(Screen.Stories.route) }
                )
            }
        }
    }
}
