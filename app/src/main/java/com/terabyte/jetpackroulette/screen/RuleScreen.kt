package com.terabyte.jetpackroulette.screen

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terabyte.jetpackroulette.R
import com.terabyte.jetpackroulette.ui.theme.Red
import com.terabyte.jetpackroulette.utils.NumberUtil
import kotlin.math.roundToInt

@Preview(showBackground=true, showSystemUi = true)
@Composable
fun RuleScreen() {
    var rotationValue = remember {
        mutableStateOf(0f)
    }
    var number = remember {
        mutableStateOf(0)
    }
    val angle = animateFloatAsState(
        targetValue = rotationValue.value,
        animationSpec = tween(
            durationMillis = 2000,
            easing = LinearOutSlowInEasing
        ),
        finishedListener = {
            var index = ((360f - it%360f) / (360f/NumberUtil.list.size)).roundToInt()
            if(index>NumberUtil.list.size) index = NumberUtil.list.size-1
            number.value = NumberUtil.list[index]
        })
    


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = number.value.toString(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            textAlign = TextAlign.Center

        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter= painterResource(id = R.drawable.roulette),
                contentDescription = "Roulette",
                modifier = Modifier
                    .fillMaxSize()
                    .rotate(angle.value)
            )
            Image(
                painter= painterResource(id = R.drawable.arrow),
                contentDescription = "Arrow",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Button(
            onClick = {
                rotationValue.value = (720 until 1440).random().toFloat() + angle.value
            },
            colors = ButtonDefaults.buttonColors(containerColor = Red),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "Start",
                color = Color.White
            )
        }
    }
}