package com.alvine.composenavigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignUpState {

    var firstName: String by mutableStateOf("")
        private set
    var lastName: String by mutableStateOf("")
        private set
    var emailAddress: String by mutableStateOf("")
        private set
    var password: String by mutableStateOf("")
        private set
    var confirmPassword: String by mutableStateOf("")
        private set
    var checked: Boolean by mutableStateOf(false)
        private set

   val enableButton= firstName.isNotBlank() &&
           lastName.isNotBlank() &&
           password.isNotBlank() &&
           confirmPassword.isNotBlank()
    fun firstNameChange(newValue:String){
         firstName=newValue
    }
 fun lastNameChange(newValue:String){
         lastName=newValue
    }
 fun passwordChange(newValue:String){
         password=newValue
    }
 fun confirmPasswordChange(newValue:String){
         confirmPassword=newValue
    }
 fun emailChange(newValue:String){
         emailAddress=newValue
    }
 fun checkedChange(newValue:Boolean){
         checked=newValue
    }


}
