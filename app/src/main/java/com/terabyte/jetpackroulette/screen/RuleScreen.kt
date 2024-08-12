package com.terabyte.jetpackroulette.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terabyte.jetpackroulette.R
import com.terabyte.jetpackroulette.ui.theme.Red

@Preview(showBackground=true, showSystemUi = true)
@Composable
fun RuleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "0",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .wrapContentHeight()
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