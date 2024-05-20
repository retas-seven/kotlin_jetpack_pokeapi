package com.example.app.presentation.mytest

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app.data.room.entity.User
import com.example.app.presentation.ui.theme.Kaisei
import com.example.app.presentation.ui.theme.myTestStyle
import com.example.app.presentation.ui.theme.myTestStyle02

/**
 * テスト用画面
 */
@Composable
fun MyTest(
    navController: NavController? = null,
    viewModel: MyTestViewModel = hiltViewModel(),
) {

    LaunchedEffect(Unit) {
        viewModel.seveUser(
            User(
                id = 1,
                firstName = "taro",
                lastName = "yamada都"
            )
        )
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        val myTestStyle02 = TextStyle(
            fontFamily = Kaisei, // FontFamily.Default,
            fontSize = 64.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 0.sp,
            letterSpacing = 0.sp
        )

        val density = LocalDensity.current
        println(">>>density: $density")

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(1.dp, Color.Red)
        ) {
            Row (
                modifier = Modifier
                    .heightIn(64.dp)
            ) {
                Text(
                    "開始時テスト ",
                    style = myTestStyle02,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    lineHeight = TextUnit.Unspecified,
                    modifier = Modifier
                        .border(1.dp, Color.Blue)
                        .background(Color.Yellow)
                        .onGloballyPositioned { coordinates ->
                            var textSize = coordinates.size.toSize()
                            var textSizedp = with(density) { coordinates.size.toSize().toDpSize() }
                            println(">>>textSize1: $textSize, $textSizedp")
                        }
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Row (
                modifier = Modifier
                    .height(64.dp)
                    .width(30.dp)
                    .border(1.dp, Color.Black)
                    .background(Color.Green)
            ) {
                Text("64")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Row (
                modifier = Modifier
                    .heightIn(min = 74.28.dp)
                    .width(30.dp)
                    .border(1.dp, Color.Black)
                    .background(Color.Green)
            ) {
                Text("74.28")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                "Hello World  ", //.repeat(10),
                style = myTestStyle02,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                lineHeight = TextUnit.Unspecified,
                modifier = Modifier
                    .border(1.dp, Color.Blue)
                    .background(Color.Yellow)
                    .width(300.dp)
                    .onGloballyPositioned { coordinates ->
                        var textSize = coordinates.size.toSize()
                        var textSizedp = with(density) { coordinates.size.toSize().toDpSize() }
                        println(">>>textSize1: $textSize, $textSizedp")
                    }
            )

//            Spacer(modifier = Modifier.width(16.dp))
//
//            Row (
//                modifier = Modifier
//                    .height(64.dp)
//                    .width(30.dp)
//                    .border(1.dp, Color.Black)
//                    .background(Color.Green)
//            ) {}
//
//            Spacer(modifier = Modifier.height(36.dp))
//            Text(
//                text = "開始時のテスト",
//                modifier = Modifier
//                    .border(1.dp, Color.Blue)
//                    .background(Color.Yellow),
//                style = myTestStyle.merge(
//                    TextStyle(
//                        lineHeight = 64.sp,
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = true
//                        ),
//                        lineHeightStyle = LineHeightStyle(
//                            alignment = LineHeightStyle.Alignment.Top,
//                            trim = LineHeightStyle.Trim.FirstLineTop
//                        )
//                    )
//                )
//            )
        }
    }
}

@Composable
@Preview
fun MyTestPreview() {
    MyTest()
}