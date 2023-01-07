package br.com.devcapu.jetpackcomposetest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 23.sp,
        color = Color(0xFFA3A3A3)
    ),
    body2 = TextStyle(
        fontWeight = FontWeight(700),
        fontSize = 16.sp,
        lineHeight = 26.sp,
        color = Color(0xFF464646)
    ),
    h4 = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight(700),
        lineHeight = 42.sp,
        color = Color(0xFF464646),
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(400),
        lineHeight = 19.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)