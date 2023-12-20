package com.alvine.composenavigation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginPage() {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        var (username, onUserNameChange) = remember {
            mutableStateOf("")
        }
        var (password, onPasswordChange) = remember { mutableStateOf("") }
        var (chekcked, onCheckedChanged) = remember {
            mutableStateOf(false)
        }
        Column {
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = username,
                onValueChange = onUserNameChange,
                label = {
                    Text(text = "Username")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                modifier = Modifier.padding(16.dp),
                value = password,
                onValueChange = onPasswordChange,
                label = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(checked = chekcked, onCheckedChange = onCheckedChanged)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Remember me")
                }
                Spacer(modifier = Modifier.width(2.dp))
                TextButton(onClick = { /*TODO*/ },
                    modifier=Modifier,
                    colors = ButtonDefaults.buttonColors()
                    ) {
                    Text(text = "Forgot Password")
                }
            }

            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
                ) {
                Text(text = "Login")
            }
            Row (
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .wrapContentSize(align = Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically
            ){
             Text(text = "Don't Have an Account")
                    Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors()
                    ) {
                    Text(text = "Sign UP")
                }
            }

        }
    }
}

@Preview
@Composable
fun LoginPrev() {
    LoginPage()
}