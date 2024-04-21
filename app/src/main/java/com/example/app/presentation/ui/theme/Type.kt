package com.example.app.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app.R

/**
 * 追加フォントの定義
 */
val Kaisei = FontFamily(
    Font(R.font.kaiseiopti_regular, FontWeight.W400),
    Font(R.font.kaiseiopti_medium, FontWeight.W600),
    Font(R.font.kaiseiopti_bold, FontWeight.W800)
)

val tmp = Typography()
val Typography = Typography().copy(
        displayLarge   = tmp.displayLarge.copy(fontFamily = Kaisei),
        displayMedium  = tmp.displayMedium.copy(fontFamily = Kaisei),
        displaySmall   = tmp.displaySmall.copy(fontFamily = Kaisei),
        headlineLarge  = tmp.headlineLarge.copy(fontFamily = Kaisei),
        headlineMedium = tmp.headlineMedium.copy(fontFamily = Kaisei),
        headlineSmall  = tmp.headlineSmall.copy(fontFamily = Kaisei),
        titleLarge     = tmp.titleLarge.copy(fontFamily = Kaisei),
        titleMedium    = tmp.titleMedium.copy(fontFamily = Kaisei),
        titleSmall     = tmp.titleSmall.copy(fontFamily = Kaisei),
        bodyLarge      = tmp.bodyLarge.copy(fontFamily = Kaisei),
        bodyMedium     = tmp.bodyMedium.copy(fontFamily = Kaisei),
        bodySmall      = tmp.bodySmall.copy(fontFamily = Kaisei),
        labelLarge     = tmp.labelLarge.copy(fontFamily = Kaisei),
        labelMedium    = tmp.labelMedium.copy(fontFamily = Kaisei),
        labelSmall     = tmp.labelSmall.copy(fontFamily = Kaisei),
)

// mytest
val myTestStyle = TextStyle(
        fontFamily = Kaisei, // FontFamily.Default,
        fontSize = 64.sp,
        fontWeight = FontWeight.Normal,
        // TODO: lineHeightを設定すると、画面タイトルの上下位置がずれる。要確認。
//      lineHeight = 32.sp,
        letterSpacing = 0.sp
)
val myTestStyle02 = TextStyle(
        fontFamily = Kaisei, // FontFamily.Default,
        fontSize = 64.sp,
        fontWeight = FontWeight.Normal,
//      lineHeight = 0.sp,
        letterSpacing = 0.sp
)