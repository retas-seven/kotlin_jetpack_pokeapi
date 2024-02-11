package com.example.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.ScreenRoute
import com.example.app.presentation.home.HomeScreen
import com.example.app.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    //-----------------
                    // 画面遷移の定義
                    //-----------------
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.HomeScreen.route,
                    ) {
                        // ホーム画面
                        composable(route = ScreenRoute.HomeScreen.route) {
                            HomeScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
