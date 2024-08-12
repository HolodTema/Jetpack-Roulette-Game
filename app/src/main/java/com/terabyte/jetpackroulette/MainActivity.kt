package com.terabyte.jetpackroulette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.terabyte.jetpackroulette.screen.RuleScreen
import com.terabyte.jetpackroulette.ui.theme.GreenBackground
import com.terabyte.jetpackroulette.ui.theme.JetpackRouletteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackRouletteTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = GreenBackground
                ) { _ ->
                    RuleScreen()
                }
            }
        }
    }
}