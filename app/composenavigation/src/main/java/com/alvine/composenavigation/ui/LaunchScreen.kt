package com.alvine.composenavigation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvine.composenavigation.R
import com.alvine.composenavigation.ui.theme.Gold

@Composable
fun LaunchScreen() {
    Surface(
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    val path = Path()
                    val x = size.width
//                    val y = size.height
                    val center = size.center
                    path.apply {
                        moveTo(0f, 0f)
                        lineTo(x, 0f)
                        cubicTo(
                            x1 = x,
                            y1 = center.y / 2,
                            x2 = x,
                            y2 = x,
                            x3 = 0f,
                            y3 = center.y
                        )
                    }
                    drawPath(path = path, color = Gold)
                }
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Hello",
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = "Welcome to Compose Basics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.size(16.dp))
              Image(
                  painter = painterResource(id = R.drawable.android),
                  contentDescription = null,
                  modifier = Modifier.size(34.dp)
              )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .wrapContentSize(align = Alignment.BottomCenter)
            ) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(text = "Sign In")
                }
                Spacer(modifier = Modifier.size(12.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors()
                ) {
                    Text(text = "Sign Up")
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun LaunchScreenPre() {
    LaunchScreen()

}