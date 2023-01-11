package br.com.devcapu.jetpackcomposetest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    body1 = TextStyle(
        fontWeight = FontWeight(400),
        fontSize = 16.sp,
        lineHeight = 23.sp,
        color = LightGray
    ),
    body2 = TextStyle(
        fontWeight = FontWeight(700),
        fontSize = 16.sp,
        lineHeight = 26.sp,
        color = DarkGray
    ),
    h4 = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight(700),
        lineHeight = 42.sp,
        color = DarkGray,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight(400),
        lineHeight = 19.sp
    )
)