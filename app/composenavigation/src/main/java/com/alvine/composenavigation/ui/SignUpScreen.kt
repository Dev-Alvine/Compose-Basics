package com.alvine.composenavigation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alvine.composenavigation.SignUpState

@Composable
fun SignUpScreen() {
    val signUpState= SignUpState()
    Surface (
        color = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onSurface
    ){
    Column (

        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Sign UP Screen",
            style = MaterialTheme.typography.headlineMedium,
             modifier = Modifier.padding(16.dp)
        )
      Row (
          modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp)
      ){
          OutlinedTextField(
              value = signUpState.firstName,
              onValueChange = { signUpState.firstNameChange(it) },
              modifier = Modifier.weight(1f),
              shape = MaterialTheme.shapes.medium,
              label = { Text(text = "first name")}
          )
          Spacer(modifier = Modifier.size(8.dp))

          OutlinedTextField(
              value = signUpState.lastName,
              onValueChange = { signUpState.lastNameChange(it) },
              modifier = Modifier.weight(1f),
              shape = MaterialTheme.shapes.medium,
              label = { Text(text = "last name")}
          )
      }
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = signUpState.emailAddress,
            onValueChange = { signUpState.emailChange(it) },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text(text = "email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = signUpState.password,
            onValueChange = { signUpState.passwordChange(it) },
            shape = MaterialTheme.shapes.medium,
            label = { Text(text = "password")},
            modifier = Modifier.padding(horizontal = 16.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        OutlinedTextField(
            value = signUpState.confirmPassword,
            onValueChange = { signUpState.confirmPasswordChange(it) },
            shape = MaterialTheme.shapes.medium,
            label = { Text(text = "confirm password")},
            modifier = Modifier.padding(horizontal = 16.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Row (
            modifier = Modifier.padding( 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(
                checked = signUpState.checked,
                onCheckedChange = { signUpState.checkedChange(it) })
              Spacer(modifier = Modifier.size(4.dp))
            Text(text = "Agree to Our Policy")

        }
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Sign Up")
        }
          Row (
              modifier = Modifier
                  .fillMaxSize()
                  .padding(16.dp)
                  .wrapContentSize(align = Alignment.BottomCenter)
          ){
              Text(text = "Already have an account")
              Spacer(modifier = Modifier.size(8.dp))
              Text(
                  text = "Sign In", modifier = Modifier.clickable {

              },
                  color = MaterialTheme.colorScheme.onSurface
              )
          }
    }
    }
}

@Preview
@Composable
fun SignUP() {
    SignUpScreen()

}