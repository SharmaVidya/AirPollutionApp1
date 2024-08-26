package com.learning.airpollutionapp.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.airpollutionapp.ProgressBar


@Composable
fun AirPollutionScreen(
    modifier: Modifier= Modifier,
    state: AirState
) {
    var AirData :Boolean by remember{ mutableStateOf(false) }
    Spacer(modifier = modifier.padding(20.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = modifier
                .padding(8.dp)
                .background(color = Color.Gray.copy(alpha = .6f))

        ) {
            Text(
                text = "Air Pollution Info",
                fontSize = 30.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Spacer(modifier = modifier.padding(10.dp))

        Button(onClick = {AirData = true}) {
            Text(text = "See Data Here..")

        }
        Spacer(modifier = modifier.padding(30.dp))
        Card (modifier = Modifier.padding(8.dp)
            .align(Alignment.CenterHorizontally
            )){
            ProgressBar()
        }
        if (AirData) {
            Column {
                Text(text = "${state.result.list}")
            }
        }
    }
}
