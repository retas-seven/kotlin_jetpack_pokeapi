package com.example.app.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app.R

/**
 * デフォルトフォントの定義
 */
val Kaisei = FontFamily(
        Font(R.font.kaiseiopti_regular, FontWeight.W400),
        Font(R.font.kaiseiopti_medium, FontWeight.W500),
        Font(R.font.kaiseiopti_bold, FontWeight.W700)
)

// Set of Material typography styles to start with
//val Typography = Typography(
//        bodyLarge = TextStyle(
//                fontFamily = Kaisei, // FontFamily.Defaultから変更
//                fontWeight = FontWeight.Normal,
//                fontSize = 16.sp,
//                lineHeight = 24.sp,
//                letterSpacing = 0.5.sp
//        ),
//)

val DefaultTypography = Typography()
val Typography = DefaultTypography.copy(
        displayLarge   = DefaultTypography.displayLarge.copy(fontFamily = Kaisei),
        displayMedium  = DefaultTypography.displayMedium.copy(fontFamily = Kaisei),
        displaySmall   = DefaultTypography.displaySmall.copy(fontFamily = Kaisei),
        headlineLarge  = DefaultTypography.headlineLarge.copy(fontFamily = Kaisei),
        headlineMedium = DefaultTypography.headlineMedium.copy(fontFamily = Kaisei),
        headlineSmall  = DefaultTypography.headlineSmall.copy(fontFamily = Kaisei),
        titleLarge     = DefaultTypography.titleLarge.copy(fontFamily = Kaisei),
        titleMedium    = DefaultTypography.titleMedium.copy(fontFamily = Kaisei),
        titleSmall     = DefaultTypography.titleSmall.copy(fontFamily = Kaisei),
        bodyLarge      = DefaultTypography.bodyLarge.copy(fontFamily = Kaisei),
        bodyMedium     = DefaultTypography.bodyMedium.copy(fontFamily = Kaisei),
        bodySmall      = DefaultTypography.bodySmall.copy(fontFamily = Kaisei),
        labelLarge     = DefaultTypography.labelLarge.copy(fontFamily = Kaisei),
        labelMedium    = DefaultTypography.labelMedium.copy(fontFamily = Kaisei),
        labelSmall     = DefaultTypography.labelSmall.copy(fontFamily = Kaisei),
)
