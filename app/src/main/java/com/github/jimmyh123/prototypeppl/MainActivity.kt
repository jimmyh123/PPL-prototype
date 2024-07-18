package com.github.jimmyh123.prototypeppl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.github.jimmyh123.prototypeppl.Dimensions.defaultMargin
import com.github.jimmyh123.prototypeppl.Dimensions.defaultTitleFontSize
import com.github.jimmyh123.prototypeppl.Dimensions.prototypeColour
import com.github.jimmyh123.prototypeppl.ui.theme.PrototypePPLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrototypePPLTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrototypePPLTheme {
        Greeting("Android")
    }
}

@Composable
fun SplashScreen() {
    Column(Modifier.fillMaxSize()) {
        PrototypeCard("Lsdf")
        PrototypeCard("fdjksn")
    }
}

@Composable
fun PrototypeCard(
    text: String? = null,
    fontSize: Float = defaultTitleFontSize,
    cardPadding: Dp = defaultMargin,
    backgroundColor: Color = prototypeColour,
    cardModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(cardPadding)
            .background(backgroundColor)
            .then(cardModifier),
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            text?.let {
                Text(
                    modifier = textModifier,
                    text = text,
                    fontSize = fontSizeSP(fontSize)
                )
            }
        }
    }
}

fun fontSizeSP(fontSize: Float): TextUnit = TextUnit(fontSize, TextUnitType.Sp)

object Dimensions {
    val zeroDp = 0.dp
    val tinyMargin = 4.dp
    val smallMargin = 8.dp
    val mediumMargin = 12.dp
    val defaultMargin = 16.dp
    val largeMargin = 20.dp

    const val smallFontSize = 12f
    const val defaultFontSize = 16f
    const val defaultHeadlineFontSize = 18f
    const val defaultLargeFontSize = 20f
    const val defaultTitleFontSize = 22f
    const val defaultExtraLargeFontSize = 24f

    val defaultButtonPadding = PaddingValues(
        horizontal = defaultMargin,
        vertical = mediumMargin
    )

    val prototypeColour = Color.Gray
}

@PreviewLargeScreens
@Composable
fun SplashScreenPreview() = RenderPreview {
    SplashScreen()
}

@Preview(name = "Small Phone", device = "spec:id=small_phone,shape=Normal,width=360,height=640,unit=dp,dpi=420", showSystemUi = true)
@Preview(name = "Large Phone", device = Devices.PIXEL_7_PRO, showSystemUi = true)
annotation class PreviewSmallAndLargeScreens

@Preview(name = "Large Phone", device = Devices.PIXEL_7_PRO, showSystemUi = true)
annotation class PreviewLargeScreens

@Composable
fun RenderPreview(content: @Composable () -> Unit) = PrototypePPLTheme(content = content)